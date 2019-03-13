package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.Patient;

import lombok.NonNull;

public class PatientRepository {
	
	private HashMap<String, Patient> pacients;
	
	public PatientRepository() {
		pacients= new HashMap<>();
	}

	public Patient find(@NonNull Patient pacient) {
		// TODO Auto-generated method stub
		return pacients.get(pacient.getIdentification());
	}

	public Patient create(Patient pacient) {
		// TODO Auto-generated method stub
		return pacients.put(pacient.getIdentification(), pacient);
	}
	
	public Patient delete(Patient pacient) {
		return pacients.remove(pacient.getIdentification());
	}

	public void clear() {
		// TODO Auto-generated method stub
		pacients.clear();
	}

}
