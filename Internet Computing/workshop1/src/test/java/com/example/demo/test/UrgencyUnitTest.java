package com.example.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Drug;
import com.example.demo.model.Pacient;
import com.example.demo.model.Urgency;
import com.example.demo.repository.UrgencyRepository;
import com.example.demo.services.UrgencyService;

@RunWith(MockitoJUnitRunner.class)
public class UrgencyUnitTest {
	
	private UrgencyService urgencyService;
	@Mock
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
		Mockito.when(urgencyService.Create(urgency)).thenReturn(urgency);
		Urgency f=urgencyRepository.Create(urgency);
		assertNotNull(f);
	}
	@Test
	public void delete() {
		Mockito.when(urgencyService.Delete(urgency)).thenReturn(urgency);
		Urgency f=urgencyRepository.Delete(urgency);
		assertNotNull(f);
	}
	@Test
	public void find() {
		Mockito.when(urgencyService.Find(urgency)).thenReturn(urgency);
		Urgency f=urgencyRepository.Find(urgency);
		assertNotNull(f);
	}
	
	@Test
	public void createNull() {
		Mockito.when(urgencyService.Create(urgency)).thenReturn(null);
		Urgency f=urgencyRepository.Create(urgency);
		assertNull(f);
	}
	@Test
	public void deleteNull() {
		Mockito.when(urgencyService.Delete(urgency)).thenReturn(null);
		Urgency f=urgencyRepository.Delete(urgency);
		assertNull(f);
	}
	@Test
	public void findNull() {
		Mockito.when(urgencyService.Find(urgency)).thenReturn(null);
		Urgency f=urgencyRepository.Find(urgency);
		assertNull(f);
	}

}
