package com.demo.beans;

public class Customer {
    private static int customerCounter = 1;
    private int customerID;
    private String name;
    private String address;

    public Customer(String name, String address) {
        this.customerID = customerCounter++;
        this.name = name;
        this.address = address;
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerID + ", Name: " + name + ", Address: " + address;
    }
}
