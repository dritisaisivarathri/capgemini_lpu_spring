package com.capgemini.cachepractice.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.repository.ProductRepository;



@Service
public class ProductService {
	
	private ProductRepository repository;

	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	//to save data in cache name of cache and key what we need to keep here it is id
	@CachePut(cacheNames = "product",key="#result.id") 
	public Product addProduct(Product p) {
		return repository.save(p); 
	}
	
	//for fetch
	@Cacheable(cacheNames="product",key="#id")
	public Product getById(int id) {
		return repository
				.findById(id)
				.orElseThrow(()->new RuntimeException("Id not exist")); 
	}
	
	//for update 
	@CachePut(cacheNames="product",key="#p.id")
	public Product updateProduct(Product p) {
		if(!repository.existsById(p.getId())) {
			throw new RuntimeException("Product not found");
		}
		return repository.save(p); 
	}
	
	//for delete
	@CacheEvict(cacheNames="product",key="#id")
	public void deleteProduct(int id) {
		if(!repository.existsById(id)) {
			throw new RuntimeException("Product not found");
		}
		repository.deleteById(id);
	}

}
