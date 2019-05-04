package com.example.demo.dao;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.model.Urgency;

public class UrgencyDAO implements IUrgencyDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Urgency patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Urgency patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Urgency patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Urgency get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Urgency findByDateRange(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
