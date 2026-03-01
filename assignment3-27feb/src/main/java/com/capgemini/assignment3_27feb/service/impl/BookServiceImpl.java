package com.capgemini.assignment3_27feb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.assignment3_27feb.dao.Book;
import com.capgemini.assignment3_27feb.exception.ResourceNotFoundException;
import com.capgemini.assignment3_27feb.repository.BookRepository;
import com.capgemini.assignment3_27feb.service.BookService;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository repo;

    public Book addBook(Book book){
        return repo.save(book);
    }

    public Book getBook(Long id){
        return repo.findById(id)
          .orElseThrow(() ->
              new ResourceNotFoundException("Book not found"));
    }

    public List<Book> getAllBooks(){
        return repo.findAll();
    }
}