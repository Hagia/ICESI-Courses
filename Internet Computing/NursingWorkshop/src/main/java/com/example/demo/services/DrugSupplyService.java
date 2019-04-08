package com.example.demo.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Drug;
import com.example.demo.model.DrugInventory;
import com.example.demo.model.DrugSupply;
import com.example.demo.model.Patient;
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
	private PatientService pacientsService;
	@Autowired
	private DrugInventoryService inventaryService;
	@Autowired
	private DrugSupplyRepository suppliesRepository;
	
	public DrugSupply create(DrugSupply supply) {
		return suppliesRepository.save(supply);
	}
	
	public List<DrugSupply> findAllByDate(Date date){
		List<DrugSupply> lis = new ArrayList<DrugSupply>();
		Iterator<DrugSupply> iter = suppliesRepository.findAllByDate(date).iterator();
		while(iter.hasNext()) {
			lis.add(iter.next());
		}
		return lis;
	}
}
