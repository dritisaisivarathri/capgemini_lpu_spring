package com.capgemini.assignment8_LibrarySystem_7Mar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment8_LibrarySystem_7Mar.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
