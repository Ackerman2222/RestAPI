package com.example.library.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
    private Long id;
	
	@Column(name = "Book_Title")
	private String title;
	
	@Column(name = "Author")
    private String author;
	
	@Column(name = "Publication_Year")
	private String publicationYear;
	
	@Column(name = "Genre")
    private String genre;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Book(String title, String author, String publicationYear, String genre) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.genre = genre;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(String publicationYear) {
		this.publicationYear = publicationYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
