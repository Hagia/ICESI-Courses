package com.example.demo.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

import org.apache.logging.log4j.CloseableThreadContext.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

@Repository
@Scope("singleton")
public class PatientDAO implements IPatientDAO {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@Override
	public List<Patient> findAllByName(String name) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select a ").append("from Patient a ").append("where a.name='" + name + "'");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllByLastname(String lastname) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("select a ").append("from Patient a ").append("where a.lastName='" + lastname + "'");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllByDocument(String document) {

		StringBuilder sb = new StringBuilder();
		sb.append("select a ")
		.append("from Patient a ")
		.append("where a.identification='" + document + "'");
		return manager.createQuery(sb.toString()).getResultList();

	}

	@Override
	public List<Patient> findAllByName(String name, String sortingCriteria) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT a, count(b) ").append("FROM Patient a, Urgency b ").append("WHERE a.name='" + name + "' ")
				.append("AND b.patient=a.id ").append("ORDER BY " + sortingCriteria);
		return manager.createQuery(sb.toString()).getResultList();

	}
	
	public List countUrgencies(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("SELECT p, COUNT(p.id) AS Amount")
			.append("FROM Patient p, Urgency u ")
			.append("WHERE p.id = u.patient ");
	
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Patient> findAllTwoUrgencies() {
		// TODO Auto-generated method stub

		int days = 30;

		Calendar calendar = new GregorianCalendar();
		calendar.setTimeZone(TimeZone.getTimeZone("UTC+5"));
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, -days);
		Date dateToLookBackAfter = calendar.getTime();

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT p ").append("FROM Patient p ").append("WHERE p.id IN ").append("( SELECT pa.id ")
				.append("FROM Urgency u, Patient pa ").append("WHERE pa.id=u.patient ")
				.append("AND u.date >= :LookBack ").append("AND COUNT(pa.id)>2 )");

		TypedQuery<Patient> query = manager.createQuery(sb.toString(), Patient.class);
		query.setParameter("LookBack", dateToLookBackAfter, TemporalType.DATE);

		return query.getResultList();

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
