package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPatientDAO;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class InitService {
	
	@Autowired
	private IPatientDAO patientDAO;

}
