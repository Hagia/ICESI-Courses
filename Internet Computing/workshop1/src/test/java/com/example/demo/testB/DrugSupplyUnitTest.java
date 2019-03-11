package com.example.demo.testB;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
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
import com.example.demo.repository.DrugInventaryRepository;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.services.DrugInventaryService;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PacientService;

@RunWith(MockitoJUnitRunner.class)
public class DrugSupplyUnitTest {
	
	@InjectMocks
	private DrugSupplyService supplyService;

	@Mock
	private DrugService drugService;
	@Mock
	private PacientService pacientsService;
	@Mock
	private DrugInventaryService inventaryService;
	@Mock
	private DrugSupplyRepository supplyRepository;

	private Drug drug;
	private DrugInventary drugInventary;
	private DrugInventary drugInventaryUpdated;
	private Pacient pacient;
	private DrugSupply supply;

	@Before
	public void Inicialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventary = new DrugInventary(drug, 10, "El bano", Calendar.getInstance().getTime());
		drugInventaryUpdated = new DrugInventary(drug, 9, "El bano", Calendar.getInstance().getTime());
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");

		Mockito.when(pacientsService.find(pacient)).thenReturn(pacient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventaryService.find(supply)).thenReturn(drugInventary);
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);
		
		
	}

	@Test
	public void createDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);
		Mockito.when(inventaryService.find(drugInventary)).thenReturn(drugInventaryUpdated);
		try {
			DrugSupply s = supplyService.create(supply);
			DrugInventary di = inventaryService.find(drugInventary); 
			assertTrue(di.getAmount()==9);
			assertNotNull(s);
		}catch(Exception e) {
			fail();
		}
	}
	
	@Test
	public void createNullDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(null);
		Mockito.when(inventaryService.find(drugInventary)).thenReturn(drugInventary);
		try {
			DrugSupply s = supplyService.create(supply);
			DrugInventary di = inventaryService.find(drugInventary);
			assertTrue(di.getAmount()==10);
			assertNull(s);
		}catch(Exception e) {
			fail();
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(supply);
		Mockito.when(inventaryService.find(drugInventary)).thenReturn(drugInventaryUpdated);
		try {
			DrugSupply s = supplyService.delete(supply);
			DrugInventary di = inventaryService.find(drugInventary);
			assertTrue(di.getAmount()== 9);
			assertNotNull(s);
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(null);
		Mockito.when(inventaryService.find(drugInventary)).thenReturn(drugInventary);
		try {
			DrugSupply s = supplyService.delete(supply);
			DrugInventary di = inventaryService.find(drugInventary);
			assertTrue(di.getAmount()== 10);
			assertNull(s);
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	public void findStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(supply);
		Mockito.when(inventaryService.find(drugInventary)).thenReturn(drugInventaryUpdated);
		try {
			DrugSupply s = supplyService.find(supply);
			DrugInventary di = inventaryService.find(drugInventary);
			assertTrue(di.getAmount()== 9);
			assertNotNull(s);
		}catch(Exception e) {
			
		}
	}
	@Test
	public void findUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(null);
		Mockito.when(inventaryService.find(drugInventary)).thenReturn(drugInventary);
		try {
			DrugSupply s = supplyService.find(supply);
			DrugInventary di = inventaryService.find(drugInventary);
			assertTrue(di.getAmount()== 10);
			assertNull(s);
		}catch(Exception e) {
			
		}
	}
}
