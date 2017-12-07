package com.ees;

public class EntityUser {

    private int id_users;
    private String login;
    private String pass;
    private String role;
    private String privilege;

    public EntityUser() {
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

    public void setName(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPassword(String pass) {
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

}
