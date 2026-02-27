package com.casestudy1_25thfeb;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService{
	
	private TransactionLogger logger;
	public UpiPayment(TransactionLogger logger) {
		this.logger = logger;
	}
	
	public void processPayment(double amount) {
		System.out.println("Upi payment" + amount);
		logger.log("Upi payment" + amount);
		
	}
}