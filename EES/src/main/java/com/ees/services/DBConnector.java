package com.ees.services;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBConnector {

    public static Connection getConnection() {

        System.out.println("Connecting to database..");
        Connection conn = null;

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("config_test.properties");
            Properties prop = new Properties();

            try {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }

            Class.forName("org.postgresql.Driver");
            conn = DriverManager
                    .getConnection(
                            (prop.getProperty("url")),
                            (prop.getProperty("dbuser")),
                            (prop.getProperty("dbpassword")));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Creating statement to db_ees_test database...");
        Statement stmt = null;

        try {
            if (conn != null) {
                stmt = conn.createStatement();
                System.out.println("CreateStatement OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
