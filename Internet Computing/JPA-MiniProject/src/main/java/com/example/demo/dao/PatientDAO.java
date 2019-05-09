package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
@Scope("singleton")
public class PatientDAO implements IPatientDAO{
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@Override
	public List<Patient> findAllByName(String name) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select a ")
			.append("from Patient a ")
			.append("where a.name='" + name + "'");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllByLastname(String lastname) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select a ")
			.append("from Patient a ")
			.append("where a.lastName='" + lastname+"'");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllByName(String name, String sortingCriteria) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select a ")
			.append("from Patient a ")
			.append("where a.name='" + name + "' ")
			.append("order by " + sortingCriteria);
		return manager.createQuery(sb.toString()).getResultList();
		
	}

	@Override
	public List<Patient> findAllTwoUrgencies() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select * ")
			.append("from Patient p ")
			.append("where count(p.identification)>=2 ")
			.append("( select * ")
			.append("from DrugSupply ds ")
			.append("where p.identification=ds.patient)");
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
	public Patient get(Long identfication) {
		// TODO Auto-generated method stub
		return manager.find(Patient.class, identfication);
	}
	

	
}
