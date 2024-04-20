package com.example.demo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product 
{
	 @Id
	    private String id;
	    private String name;
	    private String description;
	    private double price;
	    private List<String> category;
	    private List<Attribute> attributes;
	    private Availability availability;
	    private List<Rating> ratings;

}
