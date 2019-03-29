package com.icesi.workshop;

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

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping("/appointment")
public class AppointmentController {

	private static final String ROOT = "appointment";

	@Autowired
	private AppointmentRepository ar;
	
	@Autowired
	private UserRepository ur;
	

	@GetMapping("/add")
	public ModelAndView add() {
		Iterable<User> doctors = ur.findByType("Doctor");
		Iterable<User> patients = ur.findByType("Patient");
		Appointment appointment = new Appointment();
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("doctors", doctors);
		mav.addObject("patients", patients);
		mav.addObject("appointment", appointment);
		mav.setViewName(ROOT + "/add");
	
		return mav; 
	}

	@GetMapping("/list")
	public ModelAndView list() {
		List<Appointment> list = new ArrayList<>();
		Iterator<Appointment> iter = ar.findAll().iterator();
		while (iter.hasNext()) {
			list.add(iter.next());
		}
		return new ModelAndView(ROOT + "/list", "appointments", list);

	}

	@GetMapping("/edit{id}")
	public ModelAndView edit(@PathVariable String id) {
		Appointment a = ar.findById(Integer.parseInt(id)).get();
		return new ModelAndView(ROOT + "/edit", "appointment", a);

	}

	@PostMapping("/save")
	public RedirectView save(@ModelAttribute Appointment appointment) {
		System.out.println(appointment.getPatient().getName());
		System.out.println(appointment.getDoctor().getName());
		ar.save(appointment);
		return new RedirectView("http://localhost:8080/appointment/list");
	}

//	
}
