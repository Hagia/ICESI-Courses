package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.Drug;

import lombok.NonNull;

public class DrugRepository {
	
	private HashMap<String, Drug> drugs;

	public DrugRepository() {
		drugs = new HashMap<>();
	}
	
	public Drug find(@NonNull Drug drug) {
		// TODO Auto-generated method stub
		return drugs.get(drug.getId());
	}

}
