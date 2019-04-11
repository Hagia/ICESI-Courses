package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.*;

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor
public class Drug {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
