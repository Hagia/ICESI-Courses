package com.example.demo.repository;

import java.util.HashMap;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Drug;

import lombok.NonNull;

@Repository
public interface DrugRepository extends CrudRepository<Drug, Long>{
	

}
