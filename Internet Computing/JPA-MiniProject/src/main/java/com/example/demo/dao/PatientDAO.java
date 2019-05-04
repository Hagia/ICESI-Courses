package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.model.Patient;

public class PatientDAO implements IPatientDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Patient> findAllByName(String name) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a ")
			.append("FROM patient a ")
			.append("WHERE a.name=")
			.append(name);
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllByLastname(String lastname) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a ")
			.append("FROM patient a ")
			.append("WHERE a.name=")
			.append(lastname);
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllByName(String name, String sortingCriteria) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a")
			.append("FROM patient a ")
			.append("WHERE a.name=")
			.append("ORDER BY " + sortingCriteria)
			.append(name);
		return manager.createQuery(sb.toString()).getResultList();
		
	}

	@Override
	public List<Patient> findAllTwoUrgencies() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *")
			.append("FROM patient a")
			.append("WHERE COUNT(a.identification)>=2")
			.append("( SELECT *")
			.append("FROM drugSupplis b")
			.append("WHERE a.identification=b.patient)");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public void save(Patient patient) {
		// TODO Auto-generated method stub
		manager.persist(patient);
		
	}

	@Override
	public void update(Patient patient) {
		// TODO Auto-generated method stub
		manager.merge(patient);
		
	}

	@Override
	public void delete(Patient patient) {
		// TODO Auto-generated method stub
		manager.remove(patient);
	}

	@Override
	public Patient get(String identfication) {
		// TODO Auto-generated method stub
		return manager.find(Patient.class, identfication);
	}
	

	
}
