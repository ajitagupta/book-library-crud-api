package com.example.consumer.exception;

public class LibraryException extends RuntimeException {
	
	private String message;

	public LibraryException(String message) {

		this.message = message;
	}
	

}
