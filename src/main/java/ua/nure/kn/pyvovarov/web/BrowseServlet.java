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

	private static final String BROWSE_JSP = "/browse.jsp";
	private static final String USERS_ATTRIBUTE = "users";

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