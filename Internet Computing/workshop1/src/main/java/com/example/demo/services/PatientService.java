package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;

import lombok.NonNull;

@Service
public class PatientService {
	
	private PatientRepository pacientRepository;
	
	public PatientService() {
		pacientRepository = new PatientRepository();
	}

	public Patient find(@NonNull Patient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.find(pacient);
	}

	public Patient create(Patient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.create(pacient);
	}
	
	public void clear() {
		pacientRepository.clear();
	}

}
