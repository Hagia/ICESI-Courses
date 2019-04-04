package com.example.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import lombok.NonNull;

@Service
public class UserService {
	
	@Autowired
	private UserRepository ur;

	public User find(@NonNull String login) {
		// TODO Auto-generated method stub
		return ur.findByLogin(login).get();
	}
	
	public List<User> findAll(){
		List<User> users = new ArrayList<User>();
		Iterator<User> iter = ur.findAll().iterator();
		while(iter.hasNext()) {
			users.add(iter.next());
		}
		
		return users;
	}
	
	public User add(User user) {
		return ur.save(user);
	}
	
}
