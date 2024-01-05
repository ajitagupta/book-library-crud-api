package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.BookException;
import com.example.demo.model.Book;
import com.example.demo.repositories.BookRepository;

@Service
public class BookService {
	
	
	    @Autowired
	    BookRepository bookRepository; // null (see Reflection API's in Java)
	   

		public Book save(Book input) {
	    	return bookRepository.save(input); // NullPointerException
	    }
		
		// Read operations
		public List<Book> findAllBooks(){
			return bookRepository.findAll();
		}
		public Book findBookById(String id)	{
			Optional<Book> optBook =  bookRepository.findById(id);
			if(optBook.isPresent()) {
			return optBook.get();	
			} else {
				throw new BookException("Book with id: " + id  + " is not present");
			}
		}
		
		public List<Book> getBookByName(String name){
			return bookRepository.findByName(name);
		}
		
		public List<Book> getBookByPY(Integer year){
//			return bookRepository.findByPublishYear(year);
//			return bookRepository.getByPublishYear(year);
			return bookRepository.getByPublishYear2(year);

		}

		public void remove(String id) {
			bookRepository.deleteById(id);
		}
}



/*
//@Controller
//@Service
//@Component
//@Repository

// above all are class/interface level annotations
// at start of the application, these classes objects / beans will get created.

// Now to use those objects in our class we use @Autowired (to map the existing the object with the reference variable)
*/