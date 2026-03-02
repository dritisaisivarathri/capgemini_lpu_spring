package com.capgemini.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
	
	@Autowired
	UsersJpaRepository jpa;
	
	//for welcome.jsp
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}
	
	//create end point for register
	//http://localhost:8080/register
	@GetMapping("/register")
	public String createAccount() { 
		return "register";
		
	}
	 
	//read data from url using HttpServletRequest
	//http://localhost:8080/register
	//give details
	//click submit
	//then in link http://localhost:8080/create-account this should come
	//@GetMapping("/create-account")--> for return register
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String number = request.getParameter("number");
//		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
//		
//		//return "register"; 
//		return "success";
//		
//	}
	
	//instead of HttpServletRequest we are using users object
	//http://localhost:8080/register
	//give data
	//as a result--> http://localhost:8080/create-account in link 
//	@PostMapping("/create-account")
//    public String register(@ModelAttribute Users users) {
//		System.out.println(users.getEmail());
//		System.out.println(users.getName());
//		System.out.println(users.getNumber());
//		
//		return "success"; 
//	}
//	
	
	//http://localhost:8080/register
	//give details
	//select * from users in pg admin
	@PostMapping("/create-account")
    public String register(@ModelAttribute Users users) {
		jpa.save(users); 
		return "success";
	}
	//02-03-26
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String logincheck(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Users user = jpa.findByEmailAndPassword(email, password);
		if(user != null) {
			return "loginsuccess";
		} else {
			return "redirect:login"; 
		}
		
	}
	
	//Model and view
	@GetMapping("/hi") 
	public ModelAndView sendData() {
		ModelAndView m = new ModelAndView();
		List<String> names= List.of("Miller","Allen","Smith");
		m.addObject("msg",names);
		m.setViewName("abc");
		return m;
	}
	
	//for single value
	//m.addObject("msg","Miller");
	}


