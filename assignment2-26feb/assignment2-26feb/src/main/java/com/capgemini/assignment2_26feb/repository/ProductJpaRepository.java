package com.capgemini.assignment2_26feb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment2_26feb.dao.Product;

public interface ProductJpaRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByProductName(String product_name);
	List<Product> findByCategoryCategoryId(int categoryId);  

}
