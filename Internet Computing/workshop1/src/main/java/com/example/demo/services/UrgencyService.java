package com.example.demo.services;

import org.springframework.stereotype.Service;

import com.example.demo.model.Urgency;
import com.example.demo.repository.UrgencyRepository;

@Service
public class UrgencyService {

	private UrgencyRepository reposo;
	
	public UrgencyService(UrgencyRepository r) {
		reposo=r;
	}
	
	public Urgency Create(Urgency drug) {
		return reposo.Create(drug);

	}

	public Urgency Delete(Urgency drug) {
		return reposo.Delete(drug);
	}

	public Urgency Find(Urgency drug) {
		return reposo.Find(drug);
	}
}
