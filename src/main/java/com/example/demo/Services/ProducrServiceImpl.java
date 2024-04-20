package com.example.demo.Services;
import org.springframework.data.domain.Sort;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import com.example.demo.Entity.Attribute;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.Rating;
import com.example.demo.Repo.ProductRepoitory;
import org.springframework.data.domain.Pageable;
@Service
public class ProducrServiceImpl implements ProductService {

	@Autowired
	private ProductRepoitory productRepoitory;
	@Override
	public Product addProduct(Product product) {
	
		return productRepoitory.save(product);
	}

	@Override
	public Product getProductById(String id) {
		
		return productRepoitory.findById(id).orElse(null);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productRepoitory.findAll();
	}

	@Override
	public Product updateProduct(String id, Product product) 
	{
		 Optional<Product> existing = productRepoitory.findById(id);
	        if (existing.isPresent()) {
	            Product existingProduct = existing.get();
	            existingProduct.setName(product.getName());
	            existingProduct.setDescription(product.getDescription());
	            existingProduct.setPrice(product.getPrice());
	            existingProduct.setCategory(product.getCategory());
	            existingProduct.setAttributes(product.getAttributes());
	            existingProduct.setAvailability(product.getAvailability());
	            existingProduct.setRatings(product.getRatings());
	            return productRepoitory.save(existingProduct);
	        }	
	        return null;
		
	}

	@Override
	public void deleteProduct(String id) 
	{
		 Optional<Product> existingProductOptional = productRepoitory.findById(id);
	        if (existingProductOptional.isPresent()) {
	        	productRepoitory.deleteById(id);
	        }
	}

	 @Override
	    public List<Product> searchProducts(String name, List<String> category, List<Attribute> attributes)
	 {
		        List<Product> products = productRepoitory.findAll();
		        
		        if (name != null) {
		            products = products.stream()
		                .filter(product -> product.getName().equalsIgnoreCase(name))
		                .collect(Collectors.toList());
		        }
		        
		        if (category != null && !category.isEmpty()) {
		            products = products.stream()
		                .filter(product -> product.getCategory().containsAll(category))
		                .collect(Collectors.toList());
		        }
		        
		        if (attributes != null && !attributes.isEmpty()) {
		            products = products.stream()
		                .filter(product -> product.getAttributes().containsAll(attributes))
		                .collect(Collectors.toList());
		        }
		        
		        return products;
		    }
	 	@Override
	 	public Page<Product> getAllProducts(int page, int size, String sortField, String sortOrder) {
	        Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortField).ascending() : Sort.by(sortField).descending();
	        Pageable pageable = PageRequest.of(page, size, sort);
	        return productRepoitory.findAll(pageable);
	    }
	 	 @Override
	     public Product rateProduct(String productId, Rating rating) {
	         Optional<Product> optionalProduct = productRepoitory.findById(productId);
	         if (optionalProduct.isPresent()) {
	             Product product = optionalProduct.get();
	             List<Rating> ratings = product.getRatings();
	             ratings.add(rating);
	             product.setRatings(ratings);
	             return productRepoitory.save(product);
	         } else {
	             throw new RuntimeException("Product not found with id: " + productId);
	         }
	     }

	 }
	       




