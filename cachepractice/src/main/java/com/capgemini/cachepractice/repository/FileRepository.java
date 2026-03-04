package com.capgemini.cachepractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.cachepractice.entity.FileData;

public interface FileRepository extends JpaRepository<FileData, Integer>{

}
