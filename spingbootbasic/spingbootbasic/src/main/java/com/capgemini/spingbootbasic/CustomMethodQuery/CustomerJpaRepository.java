package com.capgemini.spingbootbasic.CustomMethodQuery;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository 
public interface CustomerJpaRepository extends JpaRepository<Customer, Integer>{
	
	public Customer getByEmail(String email); 
	
	public Customer findByNameAndEmail(String name, String email);
	
    List<Customer> findByNameOrEmail(String name, String email);

} 
