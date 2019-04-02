package com.example.demo.repository;

import java.util.HashMap;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Drug;

import lombok.NonNull;

public interface DrugRepository extends CrudRepository<Drug, Long>{
	

}
