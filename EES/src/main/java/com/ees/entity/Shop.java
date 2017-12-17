package com.ees.entity;

public class Shop {

    private int id_table_salesinfo;

    private int id_table_shops;

    private int pos;
    private String shop;

    private String shop_product;
    private int cfnumber;

    private String status;
    private String condition;

    public Shop(int id_table_salesinfo, int id_table_shops,
                int pos, String shop,
                String shop_product, int cfnumber,
                String status, String condition) {
        this.id_table_salesinfo = id_table_salesinfo;
        this.id_table_shops = id_table_shops;

        this.pos = pos;
        this.shop = shop;
        this.shop_product = shop_product;
        this.cfnumber = cfnumber;
        this.status = status;
        this.condition = condition;
    }

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

    @Override
    public String toString() {
        return "Shop{" +
                "id_table_salesinfo=" + id_table_salesinfo +
                ", id_table_shops=" + id_table_shops +
                ", pos=" + pos +
                ", shop='" + shop + '\'' +
                ", shop_product='" + shop_product + '\'' +
                ", cfnumber=" + cfnumber +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
