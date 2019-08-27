
package com.example.demo.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Drug;

@Repository
@Scope("singleton")
public class DrugDAO implements IDrugDAO{
	
	@PersistenceContext(type=PersistenceContextType.EXTENDED)
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
