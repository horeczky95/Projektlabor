package com.example.shoppinglistapp;

public class DataBaseProduct {
    private int ID;
    private String barCode;
    private String name;
    private String price;

    public DataBaseProduct(int ID, String barCode, String name, String price) {
        this.ID = ID;
        this.barCode = barCode;
        this.name = name;
        this.price = price;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
