package com.capgemini.assignment3_27feb.service;

import java.util.List;

import com.capgemini.assignment3_27feb.dao.Book;

public interface BookService {
	 Book addBook(Book book);
	 
	 Book getBook(Long id);
	 
	 List<Book> getAllBooks(); 

}
