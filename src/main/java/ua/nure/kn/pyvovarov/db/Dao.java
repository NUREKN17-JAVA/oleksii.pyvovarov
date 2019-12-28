package ua.nure.kn.pyvovarov.db;

import java.util.Collection;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;

public interface Dao<T>{
	User create(User user) throws DataBaseException;
	
	void update(User user) throws DataBaseException;
	
	void delete(User user) throws DataBaseException;
	
	User find(Long id) throws DataBaseException;
	
	Collection<User> findAll() throws DataBaseException;
	
	void setConnectionFactory(ConnectionFactory connectionFactory);
	
	Collection find(String firstName, String lastName) throws DataBaseException;
}