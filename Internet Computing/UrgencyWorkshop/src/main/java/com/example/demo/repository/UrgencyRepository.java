package com.example.demo.repository;

import java.util.HashMap;

import org.springframework.stereotype.Repository;

import com.example.demo.model.DrugInventory;
import com.example.demo.model.Urgency;

@Repository
public class UrgencyRepository {
	
	private HashMap<String, Urgency> urgencies;
	
	public UrgencyRepository() {
		urgencies = new HashMap<>();
	}
	
	public Urgency create(Urgency urgency) {
		 urgencies.put(urgency.getId(), urgency);
		return urgencies.get(urgency.getId());
	}

	public Urgency delete(Urgency urgency) {
		return urgencies.remove(urgency.getId());
	}

	public Urgency find(Urgency urgency) {
		return urgencies.get(urgency.getId());
	}

	public void clear() {
		// TODO Auto-generated method stub
		urgencies.clear();
	}
	
	
}
