package com.example.demo.model;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class User {
	
	private String id;
	
	private String name;
	
	private String mail;

}
