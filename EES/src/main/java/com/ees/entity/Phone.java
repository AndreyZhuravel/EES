package com.ees.entity;

public class Phone {

    private int id_table_salesinfo;

    private int id_table_phone;

    private int pos;
    private String shop;
    private String region;

    private String income;
    private String description;

    private String status;
    private String condition;

    public Phone(int id_table_salesinfo, int id_table_phone,
                 int pos, String shop,
                 String region, String income,
                 String description, String status,
                 String condition) {
        this.id_table_salesinfo = id_table_salesinfo;
        this.id_table_phone = id_table_phone;
        this.pos = pos;
        this.shop = shop;
        this.region = region;
        this.income = income;
        this.description = description;
        this.status = status;
        this.condition = condition;
    }

    public int getId_table_salesinfo() {
        return id_table_salesinfo;
    }

    public void setId_table_salesinfo(int id_table_salesinfo) {
        this.id_table_salesinfo = id_table_salesinfo;
    }

    public int getId_table_phone() {
        return id_table_phone;
    }

    public void setId_table_phone(int id_table_phone) {
        this.id_table_phone = id_table_phone;
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

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return "Phone{" +
                "id_table_salesinfo=" + id_table_salesinfo +
                ", id_table_phone=" + id_table_phone +
                ", pos=" + pos +
                ", shop='" + shop + '\'' +
                ", region='" + region + '\'' +
                ", income='" + income + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
