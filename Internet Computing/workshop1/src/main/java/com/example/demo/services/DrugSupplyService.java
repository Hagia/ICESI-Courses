package com.example.demo.services;

import com.example.demo.model.DrugSupply;
import com.example.demo.repository.DrugSupplyRepository;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class DrugSupplyService {

	
	public DrugSupplyService() {
		re = new DrugSupplyRepository();
	}

	private DrugSupplyRepository re;
	
	public DrugSupply create(DrugSupply supply) {
		// TODO Auto-generated method stub
		DrugSupply S = re.create(supply);
		
		return  S;
	}

	public void delete(DrugSupply supply) {
		// TODO Auto-generated method stub
		
	}

	public void Find(DrugSupply supply) {
		// TODO Auto-generated method stub
		
	}

}
