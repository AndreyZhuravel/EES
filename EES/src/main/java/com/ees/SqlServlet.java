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

public class SqlServlet extends HttpServlet {

    public void init() throws ServletException {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Connecting to database..");
        Connection conn = null;

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("config_main.properties");

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

        System.out.println("Creating statement to db_ees database...");
        Statement stmt = null;

        try {
            if (conn != null) {
                stmt = conn.createStatement();
                System.out.println("CreateStatement OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String sql = "SELECT id_users, login FROM table_users";

        ResultSet rs = null;

        try {
            if (stmt != null) {
                rs = stmt.executeQuery(sql);
                System.out.println("Execute query OK");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<EntityUser> users = new ArrayList<EntityUser>();

        try {
            if (rs != null) {
                while (rs.next()) {
                    int id_users = rs.getInt("id_users");
                    String login = rs.getString("login");
                    String pass = rs.getString("pass");
                    String role = rs.getString("role");
                    String privilege = rs.getString("privilege");

                    EntityUser user = new EntityUser();
                    user.setId_users(id_users);
                    user.setName(login);
                    user.setPassword(pass);
                    user.setRole(role);
                    user.setPrivilege(privilege);
                    users.add(user);
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

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String html = "";
            for (EntityUser user : users) {
                html = html + "<p><div>" + user.getLogin() + "</div>" +
                        "<div>" + user.getPass() + "</div></p>";
            }

            out.println(html);
        }
    }

    public void destroy() {
        // do nothing.
    }
}
