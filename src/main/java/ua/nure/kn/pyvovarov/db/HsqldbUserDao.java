package ua.nure.kn.pyvovarov.db;

import ua.nure.kn.pyvovarov.usermanagment.domain.User;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;

public class HsqldbUserDao implements Dao<User> {
	
	 private final ConnectionFactory connectionFactory;

	    public HsqldbUserDao(ConnectionFactory factory) {
	        connectionFactory = factory;
	    }
	    public static final String INSERT_QUERY = "INSERT INTO users " +
	            "(firstname, lastname, dateofbirth VALUES (?,?,?))"; 
    @Override
    public User create(User entity) throws DataBaseException {
    	 try {
             Connection connection = connectionFactory.createConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
             statement.setString(1, entity.getFirstName());
             statement.setString(2, entity.getLastName());
             statement.setDate(3, new Date(entity.getDateOfBirth()
                                                 .getTime()));
             int numberOfRows = statement.executeUpdate();
             if (numberOfRows != 1) {
                 throw new DataBaseException("Number of inserted rows: " + numberOfRows);
             }
             return null;
         } catch (DataBaseException e) {
             throw e;
         } catch (SQLException e) {
             throw new DataBaseException(e);
         }
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