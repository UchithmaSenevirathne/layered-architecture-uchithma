package com.example.layeredarchitecture.util;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionUtil {
    Connection connection = DBConnection.getDbConnection().getConnection();

    public TransactionUtil() throws SQLException, ClassNotFoundException {
    }


    public void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void rollbackTransaction() throws SQLException {
        connection.rollback();
        connection.setAutoCommit(true);
    }

    public void endTransaction() throws SQLException {
        connection.commit();
        connection.setAutoCommit(true);
    }
}
