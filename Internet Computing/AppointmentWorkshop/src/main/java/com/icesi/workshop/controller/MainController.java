package com.icesi.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/")
public class MainController {
	
	@GetMapping("/users")
	public RedirectView users() {
		return new RedirectView("user/list");
	}
	
	@GetMapping("/appointments")
	public RedirectView appointments() {
		return new RedirectView("appointment/list");
	}
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
}
