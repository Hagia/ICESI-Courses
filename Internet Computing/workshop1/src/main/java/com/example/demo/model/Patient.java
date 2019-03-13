package com.example.demo.model;

import java.util.List;

import lombok.Data;
import lombok.NonNull;
@Data
public class Patient {
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
