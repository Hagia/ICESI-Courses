package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.Patient;

public interface IPatientDAO {
	
	void save(Patient patient);
	
	void update(Patient patient);
	
	void delete(Patient patient);
	
	Patient get(String identfication);
	
	List<Patient> findAllByName(String name);
	
	List<Patient> findAllByLastname(String lastname);
	
	
	List<Patient> findAllByName(String name, String sortingCriteria);
	
	List<Patient> findAllTwoUrgencies();
}
