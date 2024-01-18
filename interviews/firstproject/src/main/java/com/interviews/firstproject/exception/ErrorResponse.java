package com.interviews.firstproject.exception;

public class ErrorResponse {
	
	int code;
	String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorResponse(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	

}
