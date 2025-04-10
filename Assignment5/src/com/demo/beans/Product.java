package com.demo.beans;

import java.util.Objects;

public class Product {
    private static int productCounter = 1;
    private int productID;
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.productID = productCounter++;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public int getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void increaseStock(int quantity) {
        this.stock += quantity;
    }

    public boolean reduceStock(int quantity) {
        if (quantity > stock) {
            return false;
        }
        stock -= quantity;
        return true;
    }
  

    @Override
    public String toString() {
        return "Product ID: " + productID + ", Name: " + name + ", Price: Rs" + price + ", Stock: " + stock;
    }
}
