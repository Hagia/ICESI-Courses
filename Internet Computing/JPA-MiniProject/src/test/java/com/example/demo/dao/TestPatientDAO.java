package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.assertj.AssertableReactiveWebApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.service.InitService;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Rollback(false)
@Log4j2
public class TestPatientDAO {

	@Autowired
	private IPatientDAO patientDAO;

	/**
	 * 
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testMerge() {

		assertNotNull(patientDAO);

		Patient patient = patientDAO.get(Long.parseLong("1"));

		assertNotNull("Code not found", patient);

		patient.setName("Miguel");

		patientDAO.update(patient);
	}

	/**
	 * 
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAllByName() {
		List<Patient> all = patientDAO.findAllByName("Mauricio");

		assertEquals(2, all.size());

		all = patientDAO.findAllByName("Miguel");

		assertEquals(1, all.size());

		all = patientDAO.findAllByName("Alejandro");

		assertEquals(1, all.size());

	}

	/**
	 * 
	 */
	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAllByLastname() {
		List<Patient> all = patientDAO.findAllByLastname("Hernandez");
		assertEquals(2, all.size());
		
		all = patientDAO.findAllByLastname("Sánchez");
		assertEquals(1, all.size());

		all = patientDAO.findAllByLastname("Muñoz");
		assertEquals(1, all.size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAllByDocument() {
		assertNotNull(patientDAO);

		List<Patient> all = patientDAO.findAllByDocument("123");

		assertEquals(1, all.size());
		
		all = patientDAO.findAllByDocument("456");

		assertEquals(1, all.size());
		
		all = patientDAO.findAllByDocument("789");

		assertEquals(1, all.size());
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAllByNameSorted() {
		List<Patient> all = patientDAO.findAllByName("Mauricio", "identification");
		assertEquals(3, all.size());

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRemove() {

		assertNotNull(patientDAO);

		Patient patient = patientDAO.get(Long.parseLong("1"));

		assertNotNull("Code not found", patient);

		patientDAO.delete(patient);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFindAllTwoUrgencies() {
		assertNotNull(patientDAO);

		List<Patient> list = patientDAO.findAllTwoUrgencies();

		assertEquals(2, list.size());
	}
	
	public void testCountUrgencies() {
		assertNotNull(patientDAO);
		
		List list = patientDAO.countUrgencies();
		
		assertNotNull("Request error",list);
	}
}
