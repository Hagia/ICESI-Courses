package com.example.demo.repository;

import java.sql.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Urgency;

@Repository
public interface UrgencyRepository extends CrudRepository<Urgency, Long>{
	
	public Iterable<Urgency> findAllByDate(Date date);
	
}
