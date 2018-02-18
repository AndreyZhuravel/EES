package com.ees.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
@Setter
@Builder(builderMethodName = "_myquerybuilder")

public class QuerySecond {

    private int leadid;
    private int is_mist_adr;
    private int is_mist_shop;
    private int is_mist_phone;

    public QuerySecond() {}

    public QuerySecond(int leadid, int is_mist_adr, int is_mist_shop, int is_mist_phone) {
        this.leadid = leadid;
        this.is_mist_adr = is_mist_adr;
        this.is_mist_shop = is_mist_shop;
        this.is_mist_phone = is_mist_phone;
    }

    public int getLeadid() {
        return leadid;
    }

    public void setLeadid(int leadid) {
        this.leadid = leadid;
    }

    public int getIs_mist_adr() {
        return is_mist_adr;
    }

    public void setIs_mist_adr(int is_mist_adr) {
        this.is_mist_adr = is_mist_adr;
    }

    public int getIs_mist_shop() {
        return is_mist_shop;
    }

    public void setIs_mist_shop(int is_mist_shop) {
        this.is_mist_shop = is_mist_shop;
    }

    public int getIs_mist_phone() {
        return is_mist_phone;
    }

    public void setIs_mist_phone(int is_mist_phone) {
        this.is_mist_phone = is_mist_phone;
    }

    public static QuerySecond createSecondQuery(ResultSet rs) throws SQLException {
        QuerySecond query = new QuerySecond();
        query.setLeadid(rs.getInt("leadid"));
        query.setIs_mist_adr(rs.getInt("is_mist_adr"));
        query.setIs_mist_shop(rs.getInt("is_mist_shop"));
        query.setIs_mist_phone(rs.getInt("is_mist_phone"));
        return query;
    }

    @Override
    public String toString() {
        return "QuerySecond{" +
                "leadid=" + leadid +
                ", is_mist_adr=" + is_mist_adr +
                ", is_mist_shop=" + is_mist_shop +
                ", is_mist_phone=" + is_mist_phone +
                '}';
    }
}
