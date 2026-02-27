package com.basic_of_spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		//MANUALLY CREATING OBJECT
		//Person person = new Person();
		//person.message();
		
		//execute configure file
		//built-in frameworks
		//bean factory- existing from spring1 - called as core container- we will not use
		//application context- [interface]- inside this we have methods this methods will help us to call configure file
		
		//creating ioc container
		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
		Person person = ioc.getBean("person",Person.class);
		System.out.println(person);
		person.message();
		
		
		Employee employee = ioc.getBean("employee",Employee.class);
		System.out.println("Employee details");
		System.out.println(employee);
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		System.out.println(employee.getSalary());
		
	

	}

}
