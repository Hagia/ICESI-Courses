package com.example.demo.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

@Service
public class BookServiceImp implements BookService{
	
	private HashMap<String, Book> books;

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveAll(List<Book> books) {
		// TODO Auto-generated method stub
		
	}

}
