package com.example.demo.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.UrgencyRepository;

@Service
public class UrgencyService {

	@Autowired
	private UrgencyRepository urgencyRepository;
	
	public List<Urgency> findAllByDate(Date date){
		List<Urgency> lis = new ArrayList<Urgency>();
		Iterator<Urgency> iter = urgencyRepository.findAllByDate(date).iterator();
		while(iter.hasNext()) {
			lis.add(iter.next());
		}
		return lis;
	}

}
