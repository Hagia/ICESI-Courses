package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugSupply;

@Repository
@Scope("singleton")
public class DrugSupplyDAO implements IDrugSupplyDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<DrugSupply> findByAmountRange(int min, int max) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT *")
			.append("FROM drugSupplies ds")
			.append("WHERE ds.amount>=" + min)
			.append("AND ds.amount<="+ max);
		return manager.createQuery(sb.toString()).getResultList();
	}

	@Override
	public List<Drug> findAllScarcing() {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT d")
			.append("FROM DrugSupply ds, Drug d")
			.append("WHERE ds.amount<=10 ")
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
