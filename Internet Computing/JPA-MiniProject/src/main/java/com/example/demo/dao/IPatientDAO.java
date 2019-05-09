package com.example.demo.dao;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patient;

public interface IPatientDAO {

	void save(Patient patient);

	void update(Patient patient);

	void delete(Patient patient);

	Patient get(Long identfication);

	List<Patient> findAllByName(String name);

	List<Patient> findAllByLastname(String lastname);

	List<Patient> findAllByName(String name, String sortingCriteria);

	List<Patient> findAllTwoUrgencies();
}
