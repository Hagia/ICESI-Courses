package com.example.demo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestDrugSupplyDAO {

	@Autowired
	private IDrugSupplyDAO drugSupplyDAO;

	@Autowired
	private IPatientDAO patientDAO;

	private Patient p1;

	private Patient p2;

	@Before
	public void setup() {

		if (p1 == null || p2 == null) {
			p1 = new Patient();
			p2 = new Patient();

			p1.setName("Mauricio");
			p1.setIdentification("1234");
			p1.setProgram("SIS");
			p1.setLastName("Hernández");
			p1.setStatus(Boolean.TRUE);

			p2.setName("Mauricio");
			p2.setIdentification("12364");
			p2.setProgram("SIS");
			p2.setLastName("Hernández");
			p2.setStatus(Boolean.TRUE);

			patientDAO.save(p1);
			patientDAO.save(p2);
		}
	}

	@Test
	public void testSave() {
		assertNotNull(drugSupplyDAO);

		Drug drug = new Drug("Acetaminofen", "Acetaminofen", "GENFAR", "2 per day", "No children");
		DrugSupply drugSupply = new DrugSupply();

		drugSupply.setAmount(15);
		drugSupply.setDate(new Date(System.currentTimeMillis()));
		drugSupply.setId("AC1");
		drugSupply.setPatology("Gripe");
		drugSupply.setDrug(drug);

		drugSupplyDAO.save(drugSupply);
	}

	@Test
	public void testMerge() {
		assertNotNull(drugSupplyDAO);
		assertNotNull(patientDAO);

		DrugSupply drugSupply = drugSupplyDAO.get(Long.parseLong("1"));

		assertNotNull("Code not found", drugSupply);

		drugSupply.setPatient(patientDAO.get(Long.parseLong("2")));

		drugSupplyDAO.save(drugSupply);
	}

	@Test
	public void testRemove() {
		assertNotNull(drugSupplyDAO);
		assertNotNull(patientDAO);

		DrugSupply drugSupply = drugSupplyDAO.get(Long.parseLong("1"));

		assertNotNull("Code not found", drugSupply);

		drugSupplyDAO.delete(drugSupply);
	}

	public void testFindByAmountRange() {
		assertNotNull(drugSupplyDAO);

		int max = 20, min = 10;

		List<DrugSupply> list = drugSupplyDAO.findByAmountRange(min, max);

		assertEquals(1, list.size());

	}

	public void testFindAllScarcing() {
		assertNotNull(drugSupplyDAO);

		List<Drug> list = drugSupplyDAO.findAllScarcing();

		assertEquals(0, list.size());
	}
}
