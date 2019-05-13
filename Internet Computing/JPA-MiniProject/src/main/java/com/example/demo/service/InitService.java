package com.example.demo.service;

import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDrugDAO;
import com.example.demo.dao.IDrugSupplyDAO;
import com.example.demo.dao.IPatientDAO;
import com.example.demo.dao.IUrgencyDAO;
import com.example.demo.model.Drug;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;

import lombok.extern.log4j.Log4j2;

/**
 * @author hagia
 *Prepare tables for testing
 */
@Service
@Log4j2
public class InitService {
	
	@Autowired
	private IPatientDAO patientDAO;
	
	@Autowired
	private IDrugDAO drugDAO;
	
	@Autowired
	private IUrgencyDAO urgencyDAO;
	
	@Autowired
	private IDrugSupplyDAO supplyDAO;
	
	/**
	 * Inserts 3 patient into the Patient table
	 */
	@PostConstruct
	@Transactional
	public void fillPatientTable() {
		Patient p1 = new Patient("123", "Mauricio", "Hernandez", Boolean.FALSE);
		Patient p2 = new Patient("456", "Miguel", "Sánchez", Boolean.TRUE);
		Patient p3 = new Patient("789", "Alejandro", "Muñoz", Boolean.FALSE);
		Patient p4 = new Patient("321", "Mauricio", "Hernandez", Boolean.FALSE);
		
		patientDAO.save(p1);
		patientDAO.save(p2);
		patientDAO.save(p3);
		patientDAO.save(p4);
	}
	
	/**
	 * Inserts 10 urgencies into the Urgency table
	 */
	@PostConstruct
	@Transactional
	public void fillUrgencyTable() {
		
		
		Patient p1 = patientDAO.get(Long.parseLong("1"));
		Patient p2 = patientDAO.get(Long.parseLong("2"));
		Patient p3 = patientDAO.get(Long.parseLong("3"));
		
		Urgency u1 = new Urgency(new Date(System.currentTimeMillis()), p1, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u2 = new Urgency(new Date(System.currentTimeMillis()), p1, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u3 = new Urgency(new Date(System.currentTimeMillis()), p1, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u4 = new Urgency(new Date(System.currentTimeMillis()), p1, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u5 = new Urgency(new Date(System.currentTimeMillis()), p2, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u6 = new Urgency(new Date(System.currentTimeMillis()), p2, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u7 = new Urgency(new Date(System.currentTimeMillis()), p3, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u8 = new Urgency(new Date(System.currentTimeMillis()), p3, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u9 = new Urgency(new Date(System.currentTimeMillis()), p3, "nd", "nd", Boolean.TRUE, "nd");
		Urgency u10 = new Urgency(new Date(System.currentTimeMillis()), p3, "nd", "nd", Boolean.TRUE, "nd");
		
		urgencyDAO.save(u1);
		urgencyDAO.save(u2);
		urgencyDAO.save(u3);
		urgencyDAO.save(u4);
		urgencyDAO.save(u5);
		urgencyDAO.save(u6);
		urgencyDAO.save(u7);
		urgencyDAO.save(u8);
		urgencyDAO.save(u9);
		urgencyDAO.save(u10);
		
		
	}
	
	/**
	 * Inserts 10 drugs into the Drug table
	 */
	@PostConstruct
	@Transactional
	public void fillDrugTable() {
		
		for(int i = 0; i < 10; i ++) {
			Drug d = new Drug(i+"", i+"", i+"", i+"", i+"");
			drugDAO.save(d);
		}
		
	}

}
