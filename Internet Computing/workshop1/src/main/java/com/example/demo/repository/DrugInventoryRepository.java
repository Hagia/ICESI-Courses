package com.example.demo.repository;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.model.DrugSupply;

import lombok.Data;
import lombok.NonNull;

@Data
public class DrugInventoryRepository {

	private HashMap<String, DrugInventory> inventary;

	public DrugInventoryRepository() {
		this.inventary = new HashMap<>();
	}

	public DrugInventory delete(Drug drug) {
		return inventary.remove(drug.getId());
	}

	public DrugInventory find(Drug drug) {
		// TODO Auto-generated method stub
		return inventary.get(drug.getId());
	}

	public DrugInventory update(DrugInventory drugInventary) {
		// TODO Auto-generated method stub
		return inventary.put(drugInventary.getDrug().getId(), drugInventary);
	}

	public DrugInventory create(DrugInventory drugInventary) {
		// TODO Auto-generated method stub
		return inventary.put(drugInventary.getDrug().getId(), drugInventary);
	}

	public void clear() {
		// TODO Auto-generated method stub
		inventary.clear();
	}
}
