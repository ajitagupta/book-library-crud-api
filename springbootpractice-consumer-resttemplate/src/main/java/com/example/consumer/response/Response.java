package com.example.consumer.response;

public class Response {
	
	String id;
	String name;
	String address;
	Integer number;
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
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Response(String id, String name, String address, Integer number) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.number = number;
	}
	
	

}
