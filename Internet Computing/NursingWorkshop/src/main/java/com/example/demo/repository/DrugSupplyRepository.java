package com.example.demo.repository;

import java.util.Date;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.DrugSupply;

@Repository
public interface DrugSupplyRepository extends CrudRepository<DrugSupply, Long>{

	Iterable<DrugSupply> findAllByDate(Date date);
	
}
