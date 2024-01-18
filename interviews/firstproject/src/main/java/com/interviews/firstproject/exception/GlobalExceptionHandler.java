package com.interviews.firstproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice	//mandatory: listen for exceptions from every class in the project
public class GlobalExceptionHandler {	// when exception occurs Springboot redirects to here
	
	@ExceptionHandler(ProductException.class)	//mandatory: we are saying this handler is written for ProductException
												// for each exception separate handler required
	public ResponseEntity<ErrorResponse> exception(ProductException ex){
		
	return new ResponseEntity<ErrorResponse>(new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BrandException.class)
	public ResponseEntity<ErrorResponse> exception(BrandException ex){
	
	return new ResponseEntity<ErrorResponse>(new ErrorResponse(101, ex.getMessage()), HttpStatus.ALREADY_REPORTED);
	}
}
