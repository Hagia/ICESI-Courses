package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DrugInventory;

@Repository
@Scope("singleton")
public class DrugInventoryDAO implements IDrugInventoryDAO{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;

	@Override
	public void save(DrugInventory inv) {
		// TODO Auto-generated method stub
		manager.persist(inv);
	}

	@Override
	public DrugInventory find(Long id) {
		// TODO Auto-generated method stub
		return manager.find(DrugInventory.class, id);
	}
	
	
}
