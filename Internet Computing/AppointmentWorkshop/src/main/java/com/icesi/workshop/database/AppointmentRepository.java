package com.icesi.workshop.database;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.icesi.workshop.model.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer>{
	
	Optional<Appointment> findById(Long id);
	
}
