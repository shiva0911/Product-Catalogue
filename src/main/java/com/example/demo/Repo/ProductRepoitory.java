package com.example.demo.Repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.Entity.Attribute;
import com.example.demo.Entity.Product;
import java.util.*;
public interface ProductRepoitory extends MongoRepository<Product, String> 
{
	List<Product> findByNameContainingIgnoreCaseAndCategoryInAndAttributesIn(
	        String name,
	        List<String> category,
	        List<Attribute> attributes
	    );
	
}
