package com.example.demo.testA;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
	public void Inicialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		drugInventary = new DrugInventary(drug, 10, "El bano", Calendar.getInstance().getTime());
		
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
			assertNull(s);
		} catch (Exception e) {
			
		}
	}

	@Test
	public void findStoredDrugSupplyRegister() {
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
		try {
			supplyService.delete(supply);
			DrugSupply s = supplyService.find(supply);
			assertNull(s);
		} catch (Exception e) {
			fail();
		}
	}

}
