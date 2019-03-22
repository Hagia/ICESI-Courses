package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class UserList {
	
	private List<User> list;
	
	public UserList() {
		list = new ArrayList<User>();
	}
	
	
}
