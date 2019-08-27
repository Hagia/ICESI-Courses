package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestUrgencyDAO {

	@Autowired
	private IUrgencyDAO urgencyDAO;

	@Autowired
	private IPatientDAO patientDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testMerge() {
		assertNotNull(urgencyDAO);
		assertNotNull(patientDAO);

		Urgency urgency = urgencyDAO.get(Long.parseLong("5"));
		
		assertNotNull("Code not found", urgency);

		urgency.setPatient(patientDAO.get(Long.parseLong("2")));

		urgencyDAO.update(urgency);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRemove() {
		assertNotNull(urgencyDAO);
		assertNotNull(patientDAO);

		Urgency urgency = urgencyDAO.get(Long.parseLong("8"));

		assertNotNull("Code not found", urgency);

		urgencyDAO.delete(urgency);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDateRange() {
		long hour = 3600000*24;
		Date start = new Date(System.currentTimeMillis() - hour);
		Date end = new Date(System.currentTimeMillis());

		List<Urgency> urgencies = urgencyDAO.findByDateRange(start, end);

		assertEquals(10, urgencies.size());

	}

}
