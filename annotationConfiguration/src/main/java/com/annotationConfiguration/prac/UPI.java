package com.annotationConfiguration.prac;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component 
public class UPI implements Payment{
	public void send() {
		System.out.println("Payment through UPI");
	}

}
