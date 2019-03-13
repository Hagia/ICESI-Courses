package com.example.demo.model;

import java.util.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class DrugInventory {
	@NonNull
	private Drug drug;
	@NonNull
	private Integer amount;
	@NonNull
	private String place;
	@NonNull
	private Date endDate;
}
