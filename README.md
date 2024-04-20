# Product Catalogue

Implement RESTful API endpoints using Java for a product catalogue system, where products have a more complex, nested data structure. The system should use a database for storage, with a preference for MongoDB to take advantage of its ability to store nested documents.

# Technologies Used

1.Spring Boot

2.MongoDB

3.Postman (for API testing)


# Getting Started

To get started with the project:

Clone the repository : https://github.com/shiva0911/Product-Catalogue

Set up MongoDB and update the application.properties file with the MongoDB connection details.

Build and run the project using Maven or your preferred IDE.

Use Postman to test the API endpoints.


# API Documentation

# 1. Create a Product

Method: POST

Endpoint: http://localhost:8091/product

Request Body:json

{

    "name": "OnePlus 8",
    "description": "The OnePlus 8 is a flagship smartphone offering top-notch performanc and features.",
    "price": 699.99,
    
"category": [

    "Electronics",
    "Smartphones"
    ],
 "attributes": [
 
     {
         "key": "Display",
         "value": "6.55 inches"
      },

      {
        "key": "Processor",
        "value": "Snapdragon 865"
      },

      {
         "key": "Storage",
         "value": "128GB"
      }

    ],

"availability": {

        "inStock": false,
        "quantity": 50
    },
"ratings": [

        {
            "userId": "user-1",
            "rating": 4,
            "comment": "Great phone! Fast performance and beautiful display."
        }
    ]
}

# Response Format:

Status: 201 Created

Body:json

{

    "name": "OnePlus 8",
    "description": "The OnePlus 8 is a flagship smartphone offering top-notch performanc and features.",
    "price": 699.99,
    
"category": [

    "Electronics",
    "Smartphones"
    ],
 "attributes": [
 
     {
         "key": "Display",
         "value": "6.55 inches"
      },

      {
        "key": "Processor",
        "value": "Snapdragon 865"
      },

      {
         "key": "Storage",
         "value": "128GB"
      }

    ],

"availability": {

        "inStock": false,
        "quantity": 50
    },
"ratings": [

        {
            "userId": "user-1",
            "rating": 4,
            "comment": "Great phone! Fast performance and beautiful display."
        }
    ]
}
# 2. Update a Product

Method: PUT

Endpoint: http://localhost:8091/product/{productId}

Request Body: (Same as Create Product)

Response Format:

Status: 200 OK

Body: (Same as Create Product)

# 3. Get a Product by ID

Method: GET

Endpoint: http://localhost:8091/product/{productId}

Response Format:

Status: 200 OK

Body: (Same as Create Product)

# 4. Get All Products

Method: GET

Endpoint: http://localhost:8091/products

Response Format:

Status: 200 OK

Body: Array of Product objects (Same as Create Product)

# 5. Delete a Product

Method: DELETE

Endpoint: http://localhost:8091/product/{productId}

Response Format:

Status: 204 No Content

# 6. Search Products by Name

Method: GET

Endpoint: http://localhost:8091/products/search/name?keyword={keyword}

Response Format:

Status: 200 OK

Body: Array of Product objects (Same as Create Product)

# 7. Search Products by Category

Method: GET

Endpoint: http://localhost:8091/products/search/category?category={category}

Response Format:

Status: 200 OK

Body: Array of Product objects (Same as Create Product)

# 8. Search Products by Attribute

Method: GET

Endpoint: http://localhost:8091/products/search/attribute?key={key}&value={value}

Response Format:

Status: 200 OK

Body: Array of Product objects (Same as Create Product)

# 9. Retrieve a Paginated and Sorted List of Products

Method: GET

Endpoint: http://localhost:8091/products/list?page={page}&size={size}&sortBy={sortBy}&sortOrder={sortOrder}

Response Format:

Status: 200 OK

Body: Array of Product objects (Paginated and Sorted)

# 10. Rate a Product

Method: POST

Endpoint: http://localhost:8091/product/{productId}/rate

Request Body: Rating details

Response Format:

Status: 200 OK

Body: Updated product with ratings array

# sample JSON of the Product entity.

{

    "name": "OnePlus 8",
    "description": "The OnePlus 8 is a flagship smartphone offering top-notch performanc and features.",
    "price": 699.99,
    
"category": [

    "Electronics",
    
    "Smartphones"
    ],
 "attributes": [
 
     {
         "key": "Display",
         "value": "6.55 inches"
      },

      {
        "key": "Processor",
        "value": "Snapdragon 865"
      },

      {
         "key": "Storage",
         "value": "128GB"
      }

    ],

"availability": {

        "inStock": false,
        "quantity": 50
    },
"ratings": [

        {
            "userId": "user-1",
            "rating": 4,
            "comment": "Great phone! Fast performance and beautiful display."
        }
    ]
}
# Database Structure![Screenshot (49)](https://github.com/shiva0911/Product-Catalogue/assets/78194961/2dead6ac-ed64-4bb5-ad9b-a9b70b90d240)


# Api testing using Postman

![image]![Screenshot (50)](https://github.com/shiva0911/Product-Catalogue/assets/78194961/8be2f21b-e6e5-4a22-a4c2-4e6f91103c6c)



