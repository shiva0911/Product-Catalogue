package com.example.demo.Services;
import java.util.*;

import org.springframework.data.domain.Page;

import com.example.demo.Entity.Attribute;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Rating;
public interface ProductService
{
	 Product addProduct(Product product);
	    Product getProductById(String id);
	    List<Product> getAllProducts();
	    Product updateProduct(String id, Product product);
	    void deleteProduct(String id);
	    List<Product> searchProducts(String name, List<String> category, List<Attribute> attributes);
	    Page<Product> getAllProducts(int page, int size, String sortField, String sortOrder);
	    Product rateProduct(String id, Rating rating);
}
