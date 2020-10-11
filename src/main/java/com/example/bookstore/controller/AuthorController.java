package com.example.bookstore.controller;

import com.example.bookstore.domain.Author;
import com.example.bookstore.domain.Book;
import com.example.bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/author")
public class AuthorController {
	@Autowired
	private AuthorRepository authorRepository;

	@PostMapping("create")
	public String createAuthor(@RequestParam String name) {
		try {
			Author author = new Author(name);
			authorRepository.save(author);
			return "author saved with id: "+author.getId();
		} catch (Exception e) {
			return "";
		}
	}
}
