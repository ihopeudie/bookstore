package com.example.bookstore.controller;

import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping("/{id}")
	public Book getBookById(@PathVariable("id") Integer id) {
		return bookRepository.findById(id).orElse(new Book());
	}

	@GetMapping("list")
	public List<Book> getAllBooks() {
		return (List<Book>) bookRepository.findAll();
	}

	@PostMapping("create")
	public String createBook(@RequestParam String title) {
		bookRepository.save(new Book(title));
		return bookRepository.findByName(title) + " is saved";
	}


}
