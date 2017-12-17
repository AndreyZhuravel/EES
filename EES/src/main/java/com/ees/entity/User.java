package com.ees.entity;
import lombok.Builder;

public class User {

//    @Builder(builderMethodName = "UserBuilder")
//    public static User user(int id_users, String login, ) {
//        return new User(color, barkSound);
//    }

    private int id_users;
    private String login;
    private String pass;
    private String role;
    private String privilege;

    public User(int id_users,
                      String login,
                      String pass,
                      String role,
                      String privilege) {
        this.id_users = id_users;
        this.login = login;
        this.pass = pass;
        this.role = role;
        this.privilege = privilege;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Override
    public String toString() {
        return "User{" +
                "id_users=" + id_users +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", role='" + role + '\'' +
                ", privilege='" + privilege + '\'' +
                '}';
    }

}
