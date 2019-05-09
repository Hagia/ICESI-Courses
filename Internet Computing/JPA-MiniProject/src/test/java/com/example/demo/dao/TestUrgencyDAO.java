package com.example.demo.dao;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.model.Patient;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUrgencyDAO {
	
	@Autowired
	private IUrgencyDAO urgencyDAO;
	
	@Autowired
	private IPatientDAO patientDAO;
	
	@BeforeClass
	public void setup() {
		Patient patient1 = new Patient();

		patient1.setName("Mauricio");
		patient1.setIdentification("1234");
		patient1.setProgram("SIS");
		patient1.setLastName("Hernández");
		patient1.setStatus(Boolean.TRUE);
		
		patientDAO.save(patient1);
	}

}
