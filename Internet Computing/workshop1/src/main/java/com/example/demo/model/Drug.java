package com.example.demo.model;

import java.util.List;

import lombok.*;

@Data
public class Drug {

	private String id;
	private String name;
	private String genericName;
	private String lab;
	private String useMode;
	private String indications;
	private String warnings;
	
	@NonNull
	private List<DrugSupply> supplies;
	
	private List<DrugInventary> inventaries;
	
	@NonNull
	private Pacient pacient;
}
