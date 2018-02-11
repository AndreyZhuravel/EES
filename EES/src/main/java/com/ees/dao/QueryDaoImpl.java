package com.ees.dao;

import com.ees.entity.Query;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class QueryDaoImpl implements QueryDao {

    private static final String FIND_BY_LOGIN_TEST = "SELECT table_users.id_users, table_users.login, table_salesinfo.leadid, table_address.* FROM table_address join table_salesinfo ON table_salesinfo.id_salesinfo = table_address.id_table_salesinfo left join table_users ON table_salesinfo.id_users = table_users.id_users where table_users.login =?";

    //Implementation of methods for get all data from table_address in db_ees_test

    public Query getAllDataFromTableAddress(String login) {

        Connection conn = null;
        PreparedStatement stmt = null;

        try {

            conn = getConnection();

            stmt = conn.prepareStatement(FIND_BY_LOGIN_TEST);
            stmt.setString(1, String.valueOf(login));

            System.out.println("test sql method invokation");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_users = rs.getInt("id_users");
                login = rs.getString("login");
                int leadid = rs.getInt("leadid");

                Query query = Query._myquerybuilder()
                        .id_users(id_users)
                        .login(login)
                        .leadid(leadid)
                        .build();

               return query;

            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("FindByLogin method was successfully executed");

        }
        return null;
    }

    //Method for creating connection to database db_ees_test
    public Connection getConnection() {

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
