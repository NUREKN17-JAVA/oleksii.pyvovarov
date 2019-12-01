package ua.nure.kn.pyvovarov.db;

public class DaoFactoryImpl {

	@Override
	public Dao getUserDao() {
		Dao result = null;
		try {
			Class clazz = Class.forName(properties.getProperty(USER_DAO));
			result = (Dao) clazz.newInstance();
			result.setConnectionFactory(getConnectionFactory());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		return result;
	}
}
