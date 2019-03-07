package com.example.demo.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BookServiceImp implements BookService{
	
	private HashMap<String, Book> books;
	
	public BookServiceImp() {
		// TODO Auto-generated constructor stub
		books = new HashMap<>();
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>(this.books.values());
		return list;
	}

	@Override
	public void saveAll(List<Book> books) {
		// TODO Auto-generated method stub
		for (Book book : books) {
			this.books.put(book.getTitle(), book);
			log.info(book.getAuthor());
		}
	}

}
