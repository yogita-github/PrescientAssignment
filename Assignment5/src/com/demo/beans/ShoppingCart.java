package com.demo.beans;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<Product, Integer> cartItems = new HashMap<>();

    public boolean addProduct(Product product, int quantity) {
        if (product.getStock() < quantity) {
            System.out.println("Not enough stock available for " + product.getName());
            return false;
        }
        product.reduceStock(quantity);
        cartItems.put(product, cartItems.getOrDefault(product, 0) + quantity);
        System.out.println(quantity + " " + product.getName() + "(s) added to cart.");
		return true;
    }

    public boolean removeProduct(Product product, int quantity) {
        if (!cartItems.containsKey(product)) {
            System.out.println("Product not found in cart.");
            return false;
        }
        int currentQuantity = cartItems.get(product);
        if (quantity >= currentQuantity) {
            cartItems.remove(product);
        } else {
            cartItems.put(product, currentQuantity - quantity);
        }
        product.increaseStock(quantity);
        System.out.println(quantity + " " + product.getName() + "(s) removed from cart.");
		return true;
    }

    public void displayCart() {
        if (cartItems.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }
        System.out.println("\nShopping Cart:");
        for (Map.Entry<Product, Integer> entry : cartItems.entrySet()) {
            System.out.println(entry.getKey().getName() + " - Quantity: " + entry.getValue());
        }
    }

    public Map<Product, Integer> getCartItems() {
        return cartItems;
    }
    public void clearCart() {
        cartItems.clear();
    }
}
