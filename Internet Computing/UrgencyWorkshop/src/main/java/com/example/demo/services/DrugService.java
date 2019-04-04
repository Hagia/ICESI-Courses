package com.example.demo.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.model.User;
import com.example.demo.repository.DrugRepository;

import lombok.NonNull;

@Service
public class DrugService {
	
	@Autowired
	private DrugRepository dr;

	public Drug find(@NonNull Drug drug) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Drug> findAll(){
		List<Drug> drugs = new ArrayList<Drug>();
		Iterator<Drug> iter = dr.findAll().iterator();
		while(iter.hasNext()) {
			drugs.add(iter.next());
		}
		
		return drugs;
	}
	
}
