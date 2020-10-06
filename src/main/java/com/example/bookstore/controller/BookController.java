package com.example.bookstore.controller;

import com.example.bookstore.domain.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

	@GetMapping("/book")
	public Book getBookById(@RequestParam(value = "id") long id) {
		return new Book();
	}

	@GetMapping("/book/list")
	public List<Book> getAllBooks() {
		List<Book> books = new ArrayList<>();
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		books.add(new Book());
		return books;
	}

}
