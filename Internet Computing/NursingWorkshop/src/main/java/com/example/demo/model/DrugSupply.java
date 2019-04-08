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

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
public class DrugSupply {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long key;
	@NonNull
	private String id;
	@NonNull
	@OneToOne
	private Drug drug;
	
	@NonNull
	private Integer amount;
	@NonNull
	@OneToOne	
	private Patient patient;
	@NonNull
	private Date date;
	
	private String observation;
	@NonNull
	private String patology;
}
