package com.example.demo.model;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NonNull;

@Data
public class Urgency {

	@NonNull
	private String id;
	@NonNull
	private Date date;
	@NonNull
	private Patient pacient;
	@NonNull
	private String description;
	@NonNull
	private String procedure;
	@NonNull
	private Boolean dispacth;
	@NonNull
	private String dispatchPlace;
	@NonNull
	private String observation;
	
	private List<DrugSupply> supplies;

}
