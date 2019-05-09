package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
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

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Rollback(false)
@Log4j2
public class TestPatientDAO {

	@Autowired
	private IPatientDAO patientDAO;
	
	@Autowired
	private IUrgencyDAO urgencyDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testASave() {

		assertNotNull(patientDAO);

		Patient patient1 = new Patient();

		patient1.setName("Mauricio");
		patient1.setIdentification("1234");
		patient1.setProgram("SIS");
		patient1.setLastName("Hernández");
		patient1.setStatus(Boolean.TRUE);

		Patient patient2 = new Patient();
		
		patient2.setName("Mauricio");
		patient2.setIdentification("12364");
		patient2.setProgram("SIS");
		patient2.setLastName("Hernández");
		patient2.setStatus(Boolean.TRUE);
		
		patientDAO.save(patient2);
		patientDAO.save(patient1);
	}

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testBMerge() {

		assertNotNull(patientDAO);

		Patient patient = patientDAO.get(Long.parseLong("1"));

		assertNotNull("Code not found", patient);

		patient.setName("Miguel");

		patientDAO.update(patient);
	}

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDFindAllByName() {
		List<Patient> all = patientDAO.findAllByName("Mauricio");
		
		assertEquals(2, all.size());
		
	}

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testEFindAllByLastname() {
		List<Patient> all = patientDAO.findAllByLastname("Hernández");
		assertEquals(2, all.size());
	}

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testFFindAllByNameSorted() {
		List<Patient> all = patientDAO.findAllByName("Mauricio", "id");
		assertEquals(2, all.size());
		
		assertEquals(1, all.get(0).getId().intValue());
		assertEquals(2, all.get(1).getId().intValue());
		
	}

	@Test
	@Transactional(readOnly=false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testGRemove() {
	
		assertNotNull(patientDAO);
	
		Patient patient = patientDAO.get(Long.parseLong("1"));
	
		assertNotNull("Code not found", patient);
	
		patientDAO.delete(patient);
	}
}
