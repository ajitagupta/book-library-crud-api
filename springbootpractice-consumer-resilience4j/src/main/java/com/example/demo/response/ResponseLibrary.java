package com.example.demo.response;

public class ResponseLibrary {
	
	String id;
	String name;
	String address;
	Integer numBooks;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getNumBooks() {
		return numBooks;
	}
	public void setNumBooks(Integer numBooks) {
		this.numBooks = numBooks;
	}
	public ResponseLibrary(String id, String name, String address, Integer numBooks) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.numBooks = numBooks;
	}

	
	
	
	

}
