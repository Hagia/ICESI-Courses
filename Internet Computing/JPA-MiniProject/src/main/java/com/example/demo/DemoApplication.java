
package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.dao.PatientDAO;
import com.example.demo.model.Patient;

import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Configuration("/applicationContext.xml")
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext ac = SpringApplication.run(DemoApplication.class, args);
		
	}
	
	public void getDAO() {
		
	}

}
