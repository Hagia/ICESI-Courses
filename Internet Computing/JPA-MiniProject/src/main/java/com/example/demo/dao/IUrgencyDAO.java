package com.example.demo.dao;

import java.sql.Date;
import java.util.List;

import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;

public interface IUrgencyDAO {

	void save(Urgency urgency);

	void update(Urgency urgency);

	void delete(Urgency urgency);

	Urgency get(Long id);

	List<Urgency> findByDateRange(Date start, Date end);

}
