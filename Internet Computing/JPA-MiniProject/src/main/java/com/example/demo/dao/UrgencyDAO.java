package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Urgency;

@Repository
@Scope("singleton")
public class UrgencyDAO implements IUrgencyDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Urgency urgency) {
		// TODO Auto-generated method stub
		manager.persist(urgency);
	}

	@Override
	public void update(Urgency urgency) {
		// TODO Auto-generated method stub
		manager.merge(urgency);
	}

	@Override
	public void delete(Urgency urgency) {
		// TODO Auto-generated method stub
		manager.remove(urgency);
	}

	@Override
	public Urgency get(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Urgency.class, id);
	}

	@Override
	public List<Urgency> findByDateRange(Date start, Date end) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT u ")
			.append("FROM Urgency u ")
			.append("WHERE u.date ")
			.append("BETWEEN '" + start + "'")
			.append(" AND '" + end + "'");
		return manager.createQuery(sb.toString()).getResultList();
	}

	
	
	

}
