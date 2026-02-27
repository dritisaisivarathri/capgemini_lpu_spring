package com.casestudy3_25feb;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class IncomeValidator implements LoanValidator{

	public boolean validateLoan(double amount) {
		// TODO Auto-generated method stub
		System.out.println("Validating using income");
		return amount <= 300000;
	}
 
}
