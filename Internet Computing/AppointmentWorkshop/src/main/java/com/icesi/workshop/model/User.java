package com.icesi.workshop.model;


import java.sql.Date;

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
@RequiredArgsConstructor
@NoArgsConstructor
public class User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NonNull
	private String name;
	@NonNull
	private String mail;
	@NonNull
	private String type;
	@NonNull
	private String gender;
	@NonNull
	private Date birthday;
	
	public String toString() {
		return name;
	}

}