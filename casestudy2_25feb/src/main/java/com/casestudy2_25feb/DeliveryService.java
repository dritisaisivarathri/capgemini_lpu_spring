package com.casestudy2_25feb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component 
@Scope("singleton")
public class DeliveryService {
	public DeliveryService() {
		System.out.println("DeliveryService constructor");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Delivery Service Ready");
	}
	
	public void deliverOrder() {
		System.out.println("Order delivered");
	}
	@PreDestroy
	public void destroy() {
		System.out.println("Delivery service closed");
	}

}