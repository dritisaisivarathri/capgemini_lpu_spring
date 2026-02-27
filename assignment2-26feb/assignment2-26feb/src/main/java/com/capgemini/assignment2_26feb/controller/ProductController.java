package com.capgemini.assignment2_26feb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assignment2_26feb.dao.Category;
import com.capgemini.assignment2_26feb.dao.Product;
import com.capgemini.assignment2_26feb.repository.CategoryJpaRepository;
import com.capgemini.assignment2_26feb.repository.ProductJpaRepository;


@RestController
@RequestMapping("/product")
public class ProductController {
	
	
	private ProductJpaRepository productjpa;
	
	private CategoryJpaRepository categoryjpa;

	public ProductController(ProductJpaRepository productRepo, CategoryJpaRepository categoryRepo) {
		this.productjpa = productRepo;
		this.categoryjpa = categoryRepo;
	}

	@PostMapping("/{categoryId}")
	public Product createProduct(@RequestBody Product product, @PathVariable int categoryId) {
		 System.out.println("Inside createProduct");
		Category category = categoryjpa.findById(categoryId).get();
		product.setCategory(category);

		return productjpa.save(product);
	}

	@GetMapping("/getproduct")
	public List<Product> getAllProducts() {
		return productjpa.findAll();
	}

	@GetMapping("view/{id}")
	public Optional<Product> getProduct(@PathVariable int id) {
		return productjpa.findById(id);
	}

	@PutMapping("update/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product newProduct) {

		Product product = productjpa.findById(id).get();

		product.setProductName(newProduct.getProductName());
		product.setProductPrice(newProduct.getProductPrice());

		return productjpa.save(product);
	} 

	@DeleteMapping("delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productjpa.deleteById(id);
		return "Product Deleted Successfully";
	} 

	@GetMapping("/category/{category_id}") 
	public List<Product> getProductsByCategory(@PathVariable int category_id) {
		return productjpa.findByCategoryCategoryId(category_id);
	}

	@GetMapping("/search")
	public List<Product> searchProduct(@RequestParam String name) {
		return productjpa.findByProductName(name);
	}

}