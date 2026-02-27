package com.capgemini.spingbootbasic.CustomMethodQuery;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
	@Autowired
	CustomerJpaRepository customerjpa;
	@PostMapping("/customer")
	public Customer createCustomer(@RequestBody Customer c) {
		System.out.println(c);
		return customerjpa.save(c);
	}
	
	@GetMapping("/find-email/{email}")
	public Customer getCustomerByEmail(@PathVariable String email) {
		return customerjpa.getByEmail(email);
	}
	
	@GetMapping("/find-emailName/{name}/{email}")
	public Customer getCustomerByNameAndEmail(@PathVariable String name,@PathVariable String email) {
		return customerjpa.findByNameAndEmail(name, email);
	}
	
	@GetMapping("/find-emailOrName/{name}/{email}")
	public List<Customer> getCustomerByNameOrEmail(@PathVariable String name,@PathVariable String email) {
		return customerjpa.findByNameOrEmail(name, email);
	}
	

}