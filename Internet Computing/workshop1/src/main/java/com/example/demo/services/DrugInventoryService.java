package com.example.demo.services;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.model.DrugSupply;
import com.example.demo.repository.DrugInventoryRepository;

import lombok.NonNull;

@Service
public class DrugInventoryService {
	
	private DrugInventoryRepository inventaryRepository;
	
	public DrugInventoryService() {
		inventaryRepository = new DrugInventoryRepository();
	}
	
	public DrugInventory find(@NonNull DrugInventory drugInventary) {
		// TODO Auto-generated method stub
		return inventaryRepository.find(drugInventary.getDrug());
	}
	
	public DrugInventory find(@NonNull DrugSupply drugSupply) {
		// TODO Auto-generated method stub
		return inventaryRepository.find(drugSupply.getDrug());
	}

	public DrugInventory update(DrugInventory drugInventary) {
		// TODO Auto-generated method stub
		return inventaryRepository.update(drugInventary);
	}

	public DrugInventory create(DrugInventory drugInventary) {
		// TODO Auto-generated method stub
		return inventaryRepository.create(drugInventary);
		
	}
	
	public void clear() {
		inventaryRepository.clear();
	}
	

}
