package com.example.demo.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Book;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BookServiceImp implements BookService {

	private int consecutive;

	private HashMap<String, Book> books;

	public BookServiceImp() {
		// TODO Auto-generated constructor stub
		books = new HashMap<>();
		consecutive = 1;
	}

	@Override
	public List<Book> findAll() {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<Book>(this.books.values());
		return list;
	}
	
	@Override
	public List<Book> findAll(String author) {
		// TODO Auto-generated method stub
		List<Book> list = new ArrayList<>(this.books.values());
		Iterator<String> iter = this.books.keySet().iterator();
		while(iter.hasNext()) {
			Book book = this.books.get(iter.next());
			if(book.getAuthor().equals(author)) {
				list.add(book);
			}
		}
		return list;
	}

	@Override
	public void saveAll(List<Book> books) {
		// TODO Auto-generated method stub
		for (Book book : books) {
			if (book.getId()==null) {
				book.setId(consecutive + "");
				boolean b = !book.getAuthor().equals("") || !book.getTitle().equals("");
				if(b) {
					this.books.put(book.getId(), book);
				}
				consecutive += 1;;
			}

			else if (book.getAuthor().equals("") && book.getTitle().equals("")) {
				this.books.remove(book.getId());

			} else {
				this.books.put(book.getId(), book);
				consecutive = Integer.parseInt(book.getId())+1;
			}
		}
	}

}
