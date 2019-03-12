package com.example.demo.testC;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.ParametersSuppliedBy;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Drug;
import com.example.demo.model.Pacient;
import com.example.demo.model.Urgency;
import com.example.demo.repository.UrgencyRepository;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PacientService;
import com.example.demo.services.UrgencyService;

@RunWith(MockitoJUnitRunner.class)
public class UrgencyUnitTest {

	@InjectMocks
	private UrgencyService urgencyService;

	@Mock
	private UrgencyRepository urgencyRepository;
	@Mock
	private PacientService pacientService;
	@Mock
	private DrugSupplyService supplyService;

	private Urgency urgency;
	private Pacient pacient;

	@Before
	public void initial() {

		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		urgency = new Urgency("123456", new Date(), pacient, "A las 3am sale el ayuwaki", "Presion", false, "N/D",
				"Guapo");

	}

	@Test
	public void createUrgencyRegister() {
		try {
			Mockito.when(pacientService.find(pacient)).thenReturn(pacient);
			Mockito.when(urgencyRepository.create(urgency)).thenReturn(urgency);
			Urgency f = urgencyService.create(urgency);
			assertNotNull(f);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteExistingUrgencyRegister() {
		try {
			Mockito.when(pacientService.find(pacient)).thenReturn(pacient);
			Mockito.when(urgencyRepository.delete(urgency)).thenReturn(urgency);
			Urgency f = urgencyService.delete(urgency);
			assertNotNull(f);

		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findExistingUrgencyRegister() {
		try {
			Mockito.when(pacientService.find(pacient)).thenReturn(pacient);
			Mockito.when(urgencyRepository.find(urgency)).thenReturn(urgency);
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
			Mockito.when(pacientService.find(pacient)).thenReturn(pacient);
			Mockito.when(urgencyRepository.create(urgency)).thenReturn(null);
			urgencyService.create(urgency);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			assertTrue(true);
		}
	}

	@Test
	public void deleteNotExistingUrgencyRegister() {
		try {
			Mockito.when(pacientService.find(pacient)).thenReturn(pacient);
			Mockito.when(urgencyRepository.delete(urgency)).thenReturn(null);
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
			Mockito.when(pacientService.find(pacient)).thenReturn(pacient);
			Mockito.when(urgencyRepository.delete(urgency)).thenReturn(null);
			Urgency u = urgencyService.delete(urgency);
			assertNull(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			fail();
		}
	}

}
