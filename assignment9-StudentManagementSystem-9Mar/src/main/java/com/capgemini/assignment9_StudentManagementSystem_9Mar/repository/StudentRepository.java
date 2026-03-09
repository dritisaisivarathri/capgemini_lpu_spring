package com.capgemini.assignment9_StudentManagementSystem_9Mar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment9_StudentManagementSystem_9Mar.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
