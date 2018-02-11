package com.ees.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder(builderMethodName = "_myquerybuilder")

public class Query {

    private int id_users;
    private String login;
    private int leadid;

    public Query(int id_users,String login,int leadid) {
        this.id_users = id_users;
        this.login = login;
        this.leadid = leadid;
    }

//
//    public int getId_users() {
//        return id_users;
//    }
//
//    public void setId_users(int id_users) {
//        this.id_users = id_users;
//    }
//
//    public int getLeadid() {
//        return leadid;
//    }
//
//    public void setLeadid(int leadid) {
//        this.leadid = leadid;
//    }
//
//    @Override
//    public String toString() {
//        return "Sales{" +
//                "id_users=" + id_users +
//                ", leadid=" + leadid +
//                '}';
//    }
}