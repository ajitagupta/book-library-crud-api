package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.response.Response;

@RestController /* This annotation is responsible to make out class ready to receive api calls
				*
				* Behind the scenes creation of handler mapping beans to handle the apis according to http
				* 
				*/
public class HomeController {
	
	List<Response> list = new ArrayList<>();

	// Url mapping is the combination of an http method + url name

	@GetMapping("/hello") // http get method using GetMapping
	public String hello() {
		return "hello";
	}

	@GetMapping("/h2")	// another http get method
	public String hello2() {
		return "hello 2";
	}
	
	@GetMapping(value = "/h3") // another http get method, produces = MediaType.APPLICATION_XML_VALUE
	public ResponseEntity<Response> hello3(){
	Response response = new Response("1", "name", "address", 1234567);
	return new ResponseEntity<Response>(response, HttpStatus.ACCEPTED); //202
																		// ResponseEntity used if special error code should be shown, or additional headers
	}
	
	@PostMapping("/h3")
	public ResponseEntity<Response> create(@RequestBody Response response) { // @RequestBody is responsible to receive
		list.add(response);													// 'body' data from UI, and convert that data to a Java class
		return new ResponseEntity<Response>(response, HttpStatus.CREATED);  //HTTP-Response Code 201
		
	}
	
	@PutMapping("/h3")	// Put-Method
	public ResponseEntity<Response> update(@RequestBody Response response) { 
		int toUpdate = Integer.valueOf(response.getId());
		list.add(toUpdate, response);
		return new ResponseEntity<Response>(response, HttpStatus.OK); //200
		
	}
	
	@DeleteMapping("/h3/{id}") // Delete-Method
	public ResponseEntity<String> delete(@PathVariable String id) { 
		System.out.print(id);
		list.remove(id);
		return new ResponseEntity<String>(id, HttpStatus.GONE);	
	}
	
	@GetMapping("/")		// Example of MVC application. Default is JSON. To overwrite the default we use ModelAndView.
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("home.html");
		return mv;
		
	}
	

}
