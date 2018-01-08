package com.ees.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {

    private final static int MAX_CONNECTIONS = 8;
    private static ConnectionPool instance = null;  // lazy loading
    private static Connection[] connections = new Connection[MAX_CONNECTIONS];
    private static String dbUrl = "jdbc:postgresql://localhost:5432/db_ees_test";
    private static String dbUsername = "postgres";
    private static String dbPassword = "root";

    private static int counter;

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        if (instance == null) {
            synchronized (ConnectionPool.class) {
                if (instance == null) {
                    instance = new ConnectionPool();
                    initializeConnections();
                    counter = 0;
                }
            }
        }

        return instance;
    }

    private static void initializeConnections() {
        for (int i = 0; i < MAX_CONNECTIONS; i++) {
            try {
                Class.forName("org.postgresql.Driver");
                connections[i] = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        counter++;
        if (counter == Integer.MAX_VALUE)
            counter = 0;

        return connections[counter % MAX_CONNECTIONS];
    }
}