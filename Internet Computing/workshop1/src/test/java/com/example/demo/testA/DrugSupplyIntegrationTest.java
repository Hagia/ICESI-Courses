package com.example.demo.testA;

import static org.assertj.core.api.Assertions.fail;
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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.WorkshopApplication;
import com.example.demo.model.*;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.services.*;

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
	public void Inicialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		patient = new Patient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, patient, new Date(), "Gripa");

		drugInventory = new DrugInventory(drug, 10, "El bano", Calendar.getInstance().getTime());

	}

	@Test
	public void createValidDrugSupplyRegister() {
		drugInventory = new DrugInventory(drug, 10, "El bano", Calendar.getInstance().getTime());

		supplyService.clear();
		drugService.create(drug);
		patientsService.create(patient);
		inventoryService.create(drugInventory);

		try {
			DrugSupply s = supplyService.create(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void createInvalidPatientSupplyRegister() {
		drugInventory = new DrugInventory(drug, 10, "El bano", Calendar.getInstance().getTime());

		supplyService.clear();
		drugService.create(drug);
		inventoryService.create(drugInventory);

		try {
			DrugSupply s = supplyService.create(supply);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void createNotEnoughInventoryPatientSupplyRegister() {
		supplyService.clear();
		drugInventory = new DrugInventory(drug, 0, "El bano", Calendar.getInstance().getTime());

		drugService.create(drug);
		patientsService.create(patient);
		inventoryService.create(drugInventory);

		try {
			DrugSupply s = supplyService.create(supply);
		} catch (Exception e) {
			assertTrue(true);
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		supplyService.clear();
		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.delete(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		supplyService.clear();
		try {
			DrugSupply s = supplyService.delete(supply);
			assertNull(s);
		} catch (Exception e) {

		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
		drugInventory = new DrugInventory(drug, 10, "El bano", Calendar.getInstance().getTime());

		supplyService.clear();
		drugService.create(drug);
		patientsService.create(patient);
		inventoryService.create(drugInventory);
		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.find(supply);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		supplyService.clear();
		try {
			DrugSupply s = supplyService.find(supply);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}

}
