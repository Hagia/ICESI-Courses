package com.example.demo.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class DrugSupply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long key;
	
	@NonNull
	@OneToOne
	private Drug drug;
	
	@OneToOne
	private Patient patient;
	
	@NonNull
	private String id;

	@NonNull
	private Integer amount;
	
	@NonNull
	private Date date;

	private String observation;
	
	@NonNull
	private String patology;

	
}
