package com.ees.dao;

import com.ees.entity.User;
import com.ees.services.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Implementation of methods for User Entity

public class UserDaoImpl implements UserDao {

    private static final String FIND_ALL = "SELECT * FROM table_users ORDER BY id_users";
    private static final String FIND_BY_ID = "SELECT * FROM table_users WHERE id_users=?";
    private static final String FIND_BY_LOGIN = "SELECT * FROM table_users WHERE login=?";

    private static final String INSERT = "INSERT INTO table_users(login, pass, role, privilege) VALUES(?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE table_users SET login=?, pass=?, role=?, privilege=? WHERE id_users=?";
    private static final String DELETE = "DELETE FROM table_users WHERE id_users=?";

    public List<User> findAll() {

        Connection conn = null;
        PreparedStatement stmt = null;
        List<User> users = new ArrayList<User>();

        try {

            conn = DBConnector.getConnection();
            stmt = conn.prepareStatement(FIND_ALL);

            System.out.println("find all method invokation");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id_users = rs.getInt("id_users");
                String login = rs.getString("login");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String privilege = rs.getString("privilege");

                User user = new User(id_users,login,pass,role,privilege);

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
        return users;
    }

    public User findById(int id_users) {
        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnector.getConnection();
            stmt = conn.prepareStatement(FIND_BY_ID);
            stmt.setInt(1, id_users);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                id_users = rs.getInt("id_users");
                String login = rs.getString("login");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String privilege = rs.getString("privilege");

                User user = new User(id_users,login,pass,role,privilege);
                /*User user = User._myuserbuilder()
                        .id_users(id_users)
                        .login(login)
                        .pass(pass)
                        .role(role)
                        .privilege(privilege)
                        .build();*/

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

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = DBConnector.getConnection();

            stmt = conn.prepareStatement(FIND_BY_LOGIN);
            stmt.setString(1, String.valueOf(login));

            System.out.println("find by login method invokation");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id_users = rs.getInt("id_users");
                login = rs.getString("login");
                String pass = rs.getString("pass");
                String role = rs.getString("role");
                String privilege = rs.getString("privilege");

                User user = new User(id_users,login,pass,role,privilege);
                /*User user = User._myuserbuilder()
                        .id_users(id_users)
                        .login(login)
                        .pass(pass)
                        .role(role)
                        .privilege(privilege)
                        .build();*/

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
            conn = DBConnector.getConnection();
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
            conn = DBConnector.getConnection();
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
            conn = DBConnector.getConnection();
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

    public static User getById(int id) {
        return new UserDaoImpl().findById(id);
    }

    public static User getByLogin(String login) {
        return new UserDaoImpl().findByLogin(login);
    }
}