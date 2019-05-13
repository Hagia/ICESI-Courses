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

	private Patient p1;

	private Patient p2;

	@Before
	public void init() {

		if (p1 == null || p2 == null) {
			p1 = new Patient();
			p2 = new Patient();
			
			p1.setName("Mauricio");
			p1.setIdentification("1234");
			p1.setProgram("SIS");
			p1.setLastName("Hernández");
			p1.setStatus(Boolean.TRUE);

			p2.setName("Mauricio");
			p2.setIdentification("12364");
			p2.setProgram("SIS");
			p2.setLastName("Hernández");
			p2.setStatus(Boolean.TRUE);

			patientDAO.save(p1);
			patientDAO.save(p2);
		}
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testSave() {
		assertNotNull(urgencyDAO);

		Urgency urgency = new Urgency();
		urgency.setDate(new Date(System.currentTimeMillis()));
		urgency.setPatient(patientDAO.get(Long.parseLong("1")));
		urgency.setDescription("ND");
		urgency.setProcedure("ND");
		urgency.setDispatch(Boolean.TRUE);
		urgency.setObservation("ND");

		urgencyDAO.save(urgency);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testMerge() {
		assertNotNull(urgencyDAO);
		assertNotNull(patientDAO);

		Urgency urgency = urgencyDAO.get(Long.parseLong("1"));
		
		assertNotNull("Code not found", urgency);

		urgency.setPatient(patientDAO.get(Long.parseLong("2")));

		urgencyDAO.update(urgency);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testRemove() {
		assertNotNull(urgencyDAO);
		assertNotNull(patientDAO);

		Urgency urgency = urgencyDAO.get(Long.parseLong("1"));

		assertNotNull("Code not found", urgency);

		urgencyDAO.delete(urgency);
	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void testDateRange() {
		long hour = 3600000;
		Date start = new Date(System.currentTimeMillis() - hour);
		Date end = new Date(System.currentTimeMillis());

		List<Urgency> urgencies = urgencyDAO.findByDateRange(start, end);

		assertEquals(1, urgencies.size());

	}

}
