package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.repository.DrugRepository;

import lombok.NonNull;

@Service
public class DrugService {
	
	private DrugRepository drugRepository;
	
	public DrugService() {
		drugRepository = new DrugRepository();
	}

	public Drug find(@NonNull Drug drug) {
		// TODO Auto-generated method stub
		return drugRepository.find(drug);
	}

	public Drug create(Drug drug) {
		// TODO Auto-generated method stub
		return drugRepository.create(drug);
	}

}
