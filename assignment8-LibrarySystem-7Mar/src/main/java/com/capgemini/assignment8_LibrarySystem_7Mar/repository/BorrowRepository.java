package com.capgemini.assignment8_LibrarySystem_7Mar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment8_LibrarySystem_7Mar.entity.BorrowRecord;

public interface BorrowRepository extends JpaRepository<BorrowRecord, Long>{

} 
