package com.youcode.systemepointage.shared;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    private final String USERNAME = "dev_oth";
    private final String PASSWORD = "huhu1996";
    private final String CONNECTION_URL = "jdbc:postgresql://localhost:5432/pointage";
    private final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static ConnectionFactory connectionFactory = null;

    private ConnectionFactory() throws ClassNotFoundException {
        Class.forName(DRIVER_CLASS_NAME);
    }

    public static ConnectionFactory getInstance() throws Exception {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }
        return connectionFactory;
    }

    public Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(CONNECTION_URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
