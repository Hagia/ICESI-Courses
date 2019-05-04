package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Data
public class User {

	@Id
	@NonNull
	private String login;
	@NonNull
	private String name;
	@NonNull
	private String lastName;
	@NonNull
	private String password;
	@NonNull
	private Boolean status;
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

}
