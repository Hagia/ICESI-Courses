package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.*;
import com.example.demo.repository.UrgencyRepository;

@Service
public class UrgencyService {

	@Autowired
	private UrgencyRepository urgencyRepository;
	@Autowired
	private PatientService pacientService;
	@Autowired
	private DrugSupplyService supplyService;

	public Urgency create(Urgency urgency) throws Exception {
		boolean create = verifyPreconditions(urgency);

		if (!create)
			throw new Exception("Urgency does not fullfill preconditions");
		return urgencyRepository.create(urgency);

	}

	public Urgency delete(Urgency urgency) throws Exception {
		boolean delete = verifyPreconditions(urgency);

		if (!delete)
			throw new Exception("Urgency does not fullfill preconditions");
		return urgencyRepository.delete(urgency);
	}

	public Urgency find(Urgency urgency) throws Exception {
		boolean find = verifyPreconditions(urgency);

		if (!find)
			throw new Exception("Urgency does not fullfill preconditions");
		return urgencyRepository.find(urgency);
	}

	public void clear() {
		urgencyRepository.clear();
	}
	
	public boolean verifyPreconditions(Urgency urgency) {

		boolean accept = true;
		Patient pacient = pacientService.find(urgency.getPacient());
		List<DrugSupply> supplies = urgency.getSupplies();
		try {
			if(supplies != null) {
				for (DrugSupply drugSupply : supplies) {
					if (supplyService.find(drugSupply) == null) {
						accept = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			accept = false;
		}

		accept = pacient != null ? true : false;
		return accept;
	}
}
