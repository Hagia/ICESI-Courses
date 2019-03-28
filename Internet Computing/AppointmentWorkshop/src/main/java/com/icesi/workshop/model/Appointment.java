package com.icesi.workshop.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Appointment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NonNull
	private Date date;
	
	@DateTimeFormat(pattern="HH:mm")
	@NonNull
	private LocalTime hour;
	
	@ManyToOne
	@NonNull
	private User patient;
	
	@ManyToOne
	@NonNull
	private User doctor;
	
	
	
}
