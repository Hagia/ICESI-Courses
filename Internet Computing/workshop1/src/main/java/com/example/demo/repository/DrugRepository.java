package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.Drug;

import lombok.NonNull;

public class DrugRepository {
	
	private HashMap<String, Drug> drugs;

	public DrugRepository() {
		drugs = new HashMap<>();
	}
	
	public Drug find( Drug drug) {
		// TODO Auto-generated method stub
		return drugs.get(drug.getId());
	}

	public Drug create(Drug drug) {
		// TODO Auto-generated method stub
		return drugs.put(drug.getId(), drug);
	}
	
	public Drug delete(Drug drug) {
		return drugs.remove(drug.getId());
	}

}
