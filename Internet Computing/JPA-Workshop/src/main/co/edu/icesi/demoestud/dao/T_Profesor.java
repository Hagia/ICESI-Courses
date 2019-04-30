package co.edu.icesi.demoestud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import co.edu.icesi.demoestud.model.TProfesore;

public class T_Profesor implements IT_Profesor{
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public TProfesore findById(String cedula) {
		// TODO Auto-generated method stub
		return manager.find(TProfesore.class, cedula);
	}

	@Override
	public List<TProfesore> findAll() {
		// TODO Auto-generated method stub
		String query = "Select a from TProfesore a";
		return manager.createQuery(query).getResultList();
	}

	@Override
	public void save(TProfesore profesor) {
		// TODO Auto-generated method stub
		manager.persist(profesor);
	}

	@Override
	public void edit(TProfesore profesor) {
		// TODO Auto-generated method stub
		manager.merge(profesor);
	}

	@Override
	public void delete(TProfesore profesor) {
		// TODO Auto-generated method stub
		manager.remove(profesor);
	}

}
