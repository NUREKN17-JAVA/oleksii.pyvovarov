package ua.nure.kn.pyvovarov.web;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import ua.nure.kn.pyvovarov.usermanagment.domain.User;

public class BrowseServletTest extends MockServletTestCase {
	private static final String USERS_ATTRIBUTE = "users";
	private static final String FIND_ALL = "findAll";
	private static final Date DATE_OF_BIRTH = new Date();
	private static final String LAST_NAME = "Doe";
	private static final String FIRST_NAME = "John";
	private static final Long ID = new Long(1000);

	protected void setUp() throws Exception {
		super.setUp();
		createServlet(BrowseServlet.class);
	}

	public void testBrowse() {
		User user = new User(ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH);
		List list = Collections.singletonList(user);
		getMockUserDao().expectAndReturn(FIND_ALL, list);
		doGet();
		Collection collection = (Collection) getWebMockObjectFactory().getMockSession().getAttribute(USERS_ATTRIBUTE);
		assertNotNull("Could not find list of users in session", collection);
		assertSame(list, collection);
	}

}