package com.capgemini.assignment3_27feb.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assignment3_27feb.dao.Loan;
import com.capgemini.assignment3_27feb.service.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    @PostMapping("/issue")
    public Loan issue(@RequestParam Long memberId,
                      @RequestParam Long bookId,
                      @RequestParam String dueDate){

        return service.issueBook(
                memberId,
                bookId,
                LocalDate.parse(dueDate));
    }

    @PutMapping("/{loanId}/return")
    public Loan returnBook(@PathVariable Long loanId){
        return service.returnBook(loanId);
    }
}