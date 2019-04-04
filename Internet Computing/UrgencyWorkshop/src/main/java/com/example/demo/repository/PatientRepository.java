package com.example.demo.repository;

import java.util.HashMap;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Patient;

import lombok.NonNull;

public interface PatientRepository extends CrudRepository<Patient, Long>{
	

}