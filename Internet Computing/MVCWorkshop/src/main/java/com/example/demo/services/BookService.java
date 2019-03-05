package com.example.demo.services;
import java.util.List;

import com.example.demo.model.*;

public interface BookService {
	
	public List<Book> findAll();
	
	public void saveAll(List<Book> books);

}
