package com.example.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

import lombok.NonNull;

@Service
public class PatientService {
	
	@Autowired
	private PatientRepository patientRepository;

	public Patient find(@NonNull Patient pacient) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Patient> findAll(){
		Iterator<Patient> iter = patientRepository.findAll().iterator();
		List<Patient> list = new ArrayList<Patient>();
		while(iter.hasNext()) {
			list.add(iter.next());
		}
		
		return list;
	}

	public Patient create(Patient patient) {
		// TODO Auto-generated method stub
		return patientRepository.save(patient);
	}
	
}
