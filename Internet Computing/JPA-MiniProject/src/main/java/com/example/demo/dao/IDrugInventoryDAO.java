package com.example.demo.dao;

import com.example.demo.model.DrugInventory;

public interface IDrugInventoryDAO {
	
	void save(DrugInventory inv);
	
	DrugInventory find(Long id);

}
