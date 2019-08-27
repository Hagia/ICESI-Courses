package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;
import com.example.demo.service.InitService;

import lombok.extern.log4j.Log4j2;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
@Log4j2
public class TestDrugSupplyDAO {

	@Autowired
	private IDrugSupplyDAO drugSupplyDAO;

	@Autowired
	private IPatientDAO patientDAO;
	
	@Test
	public void testMerge() {
		assertNotNull(drugSupplyDAO);
		assertNotNull(patientDAO);
		
		
		DrugSupply drugSupply = drugSupplyDAO.get(Long.parseLong("25"));

		assertNotNull("Code not found", drugSupply);

		drugSupply.setPatient(patientDAO.get(Long.parseLong("2")));

		drugSupplyDAO.save(drugSupply);
	}

	@Test
	public void testRemove() {
		assertNotNull(drugSupplyDAO);
		assertNotNull(patientDAO);

		DrugSupply drugSupply = drugSupplyDAO.get(Long.parseLong("26"));

		assertNotNull("Code not found", drugSupply);

		drugSupplyDAO.delete(drugSupply);
	}

	@Test
	public void testFindByAmountRange() {
		assertNotNull(drugSupplyDAO);

		int max = 20, min = 10;

		List<DrugSupply> list = drugSupplyDAO.findByAmountRange(min, max);

		assertEquals(2, list.size());

	}

	@Test
	public void testFindAllScarcing() {
		assertNotNull(drugSupplyDAO);

		List<Drug> list = drugSupplyDAO.findAllScarcing();

		assertEquals(2, list.size());
	}
}
