package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.model.Drug;

public class DrugDAO implements IDrugDAO{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public void save(Drug drug) {
		// TODO Auto-generated method stub
		manager.persist(drug);
	}

	@Override
	public Drug find(Long id) {
		// TODO Auto-generated method stub
		return manager.find(Drug.class, id);
	}

}
