package com.capgemini.dao;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.dto.Employee;
import com.capgemini.main.JpaUtil;

@Repository
public class EmployeeDao {
	
//	@Autowired
//EntityManager entityManager;
	
	@Autowired
	JpaUtil jpa;
	
	private EntityManager em;
	
	public void init() {
		em= jpa.getEntityManager();
	}
	
	//EntityManager em = jpa.getEntityManager();
	//method for crud operations
	public void insert(Employee e) {
		em.getTransaction().begin();
		Employee employee = findById(e.getId());
		em.getTransaction().commit();
	}
	
	public Employee findById(int id) {
		return em.find(Employee.class,id); 
	}
	
	public void delete(Employee e) {
		em.getTransaction().begin();
		Employee employee = findById(e.getId());
		if(employee != null){
			em.remove(e);
		} else {
			System.out.println("Data already deleted");
		}
		em.getTransaction().commit();
	}
	
	public void update(Employee e) {
		em.getTransaction().begin();
		Employee employee = findById(e.getId());
		if(employee != null) {
			e.setSalary(50000);
		} else {
			System.out.println("Employee not found");
		}
		em.getTransaction().commit();
		
	}

}
