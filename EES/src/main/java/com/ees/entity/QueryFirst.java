package com.ees.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder(builderMethodName = "_myquerybuilder")

public class QueryFirst {

    private int id_users;
    private String login;
    private int leadid;
    private int id_table_address;
    private long pos;
    private String address_reg;
    private String address_fact;
    private String shop;
    private String region;
    private String status;
    private String condition;
    private int id_table_salesinfo;

    public QueryFirst() {}

    public QueryFirst(int id_users, String login, int leadid,
                 int id_table_address, long pos, String address_reg,
                 String address_fact, String shop, String region,
                 String status, String condition, int id_table_salesinfo) {
        this.id_users = id_users;
        this.login = login;
        this.leadid = leadid;
        this.id_table_address = id_table_address;
        this.pos = pos;
        this.address_reg = address_reg;
        this.address_fact = address_fact;
        this.shop = shop;
        this.region = region;
        this.status = status;
        this.condition = condition;
        this.id_table_salesinfo = id_table_salesinfo;
    }

    public int getId_table_address() {
        return id_table_address;
    }

    public void setId_table_address(int id_table_address) {
        this.id_table_address = id_table_address;
    }

    public long getPos() {
        return pos;
    }

    public void setPos(long pos) {
        this.pos = pos;
    }

    public String getAddress_reg() {
        return address_reg;
    }

    public void setAddress_reg(String address_reg) {
        this.address_reg = address_reg;
    }

    public String getAddress_fact() {
        return address_fact;
    }

    public void setAddress_fact(String address_fact) {
        this.address_fact = address_fact;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public int getId_table_salesinfo() {
        return id_table_salesinfo;
    }

    public void setId_table_salesinfo(int id_table_salesinfo) {
        this.id_table_salesinfo = id_table_salesinfo;
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

    public int getLeadid() {
        return leadid;
    }

    public void setLeadid(int leadid) {
        this.leadid = leadid;
    }

    public static QueryFirst createQuery(ResultSet rs) throws SQLException {
        QueryFirst query = new QueryFirst();
        query.setId_users(rs.getInt("id_users"));
        query.setLogin(rs.getString("login"));
        query.setLeadid(rs.getInt("leadid"));
        query.setId_table_address(rs.getInt("id_table_address"));
        query.setPos(rs.getLong("pos"));
        query.setAddress_reg(rs.getString("address_reg"));
        query.setAddress_fact(rs.getString("address_fact"));
        query.setShop(rs.getString("shop"));
        query.setRegion(rs.getString("region"));
        query.setStatus(rs.getString("status"));
        query.setCondition(rs.getString("condition"));
        query.setId_table_salesinfo(rs.getInt("id_table_salesinfo"));
        return query;
    }

    @Override
    public String toString() {
        return "Query{" +
                "id_users=" + id_users +
                ", login='" + login + '\'' +
                ", leadid=" + leadid +
                ", id_table_address=" + id_table_address +
                ", pos=" + pos +
                ", address_reg='" + address_reg + '\'' +
                ", address_fact='" + address_fact + '\'' +
                ", shop='" + shop + '\'' +
                ", region='" + region + '\'' +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                ", id_table_salesinfo=" + id_table_salesinfo +
                '}';
    }
}