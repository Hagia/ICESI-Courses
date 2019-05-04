package com.example.demo.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class DrugInventory {

	@Id
	private Long id;
	
	@NonNull
	@ManyToOne
	private Drug drug;
	
	@NonNull
	private Integer amount;
	
	@NonNull
	private String place;
	
	@NonNull
	private Date endDate;
}
