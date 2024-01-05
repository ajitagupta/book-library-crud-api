package com.example.demo.exception;

public class BookException extends RuntimeException {
	
	private String message;

	public BookException(String message) {

		this.message = message;
	}
	

}
