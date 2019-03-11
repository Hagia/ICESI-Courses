package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Pacient;
import com.example.demo.repository.PacientRepository;

import lombok.NonNull;

@Service
public class PacientService {
	
	private PacientRepository pacientRepository;
	
	public PacientService() {
		pacientRepository = new PacientRepository();
	}

	public Pacient find(@NonNull Pacient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.find(pacient);
	}

	public Pacient create(Pacient pacient) {
		// TODO Auto-generated method stub
		return pacientRepository.create(pacient);
	}

}
