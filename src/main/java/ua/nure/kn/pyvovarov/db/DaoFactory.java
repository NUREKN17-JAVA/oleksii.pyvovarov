package ua.nure.kn.pyvovarov.db;

import java.io.IOException;
import java.util.Properties;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;

public class DaoFactory {
	 private final Properties properties;
	 private static final String PROPERTIES = "settings.properties";
	 private static final String USER = "connection.user";
	 private static final String PASSWORD = "connection.password";
	 private static final String URL = "connection.url";
	 private static final String DRIVER = "connection.driver";
	 private static final String HSQLDB_USER_DAO = "dao.UserDao";	    
	 
	 private final static DaoFactory INSTANCE = new DaoFactory();
	    
	    public static DaoFactory getInstance() {
	        return INSTANCE;
	    }
	    
	    public DaoFactory() {
	        this.properties = new Properties();
	        try {
	            properties.load(getClass().getClassLoader()
	            	    .getResourceAsStream(PROPERTIES));
	        } catch (IOException e) {
	            throw new RuntimeException(e);
	        }
	    }
	    private ConnectionFactory createConnection() {
	    	    String user = properties.getProperty(USER);
	    	    String password = properties.getProperty(PASSWORD);
	    	    String url = properties.getProperty(URL);
	    	    String driver = properties.getProperty(DRIVER);

	        return new ConnectionFactoryImpl(user, password, url, driver);
	    }

	    public Dao<User> getDao() throws ReflectiveOperationException {
	        Dao<User> userDao = null;
	        try {
	            Class hsqldbUserDaoClass = Class.forName(properties.getProperty(HSQLDB_USER_DAO));
	            userDao = (Dao<User>) hsqldbUserDaoClass.newInstance();
	            userDao.setConnectionFactory(createConnection());
	        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
	            throw new ReflectiveOperationException(e);
	        }
	        return userDao;
	    }
}
