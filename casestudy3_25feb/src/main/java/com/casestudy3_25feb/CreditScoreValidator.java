package com.casestudy3_25feb;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary 
public class CreditScoreValidator implements LoanValidator {
	
	public boolean validateLoan(double amount) {
		System.out.println("Validate using credit score");
		return amount <= 500000;
	}

}
