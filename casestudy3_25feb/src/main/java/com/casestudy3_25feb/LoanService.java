package com.casestudy3_25feb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component 
public class LoanService {
	private LoanValidator loanValidator;
	private AuditService auditService;
	
	public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
		this.loanValidator = loanValidator;
	}
	
	@Autowired
	public void setAuditService(AuditService auditService) {
		this.auditService = auditService;
	}
	public void applyLoan(double amount) {
		boolean result = loanValidator.validateLoan(amount);
		
		if(result) {
			System.out.println("Loan approved");
			auditService.audit("Loan approved for amount: " + amount);
		} else {
			System.out.println("Loan rejected");
			auditService.audit("Loan rejected " + amount);
		}
	}

}