package com.icesi.workshop.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.icesi.workshop.database.AppointmentRepository;
import com.icesi.workshop.database.UserRepository;
import com.icesi.workshop.model.Appointment;
import com.icesi.workshop.model.User;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	private static final String ROOT = "appointment";

	@Autowired
	private AppointmentRepository ar;

	@Autowired
	private UserRepository ur;

	private boolean possible;

	public AppointmentController() {
		this.possible = true;
	}

	@GetMapping("/add")
	public ModelAndView add() {
		Iterable<User> doctors = ur.findByType("Doctor");
		Iterable<User> patients = ur.findByType("Patient");
		Appointment appointment = new Appointment();
		ModelAndView mav = new ModelAndView();

		if (!doctors.iterator().hasNext() || !patients.iterator().hasNext()) {
			possible = false;
			return list();
		}

		else {
			possible = true;
			mav.addObject("doctors", doctors);
			mav.addObject("patients", patients);
			mav.addObject("appointment", appointment);
			mav.setViewName(ROOT + "/add");
			return mav;
		}

	}

	@GetMapping("/list")
	public ModelAndView list() {
		List<Appointment> list = new ArrayList<>();
		Iterator<Appointment> iter = ar.findAll().iterator();
		while (iter.hasNext()) {
			list.add(iter.next());
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("isPossible", possible);
		mav.addObject("appointments", list);
		mav.setViewName(ROOT + "/list");
		return mav;

	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable String id) {
		Appointment a = ar.findById(Integer.parseInt(id)).get();
		ar.delete(a);
		Iterable<User> doctors = ur.findByType("Doctor");
		Iterable<User> patients = ur.findByType("Patient");
		ModelAndView mav = new ModelAndView();
		mav.addObject("doctors", doctors);
		mav.addObject("patients", patients);
		mav.addObject("appointment", a);
		mav.setViewName(ROOT + "/edit");
		return mav;

	}

	@GetMapping("/delete/{id}")
	public RedirectView delete(@PathVariable String id) {
		Appointment a = ar.findById(Integer.parseInt(id)).get();
		ar.delete(a);
		return new RedirectView("http://localhost:8080/appointment/list");

	}

	@PostMapping("/save")
	public RedirectView save(@ModelAttribute Appointment appointment) {
		ar.save(appointment);
		return new RedirectView("http://localhost:8080/appointment/list");
	}

//	
}
