package com.capgemini.assignment3_27feb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.assignment3_27feb.dao.Book;
import com.capgemini.assignment3_27feb.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping
    public Book add(@RequestBody Book book){
        return service.addBook(book);
    }

    @GetMapping("/{id}")
    public Book get(@PathVariable Long id){
        return service.getBook(id);
    }

    @GetMapping
    public List<Book> all(){
        return service.getAllBooks();
    }
}
