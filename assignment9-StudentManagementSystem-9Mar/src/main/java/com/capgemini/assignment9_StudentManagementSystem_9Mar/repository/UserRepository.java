package com.capgemini.assignment9_StudentManagementSystem_9Mar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment9_StudentManagementSystem_9Mar.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByUsername(String username);

}
