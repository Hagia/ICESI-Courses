package com.example.demo.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Pacient;
import com.example.demo.repository.DrugSupplyRepository;
import com.example.demo.services.DrugSupplyService;

@RunWith(JUnit4.class)
public class DrugSupplyIntegrationTest {
	
	private DrugSupplyService supplyService;

	private DrugSupplyRepository supplyRepository;
	
	private Drug drug;
	private DrugInventary drugInventary;
	private Pacient pacient;
	private DrugSupply supply;

	@Before
	public void Inicialitation() {
		drug = new Drug("123", "PazNoche", "Noche", "MiCasa", "De Noche", "Mayores de 18");
		drugInventary = new DrugInventary(drug, 10, "El bano", "24/abril/2018");
		pacient = new Pacient("1113681367", "Santiago", "Gutierrez", false);
		supply = new DrugSupply("12345", drug, pacient, new Date(), "Gripa");
		supplyService = new DrugSupplyService(supplyRepository);
	}

	@Test
	public void createDrugSupplyRegister() {
		DrugSupply s = supplyService.create(supply);
		assertNotNull(s);
	}
	
	@Test
	public void createNullDrugSupplyRegister() {
		DrugSupply s = supplyService.create(supply);
		assertNull(s);
	}

	@Test
	public void deleteStoredDrugSupplyRegister() {
		DrugSupply s = supplyService.delete(supply);
		assertNotNull(s);
	}
	@Test
	public void deleteUnstoredDrugSupplyRegister() {
		DrugSupply s = supplyService.delete(supply);
		assertNull(s);
	}
	@Test
	public void findStoredDrugSupplyRegister() {
		DrugSupply s = supplyService.find(supply);
		assertNotNull(s);
	}
	@Test
	public void findUnstoredDrugSupplyRegister() {
		DrugSupply s = supplyService.find(supply);
		assertNull(s);
	}


}
