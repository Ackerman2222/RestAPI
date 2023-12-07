package com.example.library.service;

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
}
