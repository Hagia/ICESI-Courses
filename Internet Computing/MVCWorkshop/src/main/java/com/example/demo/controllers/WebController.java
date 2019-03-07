package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Book;
import com.example.demo.model.BookList;
import com.example.demo.services.BookServiceImp;

@Controller
@RequestMapping("/")
public class WebController {
	
	@Autowired	
	private BookServiceImp bookService;
	
	private BookList bookList;
	
	@GetMapping("")
	public String showTemplate() {
		return "Template";
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		
		BookList bookList = new BookList();
		bookList.setBookList(bookService.findAll());
		model.addAttribute("books", bookList.getBookList());
		return "ListForm";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		BookList bookList = new BookList();
		bookList.addBook(new Book());
		bookList.addBook(new Book());
		bookList.addBook(new Book());
		model.addAttribute("form", bookList);
		return "CreateForm";
	}
	
	@GetMapping("/edit")
	public String edit(Model model) {
		System.out.println(bookService ==null?"Bueno":"Malo");
		
		BookList bookList = new BookList();
		bookList.setBookList(bookService.findAll());
		model.addAttribute("books", bookList.getBookList());
		return "EditForm";
	}
	
	@PostMapping("/save")
	public String save(Model model, @ModelAttribute BookList books) {
		
		bookService.saveAll(books.getBookList());
		books.setBookList(bookService.findAll());
		model.addAttribute("books", books.getBookList());
		return "ListForm";
	}

}
