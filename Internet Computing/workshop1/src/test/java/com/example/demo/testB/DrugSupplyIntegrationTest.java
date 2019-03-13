package com.example.demo.testB;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.WorkshopApplication;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WorkshopApplication.class)
public class DrugSupplyIntegrationTest {

	@Autowired
	private DrugSupplyService supplyService;
	@Autowired
	private DrugSupplyRepository suppliesRepository;
	@Autowired
	private DrugService drugService;
	@Autowired
	private PatientService patientsService;
	@Autowired
	private DrugInventoryService inventoryService;

	private Drug drug;
	private DrugInventory drugInventory;
	private Patient patient;
	private DrugSupply supply;

	@Before
	public void init() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventory = new DrugInventory(drug, 10, "El bano", Calendar.getInstance().getTime());
		patient = new Patient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, patient, new Date(), "Gripa");

	}

	@Test
	public void createValidDrugSupplyRegister() {

		supplyService.clear();

		drugService.create(drug);
		patientsService.create(patient);
		inventoryService.create(drugInventory);
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
	public void createInvalidPatientSupplyRegister() {
		supplyService.clear();
		drugService.create(drug);
		inventoryService.create(drugInventory);
		try {
			supplyService.create(supply);

		} catch (Exception e) {
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 10);
			fail();
		}
	}

	@Test
	public void createInvalidDrugSupplyRegister() {
		supplyService.clear();
		patientsService.create(patient);
		inventoryService.create(drugInventory);
		try {
			supplyService.create(supply);
		} catch (Exception e) {
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 10);
			fail();
		}
	}

	@Test
	public void createNotEnoghInventorySupplyRegister() {
		supplyService.clear();
		inventoryService.clear();
		drugInventory = new DrugInventory(drug, 0, "El bano", Calendar.getInstance().getTime());

		drugService.create(drug);
		patientsService.create(patient);
		inventoryService.create(drugInventory);
		try {
			supplyService.create(supply);
		} catch (Exception e) {
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 0);
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.delete(supply);
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		supplyService.clear();
		inventoryService.create(drugInventory);

		try {
			DrugSupply s = supplyService.delete(supply);
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 10);
			assertNull(s);
		} catch (Exception e) {

		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
		supplyService.clear();

		drugService.create(drug);
		patientsService.create(patient);
		inventoryService.create(drugInventory);

		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.find(supply);
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		supplyService.clear();
		inventoryService.clear();
		inventoryService.create(drugInventory);
		try {
			DrugSupply s = supplyService.find(supply);
			DrugInventory di = inventoryService.find(supply);
			assertTrue(di.getAmount() == 10);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}

}
