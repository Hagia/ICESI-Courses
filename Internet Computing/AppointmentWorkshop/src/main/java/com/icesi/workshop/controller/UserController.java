package com.icesi.workshop.controller;

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

@Controller
@RequestMapping("/user")
public class UserController {

	private static final String ROOT = "user";
	
	private boolean delete;

	@Autowired
	private UserRepository ur;
	
	@Autowired
	private AppointmentRepository ar;

	private boolean update;
	
	public UserController() {
		delete = true;
		update = true;
	}
	
	
	@GetMapping("/add")
	public ModelAndView add() {
		User u = new User();
		return new ModelAndView(ROOT + "/add", "user", u);
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable String id) {
		User user = ur.findById(Integer.parseInt(id)).get();
		Iterable<Appointment> list = ar.findAll();
		update = true;
		delete = true;
		for (Appointment appointment : list) {
			if(user.getId() == appointment.getDoctor().getId() || user.getId() == appointment.getPatient().getId()) {
				update = false;
			}
		}
		if(update)
			ur.delete(user);
		return new ModelAndView(ROOT + "/edit", "user", user);
		

		
	}
	
	
	public RedirectView redirect() {
		return new RedirectView("http://localhost:8080/users");
	}

	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable String id) {
		
		User user = ur.findById(Integer.parseInt(id)).get();
		Iterable<Appointment> list = ar.findAll();
		update = true;
		delete = true;
		for (Appointment appointment : list) {
			if(user.getId() == appointment.getDoctor().getId() || user.getId() == appointment.getPatient().getId()) {
				delete = false;
			}
		}
		if(delete)
			ur.deleteById(Integer.parseInt(id));
		return new RedirectView("http://localhost:8080/user/list");
	}

	@GetMapping("/list")
	public ModelAndView list() {

		List<User> list = new ArrayList<>();
		Iterator<User> iter = ur.findAll().iterator();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("delete", delete);
		mav.addObject("update", update);
		mav.addObject("users", list);
		mav.setViewName(ROOT + "/list");
		return mav;
	}

	@PostMapping("/save")
	public RedirectView save(@ModelAttribute User user) {
		if(update)
			ur.save(user);
		return new RedirectView("list");
	}

}
