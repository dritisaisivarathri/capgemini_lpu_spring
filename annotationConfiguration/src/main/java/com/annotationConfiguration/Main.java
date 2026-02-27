
package com.annotationConfiguration;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ioc =new AnnotationConfigApplicationContext(DemoConfiguration.class); 
		
		//to fetch bean
//		Employee e = ioc.getBean(Employee.class);
//		System.out.println(e); 
//		System.out.println(e.getId());
//		System.out.println(e.getName());
		
		Person person = ioc.getBean(Person.class);
		System.out.println(person);
		//calling for mobile which is in person class 
		System.out.println(person.getMobile());
		
		//calling for mobile
		System.out.println(ioc.getBean(Mobile.class));
		
		//calling for scanner
		//System.out.println(person.getScan());
		
		//System.out.println(ioc.getBean(List.class)); gives empty list

//how to write to add elements by ourselves		
//		List<String> list = ioc.getBean(List.class);
//		list.add("10");
//		list.add("20");
//		System.out.println(list);
		
//how to write if already values are given in method
		List<String> list = ioc.getBean(List.class);
		System.out.println(list);
		
		HashMap<Integer, String> map = ioc.getBean(HashMap.class);
		System.out.println(map); 

	}

}
