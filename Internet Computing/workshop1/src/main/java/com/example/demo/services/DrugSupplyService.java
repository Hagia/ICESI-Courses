package com.example.demo.services;


import com.example.demo.model.*;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Pacient;
import com.example.demo.repository.DrugInventaryRepository;
import com.example.demo.repository.DrugSupplyRepository;

import lombok.*;

@Data
@NoArgsConstructor
public class DrugSupplyService {
	
	private DrugInventaryRepository inventariesRepository;
	
	private PacientRepository pacientsRepository;

	private DrugSupplyRepository suppliesReporsitory;
	
	private DrugRepository drugsRepository;
	
	public DrugSupplyService(DrugSupplyRepository supplies) {
		this.suppliesReporsitory = supplies;
	}
	
	public DrugSupplyService(DrugSupplyRepository reporsitory, DrugInventaryRepository inventary) {
		this.suppliesReporsitory = reporsitory;
		this.inventariesRepository = inventary;
	}
	
	public DrugSupply create(DrugSupply supply) {
		// TODO Auto-generated method stub
		Pacient pacient = pacientsRepository.find(supply.getPacient());
		Drug drug = drugsRepository.find(supply.getDrug());
		DrugInventary[] inventary = inventariesRepository.find(supply.getDrug());
		DrugSupply s = suppliesReporsitory.create(supply);
		return  s;
	}

	public DrugSupply delete(DrugSupply supply) {
		// TODO Auto-generated method stub
		return suppliesReporsitory.delete(supply);
	}

	public DrugSupply find(DrugSupply supply) {
		// TODO Auto-generated method stub
		return suppliesReporsitory.find(supply);
	}
}
