package com.youcode.systemepointage.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5433/guru99";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
    }
}
