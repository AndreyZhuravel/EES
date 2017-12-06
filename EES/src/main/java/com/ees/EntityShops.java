package com.ees;

public class EntityShops {

    private int id_table_salesinfo;

    private int id_table_shops;
    private int leadid;
    private int pos;
    private String shop;

    private String shop_product;
    private int cfnumber;

    private String status;
    private String condition;

    public int getId_table_salesinfo() {
        return id_table_salesinfo;
    }

    public void setId_table_salesinfo(int id_table_salesinfo) {
        this.id_table_salesinfo = id_table_salesinfo;
    }

    public int getId_table_shops() {
        return id_table_shops;
    }

    public void setId_table_shops(int id_table_shops) {
        this.id_table_shops = id_table_shops;
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

    public String getShop_product() {
        return shop_product;
    }

    public void setShop_product(String shop_product) {
        this.shop_product = shop_product;
    }

    public int getCfnumber() {
        return cfnumber;
    }

    public void setCfnumber(int cfnumber) {
        this.cfnumber = cfnumber;
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
