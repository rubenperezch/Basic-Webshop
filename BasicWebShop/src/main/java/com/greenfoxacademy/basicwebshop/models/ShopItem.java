package com.greenfoxacademy.basicwebshop.models;

public class ShopItem {
    String brand;
    String type;
    String model;
    Double price;
    Integer stock;

    public ShopItem(String brand, String type, String model, Double price, Integer stock) {
        this.brand = brand;
        this.type = type;
        this.model = model;
        this.price = price;
        this.stock = stock;
    }

    public ShopItem() {
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}