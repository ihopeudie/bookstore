package com.example.bookstore.controller;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.AuthorRepository;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	@Autowired
	private AuthorRepository authorRepository;

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookRepository.findById(id).orElse(null);
	}

	@GetMapping("list")
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@PostMapping("create")
	public String createBook(@RequestParam String title, @RequestParam Integer authorId) {
		Author author = authorRepository.findById(authorId).orElse(null);
		if (author != null) {
			bookRepository.save(new Book(title, author));
			return "book" + title + " is saved";
		}
		return "";
	}


}
