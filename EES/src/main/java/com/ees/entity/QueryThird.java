package com.ees.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder(builderMethodName = "_myquerybuilder")

public class QueryThird {

    private String login;
    private int leadid;
    private long pos;
    private String address_reg;
    private String address_fact;
    private String shop;
    private String region;
    private String status;
    private String condition;

    public QueryThird() {
    }

    public QueryThird(String login, int leadid, long pos,
                      String address_reg, String address_fact, String shop,
                      String region, String status, String condition) {
        this.login = login;
        this.leadid = leadid;
        this.pos = pos;
        this.address_reg = address_reg;
        this.address_fact = address_fact;
        this.shop = shop;
        this.region = region;
        this.status = status;
        this.condition = condition;
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

    public static QueryThird createThirdQuery(ResultSet rs) throws SQLException {
        QueryThird query = new QueryThird();
        query.setLogin(rs.getString("login"));
        query.setLeadid(rs.getInt("leadid"));
        query.setPos(rs.getLong("pos"));
        query.setAddress_reg(rs.getString("address_reg"));
        query.setAddress_fact(rs.getString("address_fact"));
        query.setShop(rs.getString("shop"));
        query.setRegion(rs.getString("region"));
        query.setStatus(rs.getString("status"));
        query.setCondition(rs.getString("condition"));
        return query;
    }

    @Override
    public String toString() {
        return "QueryThird{" +
                "login='" + login + '\'' +
                ", leadid=" + leadid +
                ", pos=" + pos +
                ", address_reg='" + address_reg + '\'' +
                ", address_fact='" + address_fact + '\'' +
                ", shop='" + shop + '\'' +
                ", region='" + region + '\'' +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
