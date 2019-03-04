package com.example.demo.model;

import lombok.Data;
import lombok.NonNull;

@Data
public class DrugInventary {
	@NonNull
	private Drug drug;
	@NonNull
	private Integer amount;
	@NonNull
	private String place;
	@NonNull
	private String endDate;
	
}
