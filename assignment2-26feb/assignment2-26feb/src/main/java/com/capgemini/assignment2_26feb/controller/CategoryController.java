package com.capgemini.assignment2_26feb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assignment2_26feb.dao.Category;
import com.capgemini.assignment2_26feb.repository.CategoryJpaRepository;



@RestController
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	CategoryJpaRepository categoryjpa;
	
	@PostMapping("/category") 
	public Category createCategory(@RequestBody Category c) {
		System.out.println(c);
		return categoryjpa.save(c); 
	}
	
	@GetMapping("/view")
	//http://localhost:8080/view
	public List<Category> getAllCategories() {
		return categoryjpa.findAll();
	}

	@GetMapping("/{id}")
	//http://localhost:8080/3
	public Optional<Category> getCategory(@PathVariable int id) {
		return categoryjpa.findById(id);
	}

	@PutMapping("update/{id}")
	//http://localhost:8080/update/2
	public Category updateCategory(@PathVariable int id, @RequestBody Category newCategory) {

		Category category = categoryjpa.findById(id).get();

		category.setCategoryName(newCategory.getCategoryName());
		category.setCategoryDescription(newCategory.getCategoryDescription());

		return categoryjpa.save(category); 
	}
	
	@DeleteMapping("delete/{id}")
	//http://localhost:8080/update/2
    public String deleteCategory(@PathVariable int id) {
        categoryjpa.deleteById(id);
        return "Category Deleted Successfully";
    }
	
	@GetMapping("/categories/{page}/{size}")
	//http://localhost:8080/categories/0/2
	public List<Category> getCategory(@PathVariable int page, @PathVariable int size) {
		
		//Page<Category> p=categoryjpa.findAll(PageRequest.of(page,size));
		//if to add sort
		Page<Category> p=categoryjpa.findAll(PageRequest.of(page,size,Sort.by("categoryId").descending()));
		return p.getContent();  
	}
	
//	@GetMapping("get-id/{id}")
//	//http://localhost:8080/get-id/1
//	//http://localhost:8080/get-id/7
//	
//	public Category getById(@PathVariable int id) {
//		Optional<Category>optional = categoryjpa.findById(id);
//		Category c = null;
//		if(optional.isPresent()) {
//			c = optional.get(); 
//			return c;
//		} else {
//			throw new CategoryNotFoundException("Catyegory not found by id"+id);
//		}
//				
//	}
	
	
	//custom status code
	@GetMapping("get-id/{id}")
	//http://localhost:8080/get-id/1
	//http://localhost:8080/get-id/16
	
	public ResponseEntity<Category> getById(@PathVariable int id) { 
		Optional<Category>optional = categoryjpa.findById(id);
		Category c = null;
		if(optional.isPresent()) {
			c=optional.get();
			return new ResponseEntity<Category>(c,HttpStatus.FOUND); 
		} else {
			return new ResponseEntity<Category>(c,HttpStatus.NOT_FOUND); 
		}
				
	}
	

}
