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

	public DrugInventory find(DrugSupply supply) {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(DrugInventory di) {
		// TODO Auto-generated method stub
		
	}
	

}
