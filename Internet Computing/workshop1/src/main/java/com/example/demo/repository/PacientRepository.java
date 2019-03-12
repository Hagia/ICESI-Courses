package com.example.demo.repository;

import java.util.HashMap;

import com.example.demo.model.Pacient;

import lombok.NonNull;

public class PacientRepository {
	
	private HashMap<String, Pacient> pacients;
	
	public PacientRepository() {
		pacients= new HashMap<>();
	}

	public Pacient find(@NonNull Pacient pacient) {
		// TODO Auto-generated method stub
		return pacients.get(pacient.getIdentification());
	}

	public Pacient create(Pacient pacient) {
		// TODO Auto-generated method stub
		return pacients.put(pacient.getIdentification(), pacient);
	}
	
	public Pacient delete(Pacient pacient) {
		return pacients.remove(pacient.getIdentification());
	}

	public void clear() {
		// TODO Auto-generated method stub
		pacients.clear();
	}

}
