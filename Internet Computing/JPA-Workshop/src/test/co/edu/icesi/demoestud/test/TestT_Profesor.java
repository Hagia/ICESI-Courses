package co.edu.icesi.demoestud.test;


import static org.junit.Assert.assertNotNull;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.demoestud.dao.IT_Profesor;
import co.edu.icesi.demoestud.model.TProfesore;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestT_Profesor {

	@Autowired
	private IT_Profesor profesorDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void aTest() {

		assertNotNull(profesorDAO);

		TProfesore tprofesor = new TProfesore();
		tprofesor.setNombre("Jack");
		tprofesor.setApellidos("Bauer");

		profesorDAO.save(tprofesor);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bTest() {

		assertNotNull(profesorDAO);

		TProfesore alumno = profesorDAO.findById("2");
		assertNotNull("Code not found", alumno);
		alumno.setApellidos("JK");
		profesorDAO.edit(alumno);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cTest() {

		assertNotNull(profesorDAO);

		TProfesore tprofesor = profesorDAO.findById("2");
		assertNotNull("Code not found", tprofesor);
		profesorDAO.delete(tprofesor);

	}
}
