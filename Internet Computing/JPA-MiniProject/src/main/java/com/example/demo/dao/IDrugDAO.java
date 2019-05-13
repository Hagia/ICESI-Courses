package com.example.demo.dao;

import com.example.demo.model.Drug;

public interface IDrugDAO {

	void save(Drug drug);
	
	Drug find(Long id);
	
}
