package com.icesi.workshop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.icesi.workshop.model.*;
import com.icesi.workshop.database.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


import lombok.RequiredArgsConstructor;


@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class UserController {
	
	@Autowired
	private UserRepository ur;

	@GetMapping("/add")
	public ModelAndView add() {		
		User u =  new User();
		return new ModelAndView("user/add", "user", u);
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable String id) {
		User u =  ur.findById(Integer.parseInt(id)).get();
		return new ModelAndView("user/edit", "user", u);
	}

	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable String id) {
		ur.deleteById(Integer.parseInt(id));
		return new RedirectView("/list");
	}

	@GetMapping("/list")
	public ModelAndView list() {
		
		List<User> list = new ArrayList<>();
		Iterator<User> iter = ur.findAll().iterator();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		return new ModelAndView("list.html", "users", list);
	}
	
	@PostMapping("/save")
	public RedirectView save(@ModelAttribute User user) {
		ur.save(user);
		return new RedirectView("/list");
	}

}
