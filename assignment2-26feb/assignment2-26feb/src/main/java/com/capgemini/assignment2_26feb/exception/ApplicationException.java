package com.capgemini.assignment2_26feb.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationException {
	
	@ExceptionHandler(Exception.class)
	public String handleException() {
	return "Exception Handle Method";
	}
	
	@ExceptionHandler(DataNotExist.class) 
	public String handleException1() {
		return "Exception Handle Method";
		}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	public String handleException(CategoryNotFoundException ex) {
		return ex.getMessage();
	}

}
