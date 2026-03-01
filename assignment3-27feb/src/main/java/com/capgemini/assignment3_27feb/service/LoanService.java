package com.capgemini.assignment3_27feb.service;

import java.time.LocalDate;

import com.capgemini.assignment3_27feb.dao.Loan;

public interface LoanService {
	
	Loan issueBook(Long memberId, Long bookId, LocalDate dueDate);
    Loan returnBook(Long loanId);

} 
