package com.demo.test;

import com.demo.beans.*;
import com.demo.dao.ProductDAOImpl;
import com.demo.service.ECommerceService;
import com.demo.service.ECommerceServiceImpl;

import java.util.Map;
import java.util.Scanner;

public class ECommerceTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ECommerceService service = new ECommerceServiceImpl(new ProductDAOImpl());
        ShoppingCart cart = new ShoppingCart();

        service.addProduct(new Product("Laptop", 70000, 10));
        service.addProduct(new Product("Phone", 25000, 5));
        service.addProduct(new Product("Headphones", 3000, 15));

        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        System.out.print("Enter your address: ");
        String address = sc.nextLine();
        Customer customer = new Customer(name, address);

        while (true) {
            System.out.println("\n===== E-Commerce Menu =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Cart");
            System.out.println("3. Remove Product from Cart");
            System.out.println("4. View Cart");
            System.out.println("5. Place Order");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = sc.nextInt();
            sc.nextLine();  

            switch (choice) {
                case 1:
                    service.displayProducts();
                    break;

                case 2:
                    System.out.print("Enter Product ID to add to cart: ");
                    int addProductId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int addQuantity = sc.nextInt();
                    sc.nextLine();

                    Product productToAdd = service.getProductById(addProductId);
                    if (productToAdd != null) {
                        if (cart.addProduct(productToAdd, addQuantity)) {
                            System.out.println("Product added to cart successfully.");
                        }
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Product ID to remove from cart: ");
                    int removeProductId = sc.nextInt();
                    System.out.print("Enter Quantity: ");
                    int removeQuantity = sc.nextInt();
                    sc.nextLine();

                    Product productToRemove = service.getProductById(removeProductId);
                    if (productToRemove != null) {
                        if (cart.removeProduct(productToRemove, removeQuantity)) {
                            System.out.println("Product removed from cart.");
                        }
                    } else {
                        System.out.println("Invalid Product ID.");
                    }
                    break;

                case 4:
                    cart.displayCart();
                    break;

                case 5:
                    if (service.placeOrder(customer, cart)) {
                        System.out.println("\nOrder placed successfully!");
                        System.out.println("Customer Details:");
                        System.out.println("Name: " + customer.getName());
                        System.out.println("Address: " + customer.getAddress());

                        for (Map.Entry<Product, Integer> entry : cart.getCartItems().entrySet()) {
                            Product product = entry.getKey();
                            int quantityBought = entry.getValue();
                            service.updateStock(product.getProductID(), product.getStock() - quantityBought);
                        }

                        System.out.println("Stock updated successfully!");
                    } else {
                        System.out.println("Order could not be placed. Please try again.");
                    }
                    break;


                case 6:
                    System.out.println("Exiting... Thank you for shopping!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
