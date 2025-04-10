package com.demo.dao;

import com.demo.beans.Product;
import com.demo.dao.ProductDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductDAOImpl implements ProductDAO {
    private Map<Integer, Product> productCatalog = new HashMap<>();

    public void addProduct(Product product) {
        productCatalog.put(product.getProductID(), product);
    }

    public Product getProductById(int productID) {
        return productCatalog.get(productID);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(productCatalog.values());
    }
    public void updateStock(int productID, int newQuantity) {
        Product product = productCatalog.get(productID);
        if (product != null) {
            product.setStock(newQuantity);
        } else {
            System.out.println("Product not found.");
        }
    }

}
