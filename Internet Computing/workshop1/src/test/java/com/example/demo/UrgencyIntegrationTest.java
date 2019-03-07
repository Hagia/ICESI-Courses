package com.example.demo;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.demo.model.Pacient;
import com.example.demo.model.Urgency;
import com.example.demo.repository.UrgencyRepository;
import com.example.demo.services.UrgencyService;
@RunWith(JUnit4.class)
public class UrgencyIntegrationTest {
	private UrgencyService urgencyService;
	
	private UrgencyRepository urgencyRepository;
	
	private Urgency urgency;
	private Pacient pacient;
	@Before
	public void initial() {
		
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		urgency=new Urgency("123456", new Date(), pacient, "A las 3am sale el ayuwaki", "Precion", false, "N/D", "Guapo");
		urgencyService=new UrgencyService(urgencyRepository);
	}
	
	@Test
	public void create() {
		Urgency f=urgencyRepository.Create(urgency);
		assertNotNull(f);
	}
	@Test
	public void delete() {
		Urgency f=urgencyRepository.Delete(urgency);
		assertNotNull(f);
	}
	@Test
	public void find() {
		Urgency f=urgencyRepository.Find(urgency);
		assertNotNull(f);
	}
	
	@Test
	public void createNull() {
		Urgency f=urgencyRepository.Create(urgency);
		assertNull(f);
	}
	@Test
	public void deleteNull() {
		Urgency f=urgencyRepository.Delete(urgency);
		assertNull(f);
	}
	@Test
	public void findNull() {
		Urgency f=urgencyRepository.Find(urgency);
		assertNull(f);
	}
}
