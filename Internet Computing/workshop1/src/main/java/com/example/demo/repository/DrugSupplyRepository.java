package com.example.demo.repository;

import java.util.HashMap;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DrugSupply;

@Repository
public class DrugSupplyRepository {

	private HashMap<String, DrugSupply> supplies;

	public DrugSupplyRepository() {
		supplies = new HashMap<>();
	}

	public DrugSupply create(DrugSupply supply) {
		// TODO Auto-generated method stub
		supplies.put(supply.getId(), supply);
		return supplies.get(supply.getId());
	}

	public DrugSupply delete(DrugSupply supply) {
		// TODO Auto-generated method stub
		return supplies.remove(supply.getId());
	}

	public DrugSupply find(DrugSupply supply) {
		// TODO Auto-generated method stub
		return supplies.get(supply.getId());
	}

	public void clear() {
		// TODO Auto-generated method stub
		supplies.clear();
	}

}
