package com.demo.service;

import com.demo.beans.*;
import com.demo.dao.ProductDAO;
import com.demo.service.ECommerceService;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ECommerceServiceImpl implements ECommerceService {
    private ProductDAO productDAO;
    private PriorityQueue<Order> orderQueue = new PriorityQueue<>((o1, o2) -> o1.getOrderID() - o2.getOrderID());

    public ECommerceServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public void addProduct(Product product) {
        productDAO.addProduct(product);
    }

    public void displayProducts() {
        System.out.println("\nAvailable Products:");
        for (Product product : productDAO.getAllProducts()) {
            System.out.println(product);
        }
    }

    public Product getProductById(int productID) {
        return productDAO.getProductById(productID);
    }

    public boolean placeOrder(Customer customer, ShoppingCart cart) {
        if (cart.getCartItems().isEmpty()) {
            System.out.println("Cart is empty. Add products before placing an order.");
            return false;
        }

        System.out.println("\nProcessing your order...");
        System.out.println("Order placed successfully!");

        cart.clearCart(); 
        return true;
    }

    public void updateStock(int productID, int newQuantity) {
        productDAO.updateStock(productID, newQuantity);
    }

}
