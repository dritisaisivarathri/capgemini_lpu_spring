package com.capgemini.assignment5_Employee_02Mar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment5_Employee_02Mar.entity.Employee;


public interface EmployeeJpaRepository extends JpaRepository<Employee, String>{

	public Employee findByEmailAndPassword(String email, String password);
}
