package co.edu.icesi.demoestud.test;

import static org.junit.Assert.assertNotNull;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;

import co.edu.icesi.demoestud.dao.IT_Profesor;
import co.edu.icesi.demoestud.dao.T_Profesor;

@RunWith(SpringJ)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TestT_Profesor {

	@Autowired
	private IT_Profesor profesorDAO;

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void aTest() {

		assertNotNull(talumnoDao);

		TAlumno talumno = new TAlumno();
		talumno.setNombre("Jack");
		talumno.setApellidos("Bauer");

		talumnoDao.save(talumno);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void bTest() {

		assertNotNull(talumnoDao);

		T_Profesor alumno = talumnoDao.findById(2);
		assertNotNull("Code not found", alumno);
		alumno.setApellidos("JK");
		talumnoDao.update(alumno);

	}

	@Test
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void cTest() {

		assertNotNull(talumnoDao);

		TAlumno talumno = talumnoDao.findById(2);
		assertNotNull("Code not found", talumno);
		talumnoDao.delete(talumno);

	}
}
