package ua.nure.kn.pyvovarov.db;

import java.sql.SQLException;

public class DataBaseException extends Exception {

    public DataBaseException(SQLException e) {
        super(e);
    }

    public DataBaseException(String s) {
        super(s);
    }
}