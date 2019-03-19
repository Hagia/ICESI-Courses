package com.example.demo.model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
public class User {
	
	@javax.persistence.Id
	private String id;
	
	private String name;
	
	private String mail;

}
