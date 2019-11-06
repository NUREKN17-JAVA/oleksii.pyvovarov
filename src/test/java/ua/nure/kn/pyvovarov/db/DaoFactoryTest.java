package ua.nure.kn.pyvovarov.db;

import junit.framework.TestCase;
import ua.nure.kn.pyvovarov.usermanagment.domain.User;

public class DaoFactoryTest extends TestCase {
	public void testUserDao() {
		  DaoFactory daoFactory = DaoFactory.getInstance();
	        assertNotNull(daoFactory);
	        Dao<User> userDao;
        try {
        	 userDao = daoFactory.getDao();
            assertNotNull("UserDao instance is null", userDao);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            fail(e.toString());
        }
    }
}
