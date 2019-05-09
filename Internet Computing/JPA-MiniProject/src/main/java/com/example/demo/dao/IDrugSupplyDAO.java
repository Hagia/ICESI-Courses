package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;

public interface IDrugSupplyDAO {

	void save(DrugSupply patient);

	void update(DrugSupply patient);

	void delete(DrugSupply patient);

	DrugSupply get(String id);

	List<DrugSupply> findByAmountRange(int min, int max);

	List<DrugSupply> findAllScarcing();

}
