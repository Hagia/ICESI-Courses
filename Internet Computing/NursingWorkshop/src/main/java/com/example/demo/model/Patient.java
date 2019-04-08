package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Patient {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NonNull
	private String identification;
	@NonNull
	private String name;
	@NonNull
	private String lastName;
	
	private String program;
	
	private String academyDenpendency;
	@NonNull
	private Boolean status;
	
}
