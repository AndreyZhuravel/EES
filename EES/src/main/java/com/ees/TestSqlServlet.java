package com.ees;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class TestSqlServlet extends HttpServlet {

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Connecting to database..");
        Connection conn = null;

//      Properties prop = new Properties();
//      InputStream input = null;

        try {

//      properties.load(input);
//      input = new FileInputStream("src/main/java/config.properties");

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("config_test.properties");

            Properties prop = new Properties();
            prop.load(input);

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

        System.out.println("Creating statement to test database...");
        Statement stmt = null;

        try {
            if (conn != null) {
                stmt = conn.createStatement();
                System.out.println("CreateStatement OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT id, name, age FROM testtable";

        ResultSet rs = null;

        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                System.out.println("Execute query OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<TestUser> testUsers = new ArrayList<TestUser>();

        try {
            if (rs != null) {
                while (rs.next()) {
                    //Retrieve by column name
                    int id = rs.getInt("id");
                    int age = rs.getInt("age");
                    String name = rs.getString("name");

                    TestUser testUser = new TestUser();
                    testUser.setAge(age);
                    testUser.setId(id);
                    testUser.setName(name);
                    testUsers.add(testUser);

                    //Display values
//                    System.out.println("ID: " + id);
//                    System.out.println(", Age: " + age);
//                    System.out.println(", Name: " + name);

                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            if (rs != null)
                try {
                    rs.close();
                    System.out.println("Result set close");
                } catch (SQLException e) {
                }

            if (stmt != null)
                try {
                    stmt.close();
                    System.out.println("Statement close");
                } catch (SQLException ignore) {
                }

            if (conn != null)
                try {
                    conn.close();
                    System.out.println("Connection close");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        } finally {

            // Set response content type
            response.setContentType("text/html");

            // Actual logic goes here.
            PrintWriter out = response.getWriter();

            String html = "";

            for (TestUser testUser : testUsers) {
                html = html + "<p><div>" + testUser.getName() + "</div>" +
                        "<div>" + testUser.getAge() + "</div></p>";
            }

            out.println(html);

        }
    }

    public void destroy() {
        // do nothing.
    }
}
