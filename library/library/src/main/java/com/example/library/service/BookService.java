package com.example.library.service;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

import com.example.library.Entity.Book;
import com.example.library.Repository.BookRepository;

@Service
public class BookService{

	private final BookRepository bookrepository;
	
	public BookService(BookRepository bookrepository) {
        this.bookrepository = bookrepository;
    }
	
	
	public Book savebook(Book book) {
		return bookrepository.save(book);
	}

	public List<Book> findAll(){
		return bookrepository.findAll();
	}

	public Book findById(Long Id) {
		return bookrepository.findById(Id).orElse(null);
	}
	
	public void seedData() {
        List<Book> initialBooks = Arrays.asList(
                new Book("The Great Gatsby", "F. Scott Fitzgerald", "1925-04-10", "Classic"),
                new Book("To Kill a Mockingbird", "Harper Lee", "1960-07-11", "Fiction"),
                new Book("The Catcher in the Rye", "J.D. Salinger", "1951-07-16", "Coming-of-age"),
                new Book("1984", "George Orwell", "1949-06-08", "Dystopian")
        );
        bookrepository.saveAll(initialBooks);
    }
}
