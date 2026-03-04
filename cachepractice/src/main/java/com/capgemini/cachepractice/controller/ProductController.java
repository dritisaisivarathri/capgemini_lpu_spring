package com.capgemini.cachepractice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.service.ProductService;

@RestController
public class ProductController {
	
	private ProductService service;
	
	
	
	public ProductController(ProductService service) {
		this.service = service;
	}

      //to create
     @PostMapping("/create")
     //http://localhost:8080/create
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p); 
		
	}
     
     //to fetch
     @GetMapping("/find-id/{id}")
    // http://localhost:8080/find-id/1
     public Product getProductById(@PathVariable int id) {
    	 return service.getById(id);
     }
     
     //to update
     @PutMapping("/update")
  // http://localhost:8080/update
     public Product updateProduct(@RequestBody Product p) {
    	 return service.updateProduct(p);
     }
     
     //to delete
     @DeleteMapping("/delete-id/{id}")
  // http://localhost:8080/delete-id/1
     public String deleteProduct(@PathVariable int id) {
    	 service.deleteProduct(id);
    	 return "Product deleted successfully";
     }
	
	

}
