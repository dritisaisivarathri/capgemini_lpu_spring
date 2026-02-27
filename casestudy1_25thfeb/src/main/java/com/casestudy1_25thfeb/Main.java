package com.casestudy1_25thfeb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PaymentProcessor processor = context.getBean(PaymentProcessor.class);
		
		processor.makePayment(4000);
		
		PaymentService upi1 = context.getBean(UpiPayment.class);
		PaymentService upi2 = context.getBean(UpiPayment.class);
		
		System.out.println(upi1);
		System.out.println(upi2);
		
		context.close();
	}

}