package com.icesi.workshop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.MappedSuperclass;

import com.icesi.workshop.model.*;
import com.icesi.workshop.database.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

	private static final String ROOT = "user";

	@Autowired
	private UserRepository ur;

	@GetMapping("/add")
	public ModelAndView add() {
		User u = new User();
		return new ModelAndView(ROOT + "/add", "user", u);
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable String id) {
		User u = ur.findById(Integer.parseInt(id)).get();
		ur.deleteById(Integer.parseInt(id));

		return new ModelAndView(ROOT + "/edit", "user", u);
	}

	@GetMapping("/delete")
	public RedirectView delete(@PathVariable String id) {
		ur.deleteById(Integer.parseInt(id));
		return new RedirectView(ROOT + "/list");
	}

	@GetMapping("/list")
	public ModelAndView list() {

		List<User> list = new ArrayList<>();
		Iterator<User> iter = ur.findAll().iterator();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return new ModelAndView(ROOT + "/list", "users", list);
	}

	@PostMapping("/save")
	public RedirectView save(@ModelAttribute User user) {
		ur.save(user);
		return new RedirectView("list");
	}

}
