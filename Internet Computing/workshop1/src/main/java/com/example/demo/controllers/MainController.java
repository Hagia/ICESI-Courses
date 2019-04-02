package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {

	private UserService us;

	public void setUp() {

	}

	@GetMapping("/loginDo")
	public ModelAndView login(@RequestParam User user) {

		User u = us.find(user.getLogin());

		boolean correctLogin = u != null && user.getPassword().equals(u.getPassword());
		ModelAndView mav = new ModelAndView();
		if(correctLogin) {
			mav.setViewName("main");
			return mav;
		}
		
		mav.setViewName("login");
		return mav;
	}

	@GetMapping("/")
	public ModelAndView main() {
		User user = new User();

		ModelAndView mav = new ModelAndView();

		mav.addObject("user", user);
		mav.setViewName("login");
		return mav;
	}
}
