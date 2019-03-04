package com.example.demo.test;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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

@RunWith(MockitoJUnitRunner.class)
public class DrugSupplyUnitTest {
	
	private DrugSupplyService supplyService;

	@Mock
	private DrugSupplyRepository supplyRepository;

	private Drug drug;
	private DrugInventary drugInventary;
	private Pacient pacient;
	private DrugSupply supply;

	@Before
	public void Inicialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventary = new DrugInventary(drug, 10, "El bano", "24/abril/2018");
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		supplyService = new DrugSupplyService(supplyRepository);
	}

	@Test
	public void createDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);
		DrugSupply s = supplyService.create(supply);
		assertNotNull(s);
	}
	
	@Test
	public void createNullDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(null);
		DrugSupply s = supplyService.create(supply);
		assertNull(s);
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(supply);
		DrugSupply s = supplyService.delete(supply);
		assertNotNull(s);
	}
	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(null);
		DrugSupply s = supplyService.delete(supply);
		assertNull(s);
	}
	@Test
	public void findStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(supply);
		DrugSupply s = supplyService.find(supply);
		assertNotNull(s);
	}
	@Test
	public void findUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(null);

		DrugSupply s = supplyService.find(supply);
		assertNull(s);
	}
}
