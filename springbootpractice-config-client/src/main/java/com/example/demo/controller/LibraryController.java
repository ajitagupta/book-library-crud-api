package com.example.demo.controller;

//server -- is the one provides service
//consumer -- is the one consumes api 
//server or consumer are same only


//produces -- is the one produces api
//client -- is the one calls the api
//client or producer are same only


//pairing
//client- server
//producer -consumer

//client - consumer
//producer - server


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.model.Library;
import com.example.demo.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@GetMapping("/{id}")
	public Library getLibraryById(@PathVariable String id)	{
		return libraryService.findLibraryById(id);
	}
	
	@GetMapping("/{id}/book/{bookname}")
	public Book getBookByName(@PathVariable String id, @PathVariable String bookname)	{
		return libraryService.findBookByName(id, bookname);
	}
	
	@PostMapping
	public String createLibrary(@RequestBody Library library) {
		libraryService.save(library);
		return "library saved";
	}
	
	@PutMapping
	public String update(@RequestBody Library response) {
		String toUpdate = response.getId();
		Library library = libraryService.findLibraryById(toUpdate);
		library.setName(response.getName());
		library.setAddress(response.getAddress());
		library.setBooks(response.getBooks());
		library.setNumBooks(response.getNumBooks());
		libraryService.save(library);
		return "library updated";
		
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable String id) {
		Library library = libraryService.findLibraryById(id);
		libraryService.remove(library);
		return "library deleted";
	}
		
	
}
