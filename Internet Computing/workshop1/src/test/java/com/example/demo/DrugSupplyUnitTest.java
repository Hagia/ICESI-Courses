package com.example.demo;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;


import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.model.*;
import com.example.demo.repository.DrugInventaryRepository;
import com.example.demo.repository.DrugRepository;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.repository.PacientRepository;
import com.example.demo.repository.UrgencyRepository;
import com.example.demo.services.DrugInventaryService;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PacientService;

@RunWith(MockitoJUnitRunner.class)
public class DrugSupplyUnitTest {

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
	private Pacient pacient;
	private DrugSupply supply;

	@Before
	public void Inizialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		drugInventary = new DrugInventary(drug, 10, "Here", Calendar.getInstance().getTime());
		
		supplyService = new DrugSupplyService(supplyRepository, inventaryService, pacientsService, drugService);
		
		Mockito.when(inventaryService.find(drug)).thenReturn(drugInventary);
		Mockito.when(pacientsService.find(pacient)).thenReturn(pacient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
	}

	@Test
	public void createDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);
		try {
			DrugSupply s = supplyService.create(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void createNullDrugSupplyRegister() {
		Mockito.when(supplyRepository.create(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.create(supply);
			assertNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(supply);
		try {
			DrugSupply s = supplyService.delete(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.delete(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.delete(supply);
			assertNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(supply);
		try {
			DrugSupply s = supplyService.find(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		Mockito.when(supplyRepository.find(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.find(supply);
			assertNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
