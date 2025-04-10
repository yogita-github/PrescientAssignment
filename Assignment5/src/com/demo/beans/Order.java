package com.demo.beans;

import java.util.Map;

public class Order {
    private static int orderCounter = 1;
    private int orderID;
    private Customer customer;
    private Map<Product, Integer> items;

    public Order(Customer customer, Map<Product, Integer> items) {
        this.orderID = orderCounter++;
        this.customer = customer;
        this.items = items;
    }

    public int getOrderID() {
        return orderID;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderID + ", Customer: " + customer.getName();
    }
}
