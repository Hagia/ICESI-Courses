package com.example.demo.controllers;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.swing.JSpinner.DateEditor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateConverter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;
import com.example.demo.model.User;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PatientService;
import com.example.demo.services.UrgencyService;
import com.example.demo.services.UserService;
import com.fasterxml.jackson.core.format.DataFormatDetector;

@Controller
@RequestMapping("/")
public class MainController {

	@Autowired
	private UserService us;

	@Autowired
	private DrugService ds;

	@Autowired
	private DrugSupplyService dss;

	@Autowired
	private UrgencyService ugs;
	
	@Autowired
	private PatientService ps;

	@PostConstruct
	private void setUp() {
		User u1 = new User("lola", "Mauricio", "Hernández", "lola", Boolean.FALSE);
		us.add(u1);
		
		Patient p = new Patient("1234", "lola", "lola", Boolean.FALSE);
		ps.create(p);
		
		Drug d = new Drug("lola", "lola", "lols", "noceh", "ND");
		ds.create(d);
		
	}

	@PostMapping("/perform_login")
	public String login(Model model, @ModelAttribute User user) {
		
//		us.loadUserByUsername(user.getLogin());
		
//		User u = us.find(user.getLogin());
//
//		boolean correctLogin = u != null && user.getPassword().equals(u.getPassword());
//		if (correctLogin) {
//			return "home";
//		}

		return "home";
	}

	@GetMapping("/home")
	public String home(Model model) {
		return "home";
	}

	@GetMapping("drugDelivery")
	public String drugDelivery(Model model) {
		
		model.addAttribute("patients", ps.findAll());
		model.addAttribute("drugs", ds.findAll());
		model.addAttribute("supply", new DrugSupply());

		return "drugDelivery";
	}

	@GetMapping("/patientService")
	public String patientService(Model model) {
		model.addAttribute("supplies", dss.findAll());
		model.addAttribute("patients", ps.findAll());
		model.addAttribute("service", new Urgency());
		return "patientService";
	}

	@GetMapping("/query")
	public String query(@RequestParam String option, @RequestParam String date, Model model) {

		Date dat = Date.valueOf(date);
		if (option.equals("supply")) {
			List<DrugSupply> list = dss.findAllByDate(dat);
			model.addAttribute("supplies", list);
			return "listSupply";
		} else if (option.equals("service")) {
			List<Urgency> list = ugs.findAllByDate(dat);
			model.addAttribute("services", list);
			return "listService";
		} else
			return "home";
	}

	@PostMapping("/saveSupply")
	public String saveSupply(Model model, @ModelAttribute DrugSupply drugSupply) {
		Calendar c = Calendar.getInstance();
		Date date = new Date(c.get(Calendar.YEAR)-1900, c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		
		drugSupply.setDate(date);
		dss.create(drugSupply);
		return "home";
	}

	@PostMapping("/saveService")
	public String saveService(Model model, @ModelAttribute Urgency service) {
		Calendar c = Calendar.getInstance();
		Date date = new Date(c.get(Calendar.YEAR)-1900, c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		
		System.out.println(service.toString());
		service.setDate(date);
		ugs.create(service);
		return "home";
	}

	
	@GetMapping("/login")
	public String login(Model model) {
//		model.addAttribute("user", new User());
		return "login";
	}
}
