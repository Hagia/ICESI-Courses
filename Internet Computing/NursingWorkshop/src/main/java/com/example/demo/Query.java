package com.example.demo;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
public class Query {

	private String option;
	
	private Date date;
}
