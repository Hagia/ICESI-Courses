package com.example.demo.service;

import java.sql.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IDrugDAO;
import com.example.demo.dao.IDrugInventoryDAO;
import com.example.demo.dao.IDrugSupplyDAO;
import com.example.demo.dao.IPatientDAO;
import com.example.demo.dao.IUrgencyDAO;
import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;

import lombok.extern.log4j.Log4j2;

/**
 * @author hagia Prepare tables for testing
 */
@Service
@Log4j2
public class InitService {

	@Autowired
	IPatientDAO patientDAO;

	@Autowired
	IDrugDAO drugDAO;

	@Autowired
	IUrgencyDAO urgencyDAO;

	@Autowired
	IDrugSupplyDAO supplyDAO;
	
	@Autowired
	IDrugInventoryDAO inventoryDAO;
	
	/**
	 * Inserts 4 patient into the Patient table
	 */
	@org.springframework.transaction.annotation.Transactional
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
	@org.springframework.transaction.annotation.Transactional
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
	 * Inserts 5 drugs into the Drug table
	 */
	
	@org.springframework.transaction.annotation.Transactional
	public void fillDrugTable() {
		Drug d1 = new Drug("Acetaminofen", "Acetaminofen", "Genfar", "Niños", "NA");
		Drug d2 = new Drug("Omeprazol", "Omeprazol", "Genfar", "Niños", "NA");
		Drug d3 = new Drug("Amoxicilina", "Amoxicilina", "Genfar", "Niños", "NA");
		Drug d4 = new Drug("Ambramicina", "Ambramicina", "JGB", "Niños", "NA");
		Drug d5 = new Drug("Tukol", "Tukol", "TQ", "Niños", "NA");

		drugDAO.save(d1);
		drugDAO.save(d2);
		drugDAO.save(d3);
		drugDAO.save(d4);
		drugDAO.save(d5);
	}

	@org.springframework.transaction.annotation.Transactional
	public void fillInventoryTable() {
		Drug d1 = drugDAO.find(Long.parseLong("15"));
		Drug d2 = drugDAO.find(Long.parseLong("16"));
		Drug d3 = drugDAO.find(Long.parseLong("17"));
		Drug d4 = drugDAO.find(Long.parseLong("18"));
		Drug d5 = drugDAO.find(Long.parseLong("19"));

		DrugInventory di1 = new DrugInventory(d1, 17, "Up", new Date(System.currentTimeMillis()));
		DrugInventory di2 = new DrugInventory(d2, 40, "Up", new Date(System.currentTimeMillis()));
		DrugInventory di3 = new DrugInventory(d3, 2, "Up", new Date(System.currentTimeMillis()));
		DrugInventory di4 = new DrugInventory(d4, 5, "Up", new Date(System.currentTimeMillis()));
		DrugInventory di5 = new DrugInventory(d5, 15, "Up", new Date(System.currentTimeMillis()));

		inventoryDAO.save(di1);
		inventoryDAO.save(di2);
		inventoryDAO.save(di3);
		inventoryDAO.save(di4);
		inventoryDAO.save(di5);
		
		fillSupplyTable();
		
	}
	
	@org.springframework.transaction.annotation.Transactional
	public void fillSupplyTable() {
		Drug d1 = drugDAO.find(Long.parseLong("15"));
		Drug d2 = drugDAO.find(Long.parseLong("16"));
		Drug d3 = drugDAO.find(Long.parseLong("17"));
		Drug d4 = drugDAO.find(Long.parseLong("18"));
		Drug d5 = drugDAO.find(Long.parseLong("19"));

		DrugSupply ds1 = new DrugSupply(d1, "1", 13, new Date(System.currentTimeMillis()), "NA");
		DrugSupply ds2 = new DrugSupply(d2, "2", 6, new Date(System.currentTimeMillis()), "NA");
		DrugSupply ds3 = new DrugSupply(d3, "3", 1, new Date(System.currentTimeMillis()), "NA");
		DrugSupply ds4 = new DrugSupply(d4, "4", 2, new Date(System.currentTimeMillis()), "NA");
		DrugSupply ds5 = new DrugSupply(d5, "5", 10, new Date(System.currentTimeMillis()), "NA");
		
		supplyDAO.save(ds1);
		supplyDAO.save(ds2);
		supplyDAO.save(ds3);
		supplyDAO.save(ds4);
		supplyDAO.save(ds5);
	}
	
	@PostConstruct
	public void startInit() {
		fillPatientTable();
		fillUrgencyTable();
		fillDrugTable();
		fillInventoryTable();
		fillSupplyTable();
	}

}
