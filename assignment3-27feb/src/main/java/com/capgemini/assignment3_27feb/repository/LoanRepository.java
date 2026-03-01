package com.capgemini.assignment3_27feb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.assignment3_27feb.dao.Loan;

public interface LoanRepository  extends JpaRepository<Loan,Long> {
	
	List<Loan> findByMemberMemberId(Long memberId);

}
