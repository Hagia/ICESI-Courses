package com.example.demo.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Urgency {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
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
	private Boolean dispatch;

	private String dispatchPlace;
	@NonNull
	private String observation;

	@OneToMany
	private List<DrugSupply> supplies;

}
