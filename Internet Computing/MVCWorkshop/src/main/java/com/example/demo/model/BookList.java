package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BookList {
	
	private List<Book> bookList;
	
	public BookList() {
		this.bookList = new ArrayList<>();
	}

	public void addBook(Book book) {
		bookList.add(book);
	}

}
