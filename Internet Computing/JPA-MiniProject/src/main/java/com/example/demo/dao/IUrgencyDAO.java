package com.example.demo.dao;

import java.sql.Date;

import com.example.demo.model.Patient;
import com.example.demo.model.Urgency;

public interface IUrgencyDAO {

	void save(Urgency patient);

	void update(Urgency patient);

	void delete(Urgency patient);

	Urgency get(String id);

	Urgency findByDateRange(Date start, Date end);

}
