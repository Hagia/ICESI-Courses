package com.example.demo.model;

import java.util.List;

import lombok.NonNull;

public class Pacient {
	
	private String identification;
	private String name;
	private String lastName;
	private String program;
	private String academyDenpendency;
	private boolean status;
	
	private List<DrugSupply> supplies;
	
	private List<Urgency> urgencies;
	
	@NonNull
	private User user;

}
