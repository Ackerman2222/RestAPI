package com.example.library.Controller;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.Entity.Book;
import com.example.library.service.BookService;

@RestController
public class MyController {

	private final BookService bookservice;

	public MyController(BookService bookservice) {
		this.bookservice = bookservice;
	}
	
	@PostMapping("/api/books")
	public ResponseEntity<String> savebook(@RequestBody Book book)
	{
		bookservice.savebook(book);
		return ResponseEntity.status(HttpStatus.OK).body("Book details added successfully");
	}
	
	@GetMapping("/api/books")
	public ResponseEntity<Object> getAllBooks() {
	    List<Book> books = bookservice.findAll();
	    if (books.isEmpty()) {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No books found");
	    }
	    return ResponseEntity.status(HttpStatus.OK).body(books);
	}
	
	@PutMapping("/api/books/{id}")
	public ResponseEntity<Book> updatebookById(@PathVariable long id, @RequestBody Book updatedBook) {
		Book existingbook = bookservice.findById(id);
		if (existingbook == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
		
		existingbook.setTitle(updatedBook.getTitle());
	    existingbook.setAuthor(updatedBook.getAuthor());
	    existingbook.setPublicationYear(updatedBook.getPublicationYear());
	    existingbook.setGenre(updatedBook.getGenre());
	    
        bookservice.savebook(existingbook);
        return ResponseEntity.status(HttpStatus.OK).body(existingbook);
    }
	
	@PostMapping("/api/books/seed")
    public ResponseEntity<String> seedData() {
        bookservice.seedData();
        return ResponseEntity.status(HttpStatus.OK).body("Mock data seeded successfully");
    }
}
