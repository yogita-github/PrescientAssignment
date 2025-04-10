package com.demo.service;

import com.demo.beans.*;

public interface ECommerceService {
    void addProduct(Product product);
    void displayProducts();
    Product getProductById(int productID);
    boolean placeOrder(Customer customer, ShoppingCart cart);
    void updateStock(int productID, int newQuantity);

}
