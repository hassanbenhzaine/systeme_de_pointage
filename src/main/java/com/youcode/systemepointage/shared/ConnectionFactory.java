package com.youcode.systemepointage.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private static final String USERNAME = "dev_oth";
    private static final String PASSWORD = "huhu1996";
    private static final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/pointage";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
    }
}
