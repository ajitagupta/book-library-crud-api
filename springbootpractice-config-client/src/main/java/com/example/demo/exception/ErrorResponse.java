package com.example.demo.exception;

public class ErrorResponse {
	
	String message;
	int code;
	public ErrorResponse(String message, int code) {
		super();
		this.message = message;
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	

}
