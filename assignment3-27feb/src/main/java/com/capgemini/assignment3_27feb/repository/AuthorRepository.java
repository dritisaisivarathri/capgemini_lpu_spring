package com.capgemini.assignment3_27feb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment3_27feb.dao.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
