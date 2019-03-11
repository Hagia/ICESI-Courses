package com.example.demo.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;
import com.example.demo.repository.DrugInventaryRepository;

import lombok.NonNull;

@Service
public class DrugInventaryService {
	
	private DrugInventaryRepository inventaryRepository;
	
	public DrugInventaryService() {
		inventaryRepository = new DrugInventaryRepository();
	}
	
	public DrugInventary find(@NonNull DrugInventary drugInventary) {
		// TODO Auto-generated method stub
		return inventaryRepository.find(drugInventary);
	}
	
	public DrugInventary find(@NonNull DrugSupply drugSupply) {
		// TODO Auto-generated method stub
		return inventaryRepository.find(drugSupply);
	}

	public DrugInventary update(DrugInventary drugInventary) {
		// TODO Auto-generated method stub
		return inventaryRepository.update(drugInventary);
	}

	public DrugInventary create(DrugInventary drugInventary) {
		// TODO Auto-generated method stub
		return inventaryRepository.create(drugInventary);
		
	}
	

}
