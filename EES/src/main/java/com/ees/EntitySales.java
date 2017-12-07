package com.ees;

public class EntitySales {

    private int id_users;

    private int id_salesinfo;
    private int leadid;

    private String login;
    private String expert;
    private String svmanager;
    private String areamanager;

    private String date;
    private int month;

    public EntitySales() {
        this.id_users = id_users;
        this.id_salesinfo = id_salesinfo;
        this.leadid = leadid;
        this.login = login;
        this.expert = expert;
        this.svmanager = svmanager;
        this.areamanager = areamanager;
    }

    public int getId_users() {
        return id_users;
    }

    public void setId_users(int id_users) {
        this.id_users = id_users;
    }

    public int getId_salesinfo() {
        return id_salesinfo;
    }

    public void setId_salesinfo(int id_salesinfo) {
        this.id_salesinfo = id_salesinfo;
    }

    public int getLeadid() {
        return leadid;
    }

    public void setLeadid(int leadid) {
        this.leadid = leadid;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }

    public String getSvmanager() {
        return svmanager;
    }

    public void setSvmanager(String svmanager) {
        this.svmanager = svmanager;
    }

    public String getAreamanager() {
        return areamanager;
    }

    public void setAreamanager(String areamanager) {
        this.areamanager = areamanager;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
