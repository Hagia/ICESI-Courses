package com.example.demo;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.DependsOn;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.example.demo.model.User;
import com.example.demo.model.UserList;
import com.example.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
	
	@Autowired
	private UserRepository ur;

	@GetMapping("/add")
	public ModelAndView add() {		
		ArrayList<User> i = new ArrayList<>();
		i.add(new User());
		UserList ul = new UserList();
		ul.setList(i);
		return new ModelAndView("add", "users", ul);
	}

	@GetMapping("/edit")
	public ModelAndView edit() {
		return new ModelAndView();
	}

	@GetMapping("/delete")
	public ModelAndView delete() {
		return new ModelAndView();
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
	public RedirectView save(@ModelAttribute UserList users) {
		List<User> l = users.getList();
		for (User user2 : l) {
			ur.save(user2);
		}
		return new RedirectView("/list");
	}

}
