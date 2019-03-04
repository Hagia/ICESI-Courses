package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;

import lombok.Data;
import lombok.NonNull;

@Data
public class DrugInventaryRepository {

	private HashMap<String, DrugInventary> Inventary;

	public void Create(DrugInventary drug) {

	}

	public DrugInventary Delete(DrugInventary drug) {
		return null;
	}

	public DrugInventary Find(DrugInventary drug) {
		return null;
	}

	public DrugInventary[] find(@NonNull Drug drug) {
		// TODO Auto-generated method stub
		return null;
	}

	public Object update(DrugInventary drugInventary) {
		// TODO Auto-generated method stub
		return null;
	}
}
