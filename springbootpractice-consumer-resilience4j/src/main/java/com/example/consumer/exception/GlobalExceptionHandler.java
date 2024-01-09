package com.example.consumer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(LibraryException.class)
	public ResponseEntity<ErrorResponse> libraryException(LibraryException exception){		
		return new ResponseEntity<ErrorResponse>(new ErrorResponse(exception.getMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);		
	}

}
