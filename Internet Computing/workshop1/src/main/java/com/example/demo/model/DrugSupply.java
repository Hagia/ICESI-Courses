package com.example.demo.model;

import java.sql.Date;

import lombok.Data;
import lombok.NonNull;

@Data
public class DrugSupply {
	@NonNull
	private String id;
	@NonNull
	private Drug drug;
	@NonNull
	private Pacient pacient;
	@NonNull
	private java.util.Date date;
	private String observation;
	@NonNull
	private String patology;
}
