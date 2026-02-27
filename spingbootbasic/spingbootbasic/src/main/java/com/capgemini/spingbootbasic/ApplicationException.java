package com.capgemini.spingbootbasic;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//works for exceptions which are not handled in code like white label error
//global exception
@RestControllerAdvice
public class ApplicationException {
	//handle exception
		@ExceptionHandler(Exception.class) 
		public String handleException() {
			return "Exception Handled";
			
		}

}
