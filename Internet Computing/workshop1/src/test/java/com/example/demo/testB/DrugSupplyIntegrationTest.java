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
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Pacient;
import com.example.demo.repository.DrugInventaryRepository;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.services.DrugInventaryService;
import com.example.demo.services.DrugService;
import com.example.demo.services.DrugSupplyService;
import com.example.demo.services.PacientService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= WorkshopApplication.class)
public class DrugSupplyIntegrationTest {
	
	@Autowired
	private DrugSupplyService supplyService;
	@Autowired
	private DrugSupplyRepository suppliesRepository;
	@Autowired
	private DrugService drugService;
	@Autowired
	private PacientService pacientsService;
	@Autowired
	private DrugInventaryService inventaryService;
	
	private Drug drug;
	private DrugInventary drugInventary;
	private Pacient pacient;
	private DrugSupply supply;

	@Before
	public void init() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventary = new DrugInventary(drug, 10, "El bano", Calendar.getInstance().getTime());
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		
		drugService.create(drug);
		pacientsService.create(pacient);
		inventaryService.create(drugInventary);
	}

	@Test
	public void createDrugSupplyRegister() {
		try {
			supplyService.clear();
			DrugSupply s = supplyService.create(supply);
			assertNotNull(s);
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void createNullDrugSupplyRegister() {
		try {
//			supplyService.create(supply);
			DrugSupply s = supplyService.find(supply);
			DrugInventary di = inventaryService.find(supply);
			assertTrue(di.getAmount() == 10);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.delete(supply);
			DrugInventary di = inventaryService.find(supply);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		try {
			supplyService.clear();
			DrugSupply s = supplyService.delete(supply);
			DrugInventary di = inventaryService.find(supply);
			assertTrue(di.getAmount() == 10);
			assertNull(s);
		} catch (Exception e) {
			
		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
		try {
			supplyService.create(supply);
			DrugSupply s = supplyService.find(supply);
			DrugInventary di = inventaryService.find(supply);
			assertTrue(di.getAmount() == 9);
			assertNotNull(s);
		} catch (Exception e) {
			fail();
		}
	}

	@Test
	public void findUnstoredDrugSupplyRegister() {
		try {
			supplyService.clear();
			DrugSupply s = supplyService.find(supply);
			DrugInventary di = inventaryService.find(supply);
			assertTrue(di.getAmount() == 10);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}


}
