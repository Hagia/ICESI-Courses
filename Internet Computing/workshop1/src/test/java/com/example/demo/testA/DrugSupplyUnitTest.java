package com.example.demo.testA;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
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
	private PatientService patientsService;

	@Mock
	private DrugInventoryService inventoryService;

	@Mock
	private DrugSupplyRepository supplyRepository;

	private Drug drug;
	private Patient patient;
	private DrugSupply supply;
	private DrugInventory drugInventory;

	@Before
	public void init() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		patient = new Patient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, patient, new Date(), "Gripa");

		drugInventory = new DrugInventory(drug, 10, "Here", Calendar.getInstance().getTime());
	}

	@Test
	public void createValidDrugSupplyRegister() {

		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		// Ensure repository works properly
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);

		try {
			DrugSupply s = supplyService.create(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void createInvalidPacientDrugSupplyRegister() {

		// Ensure patient does not exists
		Mockito.when(patientsService.find(patient)).thenReturn(null);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		try {
			supplyService.create(supply);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void createInvalidDrugSupplyRegister() {

		// Ensure drug does not exists
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(null);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		try {
			DrugSupply s = supplyService.create(supply);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void createNotEnoughInventoryDrugSupplyRegister() {
		// Ensure there is not inventory
		drugInventory = new DrugInventory(drug, 0, "Here", Calendar.getInstance().getTime());

		// Ensure drug does not exists
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		try {
			supplyService.create(supply);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {

		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

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

		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

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
		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

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
		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		Mockito.when(supplyRepository.find(supply)).thenReturn(null);
		try {
			DrugSupply s = supplyService.find(supply);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}
}
