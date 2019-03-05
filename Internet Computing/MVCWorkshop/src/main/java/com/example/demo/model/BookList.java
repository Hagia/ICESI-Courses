package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class BookList {
	
	private ArrayList<Book> bookList;
	
	
	
	public BookList() {
		this.bookList = new ArrayList<>();
	}



	public void addBook(Book book) {
		bookList.add(book);
	}

}
