package com.secritypractice.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PracticeController {
	
	
	@GetMapping("/practices")
	//http://localhost:8080/practices
	public String getDetails() {
		return "Details";
	}
	
	@GetMapping("/admin")
	//http://localhost:8080/practices/delete
	public String deleteUser() {
		return "Delete";
	} 

}
