package com.example.demo.testA;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.services.*;

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
	private Pacient pacient;
	private DrugSupply supply;
	private DrugInventary drugInventary;

	@Before
	public void init() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		drugInventary = new DrugInventary(drug, 10, "Here", Calendar.getInstance().getTime());
		
		Mockito.when(pacientsService.find(pacient)).thenReturn(pacient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventaryService.find(supply)).thenReturn(drugInventary);
	}

	@Test
	public void createDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);
		
		try {
			DrugSupply s = supplyService.create(supply);
			assertNotNull(s);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void createNullDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.create(supply);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(supply);
		try {
			DrugSupply s = supplyService.delete(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.delete(supply);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(supply);
		try {
			DrugSupply s = supplyService.find(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.find(supply);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}
}
