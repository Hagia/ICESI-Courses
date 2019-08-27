package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugSupply;

@Repository
@Scope("singleton")
public class DrugSupplyDAO implements IDrugSupplyDAO{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	private EntityManager manager;
	
	@Override
	public List<DrugSupply> findByAmountRange(int min, int max) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ds ")
			.append("FROM DrugSupply ds ")
			.append("WHERE ds.amount BETWEEN '" + min + "' AND '" + max + "'");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Drug> findAllScarcing() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT d ")
			.append("FROM DrugSupply ds, Drug d ")
			.append("WHERE ds.amount< 11 ")
			.append("AND d.id=ds.drug");
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public void save(DrugSupply patient) {
		// TODO Auto-generated method stub
		manager.persist(patient);
	}

	@Override
	public void update(DrugSupply patient) {
		// TODO Auto-generated method stub
		manager.merge(patient);
	}

	@Override
	public void delete(DrugSupply patient) {
		// TODO Auto-generated method stub
		manager.remove(patient);
	}

	@Override
	public DrugSupply get(Long id) {
		// TODO Auto-generated method stub
		return manager.find(DrugSupply.class, id);
	}

}
