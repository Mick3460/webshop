package com.example.webshop.model;

public class Product {

    private int product_id;
    private String name;
    private int price;

    public Product(){    }

    public Product(int id, String name, int price){
        this.product_id =id; this.name=name; this.price=price;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters og setters">
    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    //</editor-fold>


}
