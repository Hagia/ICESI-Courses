package com.example.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;
@Data
@Entity
public class Patient {
	
	@Id
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
