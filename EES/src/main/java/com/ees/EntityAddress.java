package com.ees;

public class EntityAddress {

    private int id_table_salesinfo;

    private int id_table_address;
    private int leadid;
    private int pos;
    private String shop;
    private String region;

    private String address_reg;
    private String address_fact;

    private String status;
    private String condition;

    public int getId_table_salesinfo() {
        return id_table_salesinfo;
    }

    public EntityAddress() {
        this.id_table_salesinfo = id_table_salesinfo;
        this.id_table_address = id_table_address;
        this.leadid = leadid;
        this.pos = pos;
        this.shop = shop;
        this.region = region;
        this.address_reg = address_reg;
        this.address_fact = address_fact;
        this.status = status;
        this.condition = condition;
    }

    public void setId_table_salesinfo(int id_table_salesinfo) {
        this.id_table_salesinfo = id_table_salesinfo;
    }

    public int getId_table_address() {
        return id_table_address;
    }

    public void setId_table_address(int id_table_address) {
        this.id_table_address = id_table_address;
    }

    public int getLeadid() {
        return leadid;
    }

    public void setLeadid(int leadid) {
        this.leadid = leadid;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
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
}
