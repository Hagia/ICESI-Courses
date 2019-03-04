package com.example.demo.model;

import lombok.Data;
import lombok.NonNull;
@Data
public class User {
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

}
