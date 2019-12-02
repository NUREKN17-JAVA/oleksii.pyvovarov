package ua.nure.kn.pyvovarov.db;

import junit.framework.TestCase;
import ua.nure.kn.pyvovarov.usermanagment.domain.User;

public class DaoFactoryTest extends TestCase {

	public void testGetUserDao() {
			try {
				DaoFactory daoFactory = DaoFactory.getInstance();
				assertNotNull("DaoFactory instance is null", daoFactory);
				Dao Dao = daoFactory.getUserDao();
				assertNotNull("Dao<User> is null", Dao);
			} catch (RuntimeException e) {
				e.printStackTrace();
				fail(e.toString());
			}
	}

}
