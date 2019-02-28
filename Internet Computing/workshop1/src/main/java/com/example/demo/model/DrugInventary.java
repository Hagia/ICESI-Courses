package com.example.demo.model;

import lombok.Data;

@Data
public class DrugInventary {

	private Drug drug;
	private int amount;
	private String place;
	private String endDate;
	
}
