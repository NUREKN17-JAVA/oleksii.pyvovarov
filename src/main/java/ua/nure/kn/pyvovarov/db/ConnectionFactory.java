package ua.nure.kn.pyvovarov.db;
import java.sql.Connection;

public interface ConnectionFactory {
    Connection createConnection() throws DataBaseException;
}
