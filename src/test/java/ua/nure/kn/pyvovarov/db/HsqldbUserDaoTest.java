package ua.nure.kn.pyvovarov.db;

import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.XmlDataSet;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;

import java.util.Collection;
import java.util.Date;

public class HsqldbUserDaoTest extends DatabaseTestCase {

    private static final String FIRST_NAME = "John";
    private static final String LAST_NAME = "Doe";
    private static final long ID = 1L;
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String URL = "jdbc:hsqldb:file:db/usermanagement";
    private static final String DRIVER = "org.hsqldb.jdbcDriver";
    private static final String XML_FILE = "usersDataSet.xml";
    private static final int NUMBER_OF_ROWS = 2;

    private HsqldbUserDao hsqldbUserDao;
    private ConnectionFactory connectionFactory;
    
    private User user;
    
    public void testCreate() {
    	 try {
             assertNotNull(user.getId());

             User userToCheck = hsqldbUserDao.create(user);
             assertNotNull(userToCheck);

             assertEquals(user.getFirstName(), userToCheck.getFirstName());
             assertEquals(user.getLastName(), userToCheck.getLastName());
             assertEquals(user.getDateOfBirth(), userToCheck.getDateOfBirth());
         } catch (DataBaseException e) {
             fail(e.toString());
         }
    }

    public void testFindAll() {
        try {
            Collection<User> users = hsqldbUserDao.findAll();
            assertNotNull("Collection is null", users);
            assertEquals("Collection size.", NUMBER_OF_ROWS, users.size());
        } catch (DataBaseException e) {
            e.getMessage();
            e.printStackTrace();
        }
    }
    public void testFind() throws DataBaseException {
    	 assertNotNull(user.getId());

         User ethalonUser = hsqldbUserDao.create(user);
         User findedUser = hsqldbUserDao.find(ethalonUser.getId());

         assertNotNull(findedUser);
         assertEquals(ethalonUser.getId(), findedUser.getId());
         assertEquals(ethalonUser.getFirstName(), findedUser.getFirstName());
         assertEquals(ethalonUser.getLastName(), findedUser.getLastName());
         }

    public void testDelete() throws DataBaseException {
    	   User deletedUser = hsqldbUserDao.create(user);
    	   hsqldbUserDao.delete(deletedUser);
           assertNull(hsqldbUserDao.find(deletedUser.getId()));
    }

    public void testUpdate() throws DataBaseException {
    	User testUser = user;
        hsqldbUserDao.create(user); 

        testUser.setFirstName("Sam11");

        hsqldbUserDao.update(testUser);
        User updatedUser = hsqldbUserDao.find(testUser.getId());
        assertNotNull(updatedUser);
        assertEquals(testUser.getFirstName(), updatedUser.getFirstName());
        assertEquals(testUser.getLastName(), updatedUser.getLastName());
    }
    @Override
    protected void setUp() throws Exception {
    	 super.setUp();

         user = new User();
         user.setId(ID);
         user.setFirstName(FIRST_NAME);
         user.setLastName(LAST_NAME);
         user.setDateOfBirth(new Date());

         hsqldbUserDao = new HsqldbUserDao(connectionFactory);  }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        connectionFactory = new ConnectionFactoryImpl(USER, PASSWORD, URL, DRIVER);
 
    	   return new DatabaseConnection(connectionFactory.createConnection());
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
    	 IDataSet dataSet = new XmlDataSet(getClass().getClassLoader()
    			 .getResourceAsStream(XML_FILE));
    	 	return dataSet;  
    }
}