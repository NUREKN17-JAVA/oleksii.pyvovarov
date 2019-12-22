package ua.nure.kn.pyvovarov.web;


import java.io.IOException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.ValidationException;

import ua.nure.kn.pyvovarov.usermanagement.domain.User;
import ua.nure.kn.pyvovarov.db.DaoFactory;
import ua.nure.kn.pyvovarov.db.DataBaseException;

public class DeleteServlet extends EditServlet {
	private static final String ID = "id";
	private static final String DELETE_JSP = "/delete.jsp";

	@Override
    protected void showPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(DELETE_JSP).forward(req, resp);
    }

    @Override
    protected User getUser(HttpServletRequest req) throws ParseException, ValidationException {
        User user = new User();
        String idStr = req.getParameter(ID);
        if (idStr != null) {
            user.setId(new Long(idStr));
        }
        return user;
    }

    @Override
    protected void processUser(User user) throws DataBaseException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        DaoFactory.getInstance().getUserDao().delete(user);
    }
}