package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.DrugInventary;

import lombok.Data;

@Data
public class DrugInvetaryRepository {

	private HashMap<String, DrugInventary> Inventary;

	public void Create(DrugInventary drug) {

	}

	public DrugInventary Delete(DrugInventary drug) {
		return null;
	}

	public DrugInventary Find(DrugInventary drug) {
		return null;
	}
}
