package com.example.demo.repository;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;

import lombok.Data;
import lombok.NonNull;

@Data
public class DrugInventaryRepository {

	private HashMap<String, DrugInventary> inventary;

	public DrugInventaryRepository() {
		this.inventary = new HashMap<>();
	}

	public DrugInventary delete(Drug drug) {
		return inventary.remove(drug.getId());
	}

	public DrugInventary find(Drug drug) {
		// TODO Auto-generated method stub
		return inventary.get(drug.getId());
	}

	public DrugInventary update(DrugInventary drugInventary) {
		// TODO Auto-generated method stub
		return inventary.put(drugInventary.getDrug().getId(), drugInventary);
	}

	public DrugInventary create(DrugInventary drugInventary) {
		// TODO Auto-generated method stub
		return inventary.put(drugInventary.getDrug().getId(), drugInventary);
	}
}
