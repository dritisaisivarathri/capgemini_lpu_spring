package com.casestudy1_25thfeb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component 
public class TransactionLogger {
	public TransactionLogger() {
		System.out.println("TransactionLogger constructor");
	}
	
	 @PostConstruct
	public void init() {
		System.out.println("Logger initialized");
	}
	 
	 public void log(String message) {
		 System.out.println("Transaction log: " + message);
	 }
	
	 @PreDestroy
	public void destroy() {
		System.out.println("Logger destroyed");
	}

}
