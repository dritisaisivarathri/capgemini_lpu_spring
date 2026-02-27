package com.capgemini.assignment2_26feb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment2_26feb.dao.Category;

public interface CategoryJpaRepository extends JpaRepository<Category, Integer> {

}
