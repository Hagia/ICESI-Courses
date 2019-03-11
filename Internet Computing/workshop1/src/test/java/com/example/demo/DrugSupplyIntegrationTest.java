package com.example.demo;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.*;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.services.*;

@RunWith(MockitoJUnitRunner.class)
public class DrugSupplyIntegrationTest {

	private DrugSupplyService supplyService;
	
	@Mock
	private DrugService drugService;
	@Mock
	private PacientService pacientsService;
	@Mock
	private DrugInventaryService inventaryService;

	@Autowired
	private DrugSupplyRepository suppliesRepository;

	private Drug drug;
	private DrugInventary drugInventary;
	private Pacient pacient;
	private DrugSupply supply;

	@Before
	public void Inicialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
	
		drugInventary = new DrugInventary(drug, 10, "El bano", Calendar.getInstance().getTime());

		supplyService = new DrugSupplyService(suppliesRepository, inventaryService, pacientsService, drugService);

		Mockito.when(inventaryService.find(drug)).thenReturn(drugInventary);
		Mockito.when(pacientsService.find(pacient)).thenReturn(pacient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
	}

	@Test
	public void createDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = suppliesRepository.find(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void createNullDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply ds = new DrugSupply();
			ds.setDrug(drug);
			DrugSupply s = suppliesRepository.create(ds);
			assertNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = suppliesRepository.delete(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = suppliesRepository.delete(supply);
			assertNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = suppliesRepository.find(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = suppliesRepository.find(supply);
			assertNull(s);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}

}
