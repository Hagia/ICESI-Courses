package com.example.demo.model;

import java.sql.Date;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class DrugSupply {
	@NonNull
	private String id;
	@NonNull
	private Drug drug;
	@NonNull
	private Patient pacient;
	@NonNull
	private java.util.Date date;
	private String observation;
	@NonNull
	private String patology;
}
