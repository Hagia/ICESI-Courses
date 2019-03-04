package com.example.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Pacient;
import com.example.demo.model.Urgency;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.repository.UrgencyRepository;
import com.example.demo.services.DrugInventaryService;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PacientService;
import com.example.demo.services.UrgencyService;

@RunWith(MockitoJUnitRunner.class)
public class DrugSupplyTestMock {
	@InjectMocks
	private DrugSupplyService supplyService;
	
	@Mock
	private DrugSupplyRepository supplyRepository;
	@Mock
	private DrugInventaryService drugService;
	@Mock
	private DrugService inventaryService;
	@Mock
	private PacientService pacientService;
	
	private Drug drug;
	private DrugInventary drugInventary;
	private Pacient pacient;
	private DrugSupply supply;
	
	@Before
	public void Inicialitation() {
		drug=new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventary=new DrugInventary(drug, 10, "El bano", "24/abril/2018");
		pacient=new Pacient("1113681367", "Santiago", "Gutierrez",false);
		supply=new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		supplyService =new DrugSupplyService();
	}
	
	@Test
	public void CreateUrgency() {
		when(supplyRepository.create(supply)).thenReturn(supply);
		DrugSupply s = supplyService.create(supply);
		assertNotNull(s);		
	}

	public void Delete(Urgency drug) {
		supplyService.delete(supply);
	}

	public void Find(Urgency drug) {
		supplyService.Find(supply);
	}
}
