package com.example.bookstore.domain;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name="author_id", nullable = false)
	private Author author;

	public Book() {
	}

	public Book(String title, Author author) {
		this.title = title;
		this.author = author;
	}

	public Book(String title) {
		this.title = title;
	}

	public Book(int id, String title) {
		this.id = id;
		this.title = title;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", title='" + title + '\'' +
				'}';
	}
}
