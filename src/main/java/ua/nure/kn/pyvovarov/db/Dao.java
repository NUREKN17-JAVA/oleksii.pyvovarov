package ua.nure.kn.pyvovarov.db;

import org.dbunit.DatabaseUnitException;

public interface Dao<T> {
 T create (T entity) throws DatabaseException;
 void update(T entity) throws DatabaseException;
 void delete (T entity) throws DatabaseException;
T find (T entity) throws DatabaseException;
void find(long id) throws DatabaseException;
Ñollection<T> findAll() throws DatabaseException;
}
