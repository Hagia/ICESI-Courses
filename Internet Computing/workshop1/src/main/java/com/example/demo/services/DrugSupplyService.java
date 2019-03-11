package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Pacient;
import com.example.demo.repository.DrugSupplyRepository;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@NoArgsConstructor
@Service
public class DrugSupplyService {
	
	@Autowired
	private DrugService drugService;
	@Autowired
	private PacientService pacientsService;
	@Autowired
	private DrugInventaryService inventaryService;
	@Autowired
	private DrugSupplyRepository suppliesRepository;
	
	public DrugSupplyService(DrugService drugService, PacientService pacientsService,DrugInventaryService inventaryService, DrugSupplyRepository suppliesRepository) {
		this.drugService = drugService;
		this.pacientsService = pacientsService;
		this.inventaryService = inventaryService;
		this.suppliesRepository = suppliesRepository;
	}

	public DrugSupply create(DrugSupply supply) throws Exception {
		// TODO Auto-generated method stub
		boolean requierementsExist = verifyRequirements(supply) && verifyAvaliableAmount(supply);
		if (!requierementsExist)
			throw new Exception("Drug supply does not fullfill requirements");
		DrugInventary di = inventaryService.find(supply);
		di.setAmount(di.getAmount()-1);
		inventaryService.update(di);
		return suppliesRepository.create(supply);
	}

	public DrugSupply delete(DrugSupply supply) throws Exception {
		// TODO Auto-generated method stub
		boolean requirementsExist = verifyRequirements(supply);
		if (!requirementsExist)
			throw new Exception("Drug supply does not fullfill requirements");
		return suppliesRepository.delete(supply);
	}

	public DrugSupply find(DrugSupply supply) throws Exception {
		// TODO Auto-generated method stub
		boolean requirementsExist = verifyRequirements(supply);
		if (!requirementsExist)
			throw new Exception("Drug supply does not fullfill requirements");
		return suppliesRepository.find(supply);
	}

	private boolean verifyRequirements(DrugSupply drugSupply) {
		Pacient pacient = pacientsService.find(drugSupply.getPacient());
		Drug drug = drugService.find(drugSupply.getDrug());

		boolean requierementsExist = pacient != null ? true : false && drug != null ? true : false;
		return requierementsExist;
	}

	private boolean verifyAvaliableAmount(DrugSupply drugSupply) {
		DrugInventary inventary = inventaryService.find(drugSupply);
		return inventary.getAmount() > 0;
	}
	
	public void clear() {
		suppliesRepository.clear();
	}
}
