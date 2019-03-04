package com.example.demo.model;

import java.util.List;

import lombok.*;

@Data
public class Drug {

	@NonNull
	private String id;
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
