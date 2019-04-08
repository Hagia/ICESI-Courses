package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@NoArgsConstructor
public class Urgency {
	@Id
	private Long key;
	@NonNull
	private String id;
	@NonNull
	private Date date;
	@NonNull
	@OneToOne
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
	@OneToMany
	private List<DrugSupply> supplies;

}
