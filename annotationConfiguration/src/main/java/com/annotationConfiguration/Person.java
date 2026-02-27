//EXAMPLE OF DEPENDENCY INJECTION
package com.annotationConfiguration;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//with @component only bean will be created
@Component 
public class Person {
	
	//having reference of mobile
	//we will have null or reference
	
	@Autowired 
	private Scanner scan; //null
	
	//@Autowired
	private Mobile mobile;
	
	public void message() {
		System.out.println("Hello");
		
		
	}

	public Mobile getMobile() {
		return mobile;
	}
    
	//@Autowired
	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}

	public Scanner getScan() {
		return scan;
	}

	public void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	public Person(Mobile mobile) {
		this.mobile = mobile;
	}
	
	

}
