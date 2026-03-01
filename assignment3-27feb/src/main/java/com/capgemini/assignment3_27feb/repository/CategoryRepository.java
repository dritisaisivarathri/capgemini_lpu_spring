package com.capgemini.assignment3_27feb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment3_27feb.dao.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer>{
	
}
