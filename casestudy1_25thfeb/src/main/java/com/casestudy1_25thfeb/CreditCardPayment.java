package com.casestudy1_25thfeb;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy 
public class CreditCardPayment implements PaymentService{
	
	private TransactionLogger logger;
	public CreditCardPayment(TransactionLogger logger) {
		this.logger = logger;
	}
	public void processPayment(double amount) {
		System.out.println("credit card payment" + amount);
		logger.log("payment success" + amount);
		
	}
}
