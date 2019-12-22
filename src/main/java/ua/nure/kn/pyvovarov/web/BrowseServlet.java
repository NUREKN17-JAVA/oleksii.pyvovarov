package ua.nure.kn.pyvovarov.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;
import ua.nure.kn.pyvovarov.db.DaoFactory;
import ua.nure.kn.pyvovarov.db.DataBaseException;

public class BrowseServlet extends HttpServlet {

	private static final String ADD = "/add";
	private static final String EDIT = "/edit";
	private static final String DELETE = "/delete";
	private static final String ERROR_ATTRIBUTE = "error";
	private static final String DETAILS = "/details";
	private static final String DETAILS_BUTTON = "detailsButton";
	private static final String DELETE_BUTTON = "deleteButton";
	private static final String EDIT_BUTTON = "editButton";
	private static final String ADD_BUTTON = "addButton";
	private static final String BROWSE_JSP = "/browse.jsp";
	private static final String USERS_ATTRIBUTE = "users";

	@Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(ADD_BUTTON) != null) {
            add(req, resp);
        } else if (req.getParameter(EDIT_BUTTON) != null) {
            edit(req, resp);
        } else if (req.getParameter(DELETE_BUTTON) != null) {
            delete(req, resp);
        } else if (req.getParameter(DETAILS_BUTTON) != null) {
            details(req, resp);
        } else {
            browse(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        browse(req, resp);
    }

    private void details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (prepareAnotherUserSrvlet(req, resp)) return;
        req.getRequestDispatcher(DETAILS).forward(req, resp);
    }

    private boolean prepareAnotherUserSrvlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String idStr = req.getParameter("id");
        if (idStr == null || idStr.trim().length() == 0) {
            req.setAttribute(ERROR_ATTRIBUTE, "You must select a user");
            req.getRequestDispatcher(BROWSE_JSP).forward(req, resp);
            return true;
        }
        try {
            User user = DaoFactory.getInstance().getUserDao().find(new Long(idStr));
            req.getSession().setAttribute("user", user);
        } catch (Exception e) {
            req.setAttribute(ERROR_ATTRIBUTE, "ERROR:" + e.toString());
            req.getRequestDispatcher(BROWSE_JSP).forward(req, resp);
            return true;
        }
        return false;
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (prepareAnotherUserSrvlet(req, resp)) return;
        req.getRequestDispatcher(DELETE).forward(req, resp);
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (prepareAnotherUserSrvlet(req, resp)) return;
        req.getRequestDispatcher(EDIT).forward(req, resp);
    }

    private void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(ADD).forward(req, resp);
    }
	
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			browse(req, resp);
	}

	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Collection users;
		try {
			users = DaoFactory.getInstance().getUserDao().findAll();
			req.getSession().setAttribute(USERS_ATTRIBUTE, users);
			req.getRequestDispatcher(BROWSE_JSP).forward(req, resp);
		} catch (DataBaseException e) {
			throw new ServletException(e);
		}
	}

}