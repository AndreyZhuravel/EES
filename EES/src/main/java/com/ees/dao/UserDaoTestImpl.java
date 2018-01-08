package com.ees.dao;

import com.ees.entity.User;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserDaoTestImpl implements UserDao {

//    private static final String DRIVER_NAME = "org.postgresql.Driver";
//    private static final String DB_URL = "jdbc:postgresql:ca";
//    private static final String ID = "postgres";
//    private static final String PASS = "postgres";

    private static final String FIND_ALL = "SELECT * FROM table_users ORDER BY id_users";
    private static final String FIND_BY_ID = "SELECT * FROM table_users WHERE id_users=?";
    private static final String FIND_BY_LOGIN = "SELECT * FROM table_users WHERE login=?";

    private static final String INSERT = "INSERT INTO table_users(login, pass, role, privilege) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE table_users SET login=?, pass=?, role=?, privilege=? WHERE id_users=?";
    private static final String DELETE = "DELETE FROM table_users WHERE id_users=?";

    public List<User> findAll() {

//    Connection conn = null;
//    String jdbcDriver = "org.postgresql.Driver";
//    String dbURL = "jdbc:postgresql://localhost:5432/db_ees_test";

        PreparedStatement stmt = null;
        List<User> users = new ArrayList<User>();

        try {

//          conn = getConnection();
//            work variant 1:
//            ConnectionPool pool = ConnectionPool.getInstance();
//            Connection[] connections = new Connection[5];
//
//            for(int i = 0; i < connections.length; i++) {
//                connections[i] = pool.getConnection();
//                stmt = connections[i].prepareStatement(FIND_ALL);
//            }
//            work variant 1:
//
              ConnectionPoolManager pool = new ConnectionPoolManager();
              Connection dbConn = pool.getConnectionFromPool();
              stmt = dbConn.prepareStatement(FIND_ALL);

//            Connection dbConn = null;
//            ConnectionPool connectionPool = null;
//            connectionPool = new ConnectionPool(jdbcDriver, dbURL,
//            "postgres", "root");
//
//            connectionPool.setInitialConnections(2); //specify the initial number of connections to establish
//            connectionPool.setIncrementalConnections(2);
//            connectionPool.setMaxConnections(2);
//
//            connectionPool.createPool(); //create the connection pool
//            dbConn = connectionPool.getConnection();
//            Statement stmt = dbConn.createStatement();
//            String sql = "SELECT * FROM table_users ORDER BY id_users";
//            ResultSet rs = stmt.executeQuery(sql);
//            stmt = conn.prepareStatement(FIND_ALL);

            System.out.println("find all method invokation");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_users = rs.getInt("id_users");
                String login = rs.getString("login");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String privilege = rs.getString("privilege");

                User user = User._myuserbuilder()
                        .id_users(id_users)
                        .login(login)
                        .pass(pass)
                        .role(role)
                        .privilege(privilege)
                        .build();

//                User user = new User(id_users, login, pass, role, privilege);
//                user(id_users);
//                user.setLogin(login);
//                user.setPass(pass);
//                user.setRole(role);
//                user.setPrivilege(privilege);

                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("FindAll method was successfully executed");
//        }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
//        } finally {
//            //return connection to pool (always within a finally block)
//            connectionPool.returnConnection((Connection)conn);
//        }
        return users;
    }

    public User findById(int id_users) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id_users);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id_users = rs.getInt("id_users");
                String login = rs.getString("login");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String privilege = rs.getString("privilege");

                User user = User._myuserbuilder()
                        .id_users(id_users)
                        .login(login)
                        .pass(pass)
                        .role(role)
                        .privilege(privilege)
                        .build();

                return user;

            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("FindById method was successfully executed");
        }

    }

    public User findByLogin(String login) {
//        Connection conn = null;
        PreparedStatement stmt = null;

        try {

//            work variant 1:
//            ConnectionPool pool = ConnectionPool.getInstance();
//            Connection[] connections = new Connection[5];
//
//            for(int i = 0; i < connections.length; i++) {
//                connections[i] = pool.getConnection();
//                stmt = connections[i].prepareStatement(FIND_BY_LOGIN);
//                stmt.setString(1, java.lang.String.valueOf(login));
//            }
//            work variant 1:

            ConnectionPoolManager pool = new ConnectionPoolManager();
            Connection dbConn = pool.getConnectionFromPool();
            stmt = dbConn.prepareStatement(FIND_BY_LOGIN);
            stmt.setString(1, java.lang.String.valueOf(login));

//          conn = getConnection();
//          conn = (Connection) new ConnectionPool();

            System.out.println("find by login method invokation");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_users = rs.getInt("id_users");
                login = rs.getString("login");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String privilege = rs.getString("privilege");

                User user = User._myuserbuilder()
                        .id_users(id_users)
                        .login(login)
                        .pass(pass)
                        .role(role)
                        .privilege(privilege)
                        .build();

                return user;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("FindByLogin method was successfully executed");

        }
    }

    public int insert(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getPrivilege());

            int result = stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                user.setId_users(rs.getInt(1));
            }

            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println(user + "was successfully add");
        }
    }

    public int update(User user) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setString(1, user.getLogin());
            stmt.setString(2, user.getPass());
            stmt.setString(3, user.getRole());
            stmt.setString(4, user.getPrivilege());

            stmt.setInt(5, user.getId_users());

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println(user + "was successfully updated");

        }
    }

    public int delete(int id_users) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = getConnection();
            stmt = conn.prepareStatement(DELETE);
            stmt.setInt(1, id_users);

            return stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);

//        } finally {
//            close(stmt);
//            close(conn);
//            System.out.println("Record with number " + id_users + " is successfully deleted");

        }
    }

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

//
//    private Connection getConnection() {
//
//        try {
//            Class.forName(DRIVER_NAME);
//            return DriverManager.getConnection(DB_URL, ID, PASS);
//
//        } catch (Exception e) {
//            // e.printStackTrace();
//            throw new RuntimeException(e);
//        }
//    }
//
//    private static void close(Connection con) {
//        if (con != null) {
//            try {
//                con.close();
//            } catch (SQLException e) {
//                // e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//    }
//
//    private static void close(Statement stmt) {
//        if (stmt != null) {
//            try {
//                stmt.close();
//            } catch (SQLException e) {
//                // e.printStackTrace();
//                throw new RuntimeException(e);
//            }
//        }
//    }

