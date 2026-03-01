package com.capgemini.assignment3_27feb.service.impl;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assignment3_27feb.dao.Book;
import com.capgemini.assignment3_27feb.dao.Loan;
import com.capgemini.assignment3_27feb.dao.Member;
import com.capgemini.assignment3_27feb.exception.ResourceNotFoundException;
import com.capgemini.assignment3_27feb.repository.BookRepository;
import com.capgemini.assignment3_27feb.repository.LoanRepository;
import com.capgemini.assignment3_27feb.repository.MemberRepository;
import com.capgemini.assignment3_27feb.service.LoanService;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired private LoanRepository loanRepo;
    @Autowired private MemberRepository memberRepo;
    @Autowired private BookRepository bookRepo;

    public Loan issueBook(Long memberId,
                          Long bookId,
                          LocalDate dueDate){

        Member member = memberRepo.findById(memberId)
            .orElseThrow(() -> new ResourceNotFoundException("Member not found"));

        Book book = bookRepo.findById(bookId)
            .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        if(book.getCopiesAvailable() <= 0)
            throw new RuntimeException("Book not available");

        book.setCopiesAvailable(book.getCopiesAvailable()-1);

        Loan loan = new Loan();
        loan.setIssueDate(LocalDate.now());
        loan.setDueDate(dueDate);
        loan.setLoanStatus("ISSUED");
        loan.setMember(member);
        loan.setBook(book);

        bookRepo.save(book);

        return loanRepo.save(loan);
    }

    public Loan returnBook(Long loanId){

        Loan loan = loanRepo.findById(loanId)
            .orElseThrow(() -> new ResourceNotFoundException("Loan not found"));

        loan.setReturnDate(LocalDate.now());
        loan.setLoanStatus("RETURNED");

        Book book = loan.getBook();
        book.setCopiesAvailable(book.getCopiesAvailable()+1);

        bookRepo.save(book);

        return loanRepo.save(loan); 
    }
}
