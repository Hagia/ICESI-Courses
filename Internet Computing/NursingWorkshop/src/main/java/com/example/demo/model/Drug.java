package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.*;

@Data
@Entity
public class Drug {

	@NonNull
	@Id
	private Long id;
	@NonNull
	private String name;
	@NonNull
	private String genericName;
	@NonNull
	private String lab;
	@NonNull
	private String useMode;
	@NonNull
	private String indications;
	
	private String warnings;
}
