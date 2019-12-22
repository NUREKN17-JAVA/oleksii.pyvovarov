package ua.nure.kn.pyvovarov.web;


import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;
	
import ua.nure.kn.pyvovarov.usermanagment.domain.User;
import ua.nure.kn.pyvovarov.db.DaoFactory;
import ua.nure.kn.pyvovarov.db.DataBaseException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;

public class EditServlet extends HttpServlet {
	private static final String BROWSE = "/browse";
	private static final String DATE = "date";
	private static final String LAST_NAME = "lastName";
	private static final String FIRST_NAME = "firstName";
	private static final String ID = "id";
	private static final String ERROR_ATTRIBUTE = "error";
	private static final String BROWSE_JSP = "/browse.jsp";
	private static final String EDIT_JSP = "/edit.jsp";
	private static final String CANCEL_BUTTON = "cancelButton";
	private static final String OK_BUTTON = "okButton";

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(OK_BUTTON) != null) {
            doOk(req, resp);
        } else if (req.getParameter(CANCEL_BUTTON) != null) {
            doCancel(req, resp);
        } else {
            showPage(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showPage(req, resp);
    }

    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(EDIT_JSP).forward(req, resp);
    }

    protected void doCancel(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(BROWSE_JSP).forward(req, resp);
    }

    protected void doOk(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = null;
        try {
            user = getUser(req);
        } catch (ValidationException e1) {
            req.setAttribute(ERROR_ATTRIBUTE, e1.getMessage());
            showPage(req, resp);
            return;
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        try {
            processUser(user);
        } catch (DataBaseException | IllegalAccessException | InstantiationException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new ServletException(e);
        }
        req.getRequestDispatcher(BROWSE).forward(req, resp);
    }

    protected User getUser(HttpServletRequest req) throws java.text.ParseException, ValidationException {
        User user = new User();
        String idStr = req.getParameter(ID);
        String firstName = req.getParameter(FIRST_NAME);
        String lastName = req.getParameter(LAST_NAME);
        String dateStr = req.getParameter(DATE);

        if (firstName == null) {
            throw new ValidationException("First name is empty");
        }

        if (lastName == null) {
            throw new ValidationException("Last name is empty");
        }

        if (dateStr == null) {
            throw new ValidationException("Date is empty");
        }

        if (idStr != null) {
            user.setId(new Long(idStr));
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        try {
            user.setDateOfBirth(DateFormat.getInstance().parse(dateStr));
        } catch (ParseException e) {
            throw new ValidationException("Date format is incorrect");
        }
        return user;
    }

    protected void processUser(User user) throws DataBaseException, IllegalAccessException,
            InstantiationException, ClassNotFoundException {
        DaoFactory.getInstance().getUserDao().update(user);
    }
}