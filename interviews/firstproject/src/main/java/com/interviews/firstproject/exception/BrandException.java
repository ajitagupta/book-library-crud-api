package com.interviews.firstproject.exception;

public class BrandException extends RuntimeException{

	private String message;

	public BrandException(String message) {
        super(message);
		this.message = message;
	}

}
