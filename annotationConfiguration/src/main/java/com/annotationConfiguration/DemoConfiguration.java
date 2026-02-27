package com.annotationConfiguration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration 
@ComponentScan(basePackages = "com")
public class DemoConfiguration {
	
	//for 3 party classes
	@Bean
	public Scanner getScanner() {
		return new Scanner(System.in); 
	}
	
	//creating list object
	//creating bean object
	//bean will be created based on return type
	//method to add elements by us 
//	@Bean 
//	public List<String> getList(){
//		return new ArrayList<String>();
//	} 
	
	
	//method to add elements by itself
	@Bean
	public List<String> getabc(){
		return List.of("Miller","driti");
	}
	 
	@Bean
	public HashMap<Integer, String> getpqr(){
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Lasya");
		map.put(2, "Harsha");
		return map; 
	}

}
