package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.stream.Collectors;
import com.example.demo.Entity.Attribute;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Rating;
import com.example.demo.Services.ProducrServiceImpl;
import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/product")
public class ProductController
{
	@Autowired
	private ProducrServiceImpl producrServiceImpl;
	@PostMapping
	 public Product addProduct(@RequestBody Product product) {
        return producrServiceImpl.addProduct(product);
    }
	@GetMapping("/{id}")
	
	 public Product getProductById(@PathVariable String id) {
        return producrServiceImpl.getProductById(id);
    }
	
	@GetMapping
	public List<Product> getAllProducts() {
        return producrServiceImpl.getAllProducts();
    }
	
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable String id, @RequestBody Product product) {
        return producrServiceImpl.updateProduct(id, product);
    }
	
	
	@DeleteMapping("/{id}")
	 public void deleteProduct(@PathVariable String id) {
		producrServiceImpl.deleteProduct(id);
    }
	@GetMapping("/search")
	public ResponseEntity<Object> searchProducts(
	    @RequestParam(required = false) String name,
	    @RequestParam(required = false) List<String> category,
	    @RequestParam(required = false) List<Attribute> attributes) {
	    
	    List<Product> products = producrServiceImpl.searchProducts(name, category, attributes);
	    
	    if (name != null) {
	        products = products.stream()
	            .filter(product -> product.getName().equalsIgnoreCase(name))
	            .collect(Collectors.toList());
	    }
	    
	    if (products.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found.");
	    } else 
	    {
	        return ResponseEntity.ok(products);
	    }
	   }
	 @GetMapping("/list")
	    public ResponseEntity<Object> getAllProducts(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam(defaultValue = "name") String sortBy,
	            @RequestParam(defaultValue = "asc") String sortOrder) {

	        Page<Product> productsPage = producrServiceImpl.getAllProducts(page, size, sortBy, sortOrder);

	        if (productsPage.isEmpty()) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No products found.");
	        } else {
	            return ResponseEntity.ok(productsPage.getContent());
	        }
	    }

	    @PostMapping("/{id}/rate")
	    public ResponseEntity<Object> rateProduct(
	            @PathVariable String productId,
	            @RequestBody Rating rating) {
	        try {
	            Product product = producrServiceImpl.rateProduct(productId, rating);
	            return ResponseEntity.ok(product);
	        } catch (RuntimeException e) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	        }
	    }
	 

}
