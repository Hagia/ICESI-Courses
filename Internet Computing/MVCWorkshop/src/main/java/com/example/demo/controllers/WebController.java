package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.model.BookList;
import com.example.demo.services.BookServiceImp;

@Controller
@RequestMapping("/")
public class WebController {
	
	@Autowired	
	private BookServiceImp bookService;
	
	@GetMapping("")
	public String showTemplate() {
		return "Template";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		BookList bookList = new BookList();
		bookList.addBook(new Book("id", "id", "id"));
		model.addAttribute("books", bookList);
		return "ListForm";
	}
	
	@GetMapping("/create")
	public String create() {
		return "CreateForm";
	}
	
	@GetMapping("/edit")
	public String edit() {
		return "EditForm";
	}

}
