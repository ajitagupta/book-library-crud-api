package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;


//The @RestController annotation specifies that the
//class is a controller and all the @RequestMapping (or
//@GetMapping in our case) annotated methods will
//return the content in the response body. If we use a
//plain @Controller annotation instead, we need to
//annotate our class (or every corresponding method)
//with @ResponseBody. Thus, @RestController is a
//shortcut annotation.

@RestController
//The @RequestMapping annotation at the class level
//is setting the root context for all the methods (in our
//case, books).
@RequestMapping("/books")
public class BookController {
	
	
	@Autowired  // this annotation helps in assigning the object created during starting of the application
				//1st Type Dependency Injection
	BookService bookService;

	//public MyController(BookService bookService) {
	//	super();
	//	this.bookService = bookService; // 2nd way by using constructor Dependency Injection
	//}

	public BookService getBookService() {
		return bookService;
	}

	//3rd type is setter Dependency Injection
	/*
	 * @Autowired public void setBookService(BookService bookService) {
	 * this.bookService = bookService; }
	 */
	
	
	/*
	 * 
	 * To design an api, take care of usage for path variable and request param
	 * Take care of http methods and inside behaviour of it.
	 */
	
	@GetMapping
	// http://localhost:8888/books?year=1999 for books in specific year or
	// http://localhost:8888/books for getting all books
	public List<Book> getAllBooks(@RequestParam(required = false) Integer year)	{
		if(year == null)
		  return bookService.findAllBooks();
		else 
		  return bookService.getBookByPY(year);	
	}

	//Another shortcut annotation is @GetMapping, and
	//it’s equivalent to using @RequestMapping(method
	//= RequestMethod.GET). So, the resulting endpoint
	//will perform a GET operation to the URL composed
	//by the class’ specified context plus the method’s
	//request mapping, which results in books/id
	@GetMapping("/{id}")
	public Book getBookById(@PathVariable String id)	{
		return bookService.findBookById(id);
	}
	
	//@PostMapping annotation does a similar
	//thing to @GetMapping, but in this case handling a POST request. And,
	//because we want to receive the attempt data as part of the body of the
	//request, we need to annotate the method argument with @RequestBody.
	@PostMapping
	public String createBook(@RequestBody Book book) {
		bookService.save(book);
		return "book saved";
	}
	
	@PutMapping("/update")
	public String updateBook(@RequestBody Book book)	{
		String id = book.getId();
		Book dbBook = bookService.findBookById(id);
		dbBook.setAuthor(book.getAuthor());
		dbBook.setPublishYear(book.getPublishYear());
	    bookService.save(dbBook);
		return "Book updated";
		
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable String id)	{
		
		bookService.remove(id);
		
		if (bookService.findBookById(id) != null) {
			bookService.remove(id);
			return "Book deleted";
		}	else	{
			return "Book invalid";
		}			
	}
}
