package com.icesi.workshop.database;

import com.icesi.workshop.model.*;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	List<User> findByName(String name);
	
	List<User> findByType(String type);

}