package com.example.demo.testC;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.WorkshopApplication;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;
import com.example.demo.repository.UrgencyRepository;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PatientService;
import com.example.demo.services.UrgencyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= WorkshopApplication.class)
public class UrgencyIntegrationTest {
	@Autowired
	private UrgencyService urgencyService;
	@Autowired
	private UrgencyRepository urgencyRepository;
	@Autowired
	private PatientService patientService;

	private Urgency urgency;
	private Patient patient;

	@Before
	public void initial() {

		patient = new Patient("1113681367", "Santiago", "Gutierrez", false);
		urgency = new Urgency("123456", new Date(), patient, "A las 3am sale el ayuwaki", "Presion", false, "N/D",
				"Guapo");

	}

	@Test
	public void createValidUrgencyRegister() {
		try {
			patientService.create(patient);
			Urgency f = urgencyService.create(urgency);
			assertNotNull(f);
		} catch (Exception e) {
			fail();
		}
	}
	
	@Test
	public void createInvalidPatientUrgencyRegister() {
		try {
			urgencyService.create(urgency);
		} catch (Exception e) {
			assertTrue(true);
		}
	}


	@Test
	public void deleteExistingUrgencyRegister() {
		try {
			patientService.create(patient);
			urgencyService.create(urgency);
			Urgency f = urgencyService.delete(urgency);
			assertNotNull(f);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findExistingUrgencyRegister() {
		try {
			patientService.create(patient);
			urgencyService.create(urgency);
			Urgency f = urgencyRepository.find(urgency);
			assertNotNull(f);
		} catch (Exception e) {
			fail();
		}
	}

	@Test()
	public void createBadlyUrgencyRegister() {
		try {
			urgencyService.create(urgency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}

	@Test
	public void deleteNotExistingUrgencyRegister() {
		try {
			urgencyService.clear();
			Urgency u = urgencyService.delete(urgency);
			assertNull(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

	@Test
	public void findNotExistingUrgencyRegister() {
		try {
			urgencyService.clear();
			Urgency u = urgencyService.delete(urgency);
			assertNull(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}
}
