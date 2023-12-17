package com.example.layeredarchitecture.util;

import com.example.layeredarchitecture.db.DBConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLUtil {
    public static <T> T execute(String query, Object...args) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = DBConnection.getDbConnection().getConnection().prepareStatement(query);

        for (int i = 0; i < args.length; i++) {
            pstm.setObject((i+1), args[i]);
        }

        if (query.startsWith("SELECT") || query.startsWith("select") || query.startsWith("Select")){
            return (T) pstm.executeQuery();
        }else
            return (T)(Boolean)(pstm.executeUpdate() > 0);
    }
}
