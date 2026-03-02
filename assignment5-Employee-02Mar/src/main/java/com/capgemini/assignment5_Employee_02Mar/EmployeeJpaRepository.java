package com.capgemini.assignment5_Employee_02Mar;

import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeJpaRepository extends JpaRepository<Employee, String>{

	public Employee findByEmailAndPassword(String email, String password);
}
