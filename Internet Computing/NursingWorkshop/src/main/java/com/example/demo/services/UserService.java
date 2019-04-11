package com.example.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.PrincipalUser;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import lombok.NonNull;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository ur;

	public User find(@NonNull String login) {
		// TODO Auto-generated method stub
		return ur.findByLogin(login).get();
	}

	@PostConstruct
	public void createUsers() {

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		ur.save(new User("juan", passwordEncoder.encode("123")));
		ur.save(new User("ana", passwordEncoder.encode("123")));
		ur.save(new User("camilo", passwordEncoder.encode("123")));
		ur.save(new User("diana", passwordEncoder.encode("123")));
	}

	public UserDetails loadUserByUsername(String username) {
		Optional<User> user = ur.findByLogin(username);
		if (!user.isPresent()) {
			throw new RuntimeException(username);
		}
		return new PrincipalUser(user.get());
	}

	public List<User> findAll() {
		List<User> users = new ArrayList<User>();
		Iterator<User> iter = ur.findAll().iterator();
		while (iter.hasNext()) {
			users.add(iter.next());
		}

		return users;
	}

	public User add(User user) {
		return ur.save(user);
	}

}
