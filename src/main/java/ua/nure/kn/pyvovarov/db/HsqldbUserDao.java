package ua.nure.kn.pyvovarov.db;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;

import java.util.Collection;

public class HsqldbUserDao implements Dao<User> {
	
	 private final ConnectionFactory connectionFactory;

	    public HsqldbUserDao(ConnectionFactory factory) {
	        connectionFactory = factory;
	    }
	    
    @Override
    public User create(User entity) throws DataBaseException {
        return null;
    }

    @Override
    public void update(User entity) throws DataBaseException {

    }

    @Override
    public void delete(User entity) throws DataBaseException {

    }

    @Override
    public User find(Long id) throws DataBaseException {
        return null;
    }

    @Override
    public Collection<User> findAll() throws DataBaseException {
        return null;
    }
}