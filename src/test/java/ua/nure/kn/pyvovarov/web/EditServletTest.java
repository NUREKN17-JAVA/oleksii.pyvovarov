package ua.nure.kn.pyvovarov.web;


import java.text.DateFormat;
import java.util.Date;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;

public class EditServletTest extends MockServletTestCase {
	 private static final String ERROR_ATTRIBUTE = "error";
	    private static final String OK_BUTTON = "Ok";
	    private static final String OK_BUTTON_PARAMETER = "okButton";
	    private static final String DATE_PARAMETER = "date";
	    private static final String LAST_NAME_PARAMETER = "lastName";
	    private static final String FIRST_NAME_PARAMETER = "firstName";
	    private static final String ID_VALUE = "1000";
	    private static final String ID_PARAMETER = "id";
	    private static final String UPDATE_USER = "updateUser";
	    private static final String LAST_NAME = "Dima";
	    private static final String FIRST_NAME = "Kirillov";

	    @Override
	    protected void setUp() throws Exception {
	        super.setUp();
	        createServlet(EditServlet.class);
	    }

	    public void testEdit() {
	        Date date = new Date();
	        User user = new User(1000L, FIRST_NAME, LAST_NAME, new Date());
	        getMockUserDao().expect(UPDATE_USER, user);

	        addRequestParameter(ID_PARAMETER, ID_VALUE);
	        addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
	        addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
	        addRequestParameter(DATE_PARAMETER, DateFormat.getInstance().format(date));
	        addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
	        doPost();
	    }

	    public void testEditEmptyFirstName() {
	        Date date = new Date();
	        addRequestParameter(ID_PARAMETER, ID_VALUE);
	        addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
	        addRequestParameter(DATE_PARAMETER, DateFormat.getInstance().format(date));
	        addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
	        doPost();
	        String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
	        assertNotNull("Could not find error message in session scope", errorMessage);
	    }

	    public void testEditEmptyLastName() {
	        Date date = new Date();
	        addRequestParameter(ID_PARAMETER, ID_VALUE);
	        addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
	        addRequestParameter(DATE_PARAMETER, DateFormat.getInstance().format(date));
	        addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
	        doPost();
	        String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
	        assertNotNull("Could not find error message in session scope", errorMessage);
	    }

	    public void testEditEmptyDate() {
	        Date date = new Date();
	        addRequestParameter(ID_PARAMETER, ID_VALUE);
	        addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
	        addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
	        addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
	        doPost();
	        String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
	        assertNotNull("Could not find error message in session scope", errorMessage);
	    }

	    public void testEditEmptyDateIncorrect() {
	        Date date = new Date();
	        addRequestParameter(ID_PARAMETER, ID_VALUE);
	        addRequestParameter(FIRST_NAME_PARAMETER, FIRST_NAME);
	        addRequestParameter(LAST_NAME_PARAMETER, LAST_NAME);
	        addRequestParameter(DATE_PARAMETER, "Hello)))");
	        addRequestParameter(OK_BUTTON_PARAMETER, OK_BUTTON);
	        doPost();
	        String errorMessage = (String)getWebMockObjectFactory().getMockRequest().getAttribute(ERROR_ATTRIBUTE);
	        assertNotNull("Could not find error message in session scope", errorMessage);
	    }

}