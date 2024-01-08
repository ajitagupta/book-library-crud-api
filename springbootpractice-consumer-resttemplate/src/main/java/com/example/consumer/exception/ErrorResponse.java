package com.example.consumer.exception;

public class ErrorResponse {
	
	String message;
	int code;
	public ErrorResponse(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}
	
	

}
