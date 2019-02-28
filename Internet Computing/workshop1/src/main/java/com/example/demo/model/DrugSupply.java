package com.example.demo.model;

import java.sql.Date;

import lombok.Data;

@Data
public class DrugSupply {

	private String id;
	private Drug drug;
	private Pacient pacient;
	private java.util.Date date;
	private String observation;
	private String patology;
}
