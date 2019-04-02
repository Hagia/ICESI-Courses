package com.example.demo.repository;

import java.io.ObjectOutputStream.PutField;
import java.util.HashMap;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.model.DrugSupply;

import lombok.Data;
import lombok.NonNull;

public interface DrugInventoryRepository extends CrudRepository<DrugInventory, Long>{

	
}
