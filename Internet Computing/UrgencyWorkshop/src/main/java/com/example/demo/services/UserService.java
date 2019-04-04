package com.example.demo.services;

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
	
	public User add(User user) {
		return ur.save(user);
	}
	
}
