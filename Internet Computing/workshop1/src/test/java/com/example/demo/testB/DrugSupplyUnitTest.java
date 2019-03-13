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
import com.example.demo.model.DrugInventory;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.repository.DrugInventoryRepository;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.services.DrugInventoryService;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PatientService;

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
	private DrugInventory drugInventory;
	private DrugInventory drugInventoryUpdated;
	private Patient patient;
	private DrugSupply supply;

	@Before
	public void init() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventory = new DrugInventory(drug, 10, "El bano", Calendar.getInstance().getTime());
		drugInventoryUpdated = new DrugInventory(drug, 9, "El bano", Calendar.getInstance().getTime());

		patient = new Patient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, patient, new Date(), "Gripa");

	}

	@Test
	public void createValidSupplyRegister() {

		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		// Ensure repository works properly
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventoryUpdated);

		try {
			DrugSupply s = supplyService.create(supply);
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void createInvalidPacientDrugSupplyRegister() {
		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(null);

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventory);

		try {
			supplyService.create(supply);
		} catch (Exception e) {
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 10);
			assertTrue(true);
		}
	}

	@Test
	public void createInvalidDrugSupplyRegister() {
		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(null);

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventory);

		try {
			supplyService.create(supply);
		} catch (Exception e) {
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 10);
			assertTrue(true);
		}
	}

	@Test
	public void createNotEnoughInventoryDrugSupplyRegister() {
		drugInventory = new DrugInventory(drug, 0, "El bano", Calendar.getInstance().getTime());

		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(null);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventory);

		try {
			supplyService.create(supply);
		} catch (Exception e) {
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 0);
			assertTrue(true);
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(drug);
		Mockito.when(inventoryService.find(supply)).thenReturn(drugInventory);

		// Ensure repository works properly
		Mockito.when(supplyRepository.create(supply)).thenReturn(supply);

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventoryUpdated);

		Mockito.when(supplyRepository.delete(supply)).thenReturn(supply);

		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.delete(supply);
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		// Ensure preconditions
		Mockito.when(patientsService.find(patient)).thenReturn(patient);
		Mockito.when(drugService.find(drug)).thenReturn(null);

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventory);

		try {
			DrugSupply s = supplyService.delete(supply);
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 10);
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

		// Ensure inventory service is updating
		Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventoryUpdated);

		Mockito.when(supplyRepository.find(supply)).thenReturn(supply);

		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.find(supply);
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {

		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		try {
			Mockito.when(supplyService.find(supply)).thenReturn(null);
			Mockito.when(inventoryService.find(drugInventory)).thenReturn(drugInventory);
			
			DrugSupply s = supplyService.find(supply);
			DrugInventory di = inventoryService.find(drugInventory);
			assertTrue(di.getAmount() == 10);
			assertNull(s);
		} catch (Exception e) {

		}
	}
}
