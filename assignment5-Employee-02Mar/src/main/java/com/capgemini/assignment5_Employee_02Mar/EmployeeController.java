package com.capgemini.assignment5_Employee_02Mar;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	private EmployeeService service;
	
	public EmployeeController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}
	
//	@PostMapping("/create")
//	public ModelAndView create(@ModelAttribute Employee e){
//		return service.createEmployee(e);  
//	
//		
//	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute Employee e, Model m){
		return service.createEmployee(e,m);  
	
		
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public ModelAndView getDetails(HttpServletRequest request) {
		return service.login(request.getParameter("email"), request.getParameter("password"));
	}
	
	//for delete
	@PostMapping("/delete-selected")
	public ModelAndView deleteSelected(@RequestParam(value="selectedEmails",required=false)
	List<String> emails) {
		return service.deleteSelected(emails);
	}

	 @GetMapping("/listEmployee")
	    public ModelAndView listEmployee() {
	        return service.getAllEmployees();
	    }
	 
	 //for update
	 @PostMapping("/update-selected")
	 public ModelAndView updateSelected(
	         @RequestParam("selectedEmail") String email) {

	     return service.getEmployeeForUpdate(email);
	 }
	 
	 @PostMapping("/update-employee")
	 public ModelAndView updateEmployee(Employee emp) {

	     return service.updateEmployee(emp);
	 }
	    
	
	    
	    
	

	}



/* first register
 * http://localhost:8080/register -> for user
 * http://localhost:8080/register -> for admin
 * next do login
 * http://localhost:8080/login -> as user
 * http://localhost:8080/login -> as admin
 * 
  */
