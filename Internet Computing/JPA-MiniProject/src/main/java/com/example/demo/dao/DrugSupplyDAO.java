package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.demo.model.DrugSupply;

public class DrugSupplyDAO implements IDrugSupplyDAO{

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public DrugSupply findByAmountRange(int min, int max) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DrugSupply> findAllScarcing() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(DrugSupply patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(DrugSupply patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(DrugSupply patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DrugSupply get(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
