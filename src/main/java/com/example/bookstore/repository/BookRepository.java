package com.example.bookstore.repository;

import com.example.bookstore.domain.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {

	@Query("SELECT title from Book b where b.title LIKE %:title%")
	public Book findByName(String title);
}
