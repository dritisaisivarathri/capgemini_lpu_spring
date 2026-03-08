package com.capgemini.assignment8_LibrarySystem_7Mar.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assignment8_LibrarySystem_7Mar.entity.Book;
import com.capgemini.assignment8_LibrarySystem_7Mar.entity.BorrowRecord;
import com.capgemini.assignment8_LibrarySystem_7Mar.entity.User;
import com.capgemini.assignment8_LibrarySystem_7Mar.repository.BookRepository;
import com.capgemini.assignment8_LibrarySystem_7Mar.repository.BorrowRepository;
import com.capgemini.assignment8_LibrarySystem_7Mar.repository.UserRepository;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public BorrowRecord borrowBook(Long userId, Long bookId){

        User user = userRepository.findById(userId).orElseThrow();
        Book book = bookRepository.findById(bookId).orElseThrow();

        if(!book.isAvailable()){
            throw new RuntimeException("Book not available");
        }

        BorrowRecord record = new BorrowRecord();
        record.setUser(user);
        record.setBook(book);
        record.setBorrowDate(LocalDate.now());
        record.setReturned(false);

        book.setAvailable(false);
        bookRepository.save(book);

        return borrowRepository.save(record);
    }
}
