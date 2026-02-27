package com.casestudy3_25feb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BankConfig.class);
		
		LoanService loanService = context.getBean(LoanService.class);
		
		loanService.applyLoan(250000);
		
		LoanValidator v1 = context.getBean(IncomeValidator.class);
		LoanValidator v2 = context.getBean(IncomeValidator.class);
		
		System.out.println(v1);
		System.out.println(v2);
		
		context.close();
	}

}