package com.example.demo.services;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventary;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Pacient;
import com.example.demo.repository.DrugSupplyRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DrugSupplyService {

	private DrugService drugService;
	private PacientService pacientsService;
	private DrugInventaryService inventaryService;
	private DrugSupplyRepository suppliesRepository;

	public DrugSupplyService(DrugSupplyRepository reporsitory, DrugInventaryService inventary, PacientService pacients, DrugService drugs) {
		this.suppliesRepository = reporsitory;
		this.inventaryService = inventary;
		this.pacientsService = pacients;
		this.drugService = drugs;
	}

	public DrugSupply create(DrugSupply supply) throws Exception {
		// TODO Auto-generated method stub
		boolean requierementsExist = verifyRequirements(supply) && verifyAvaliableAmount(supply);

		if (!requierementsExist)
			throw new Exception("Drug supply does not fullfill requirements");

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
		DrugInventary inventary = inventaryService.find(drugSupply.getDrug());
		return inventary.getAmount() > 0;
	}
}
