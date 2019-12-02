package ua.nure.kn.pyvovarov.gui;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import java.text.DateFormat;
import java.util.Date;
import junit.extensions.jfcunit.finder.NamedComponentFinder;
import ua.nure.kn.pyvovarov.db.DaoFactory;
import ua.nure.kn.pyvovarov.db.DaoFactoryImpl;
import ua.nure.kn.pyvovarov.db.MockUserDao;
import ua.nure.kn.pyvovarov.gui.MainFrame;
import junit.extensions.jfcunit.eventdata.StringEventData;
import javax.swing.JTextField;
import junit.extensions.jfcunit.eventdata.MouseEventData;


import java.awt.*;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;

public class MainFrameTest extends JFCTestCase {
    
    private static final String DELETE_BUTTON = "deleteButton";
	private static final String DETAILS_BUTTON = "detailsButton";
	private static final String EDIT_BUTTON = "editButton";
	private static final String ADD_BUTTON = "addButton";
	private static final String BROWSE_PANEL = "browse Panel";
	private MainFrame mainFrame;
    @Override
    public void setUp() throws Exception {
        super.setUp();
        try {
			Properties properties = new Properties();
			properties.setProperty("ua.nure.kn.pyvovarov.db.UserDao", 
									MockUserDao.class.getName());
			properties.setProperty("dao.factory", DaoFactoryImpl.class.getName());
			DaoFactory.getInstance().init(properties);

			setHelper(new JFCTestHelper());
			mainFrame = new MainFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
        mainFrame.setVisible(true);
        
    }

    @Override
    public void tearDown() throws Exception {
        mainFrame.setVisible(true);
        getHelper();
        TestHelper.cleanUp(this);
        super.tearDown();
    }

    private Component find(Class<?> componentClass, String name) {
    	NamedComponentFinder finder;
    	finder = new NamedComponentFinder(componentClass, name);
    	finder.setWait(0);
    	Component component = finder.find(mainFrame,0);
    	assertNotNull("Could not find component'" + name + "'",component);
    	return component;
    }
    public void testBrowseControls() {
		find(JPanel.class,BROWSE_PANEL);
		JTable table = (JTable) find(JTable.class, "userTable");
		assertEquals(3, table.getColumnCount());
		assertEquals("ID", table.getColumnName(0));
		assertEquals("Name", table.getColumnName(1));
		assertEquals("Surname", table.getColumnName(2));		find (JButton.class, ADD_BUTTON);
		find (JButton.class, EDIT_BUTTON);
		find (JButton.class, DETAILS_BUTTON);
		find (JButton.class, DELETE_BUTTON);		
	}
    
    public void testAddUser() {
    	JTable table = (JTable) find(JTable.class, "userTable");
		assertEquals(0, table.getRowCount());
		JButton addButton = (JButton) find(JButton.class, "addButton");
		getHelper().enterClickAndLeave(new MouseEventData(this, addButton));

		find(JPanel.class, "addPanel");

		JTextField firstNameField = (JTextField) find(JTextField.class, "firstNameField");
		JTextField lastNameField = (JTextField) find(JTextField.class, "lastNameField");
		JTextField dateOfBirthField = (JTextField) find(JTextField.class, "dateOfBirthField");
		JButton okButton = (JButton) find(JButton.class, "okButton");
		find(JButton.class, "cancelButton");
		JTextField firstNameField = (JTextField) find(JTextField.class, "firstNameField");
		JTextField lastNameField = (JTextField) find(JTextField.class, "lastNameField");
		JTextField dateOfBirthField = (JTextField) find(JTextField.class, "dateOfBirthField");
		JButton okButton = (JButton) find(JButton.class, "okButton");
		find(JButton.class, "cancelButton");

		getHelper().sendString(new StringEventData(this, firstNameField, "John"));
		getHelper().sendString(new StringEventData(this, lastNameField, "Doe"));
		DateFormat formatter = DateFormat.getDateInstance();
		String date = formatter.format(new Date());
		getHelper().sendString(new StringEventData(this, dateOfBirthField, date));

		getHelper().enterClickAndLeave(new MouseEventData(this, okButton));

		find(JPanel.class, "browsePanel");
		table = (JTable) find(JTable.class, "userTable");
		assertEquals(1, table.getRowCount());
	}
}

