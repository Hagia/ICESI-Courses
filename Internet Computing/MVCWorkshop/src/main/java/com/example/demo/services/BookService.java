package com.example.demo.services;
import java.util.List;

import com.example.demo.model.*;

public interface BookService {
	
	public List<Book> findAll();
	
	public List<Book> findAll(String author);
	
	public void saveAll(List<Book> books);

}
