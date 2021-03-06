package com.example.shoppinglistapp;

public class ListProduct {
    private String ID;
    private String name, price, piece;

    public ListProduct(String ID, String name, String price, String piece) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.piece = piece;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
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

    public String getPiece() {
        return piece;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }
}
