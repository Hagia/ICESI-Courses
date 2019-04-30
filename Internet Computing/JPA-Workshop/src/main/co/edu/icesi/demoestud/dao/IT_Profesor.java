package co.edu.icesi.demoestud.dao;

import java.util.List;

import co.edu.icesi.demoestud.model.TProfesore;

public interface IT_Profesor {
	
	TProfesore findById(String cedula);
	
	List<TProfesore> findAll();
	
	void save(TProfesore profesor);
	
	void edit(TProfesore profesor);
	
	void delete(TProfesore profesor);

}
