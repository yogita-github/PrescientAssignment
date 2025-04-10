package com.demo.dao;

import com.demo.beans.Product;
import java.util.List;

public interface ProductDAO {
    void addProduct(Product product);
    Product getProductById(int productID);
    List<Product> getAllProducts();
	void updateStock(int productID, int newQuantity);
}
