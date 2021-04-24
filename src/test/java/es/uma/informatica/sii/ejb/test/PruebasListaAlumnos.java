package es.uma.informatica.sii.ejb.test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class PruebasListaAlumnos {
	private static final Logger LOG = Logger.getLogger(PruebasListaAlumnos.class.getCanonicalName());
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String ALUMNO_EJB = "java:global/classes/AlumnoEJB";
	
	private GestionLogin gestionLogin;
	private GestionAlumno gestionAlumno;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		gestionAlumno = (GestionAlumno) SuiteTest.ctx.lookup(ALUMNO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF4"})
	@Test
	public void testTitulacionNoEncontradaTitulacion() {
		Titulacion titu = new Titulacion(2220, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarTitulacionAlumno(titu,new Login(222, "alvaro", "hola", true, null), curso_actual);
				fail("Debe lanzar la excepcion de Titulacion no encontrada");
			} catch (TitulacionNoEncontradoException e) {
				//OK
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testPermisosInsuficientesTitulacion() {
		Titulacion titu = new Titulacion(2220, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarTitulacionAlumno(titu,new Login(222, "alvaro", "hola", true, null), curso_actual);
				fail("Deberia lanzar excepcion de permisos insuficientes");
			} catch (TitulacionNoEncontradoException e) {
				fail("No debe lanzar la excepcion de Titulacion no encontrada");
			} catch(PermisosInsuficientesException e) {
				//OK
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testMatriculaNoEncontradaTitulacion() {
		Titulacion titu = new Titulacion(2220, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarTitulacionAlumno(titu,new Login(222, "alvaro", "hola", true, null), curso_actual);
				fail("Deberia lanzar excepcion de matricula no encontrada");
			} catch (TitulacionNoEncontradoException e) {
				fail("No debe lanzar la excepcion de Titulacion no encontrada");
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				//OK
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testMostrarTitulacionAlumno() {
		Titulacion titu = new Titulacion(2220, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarTitulacionAlumno(titu,new Login(222, "alvaro", "hola", true, null), curso_actual);
				
			} catch (TitulacionNoEncontradoException e) {
				fail("No debe lanzar la excepcion de Titulacion no encontrada");
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testAsignaturaNoEncontradaAsignatura() {
		Asignatura asi = new Asignatura(null, null, null, null, null, null, null, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarAsignaturaAlumno(asi,new Login(222, "alvaro", "hola", true, null), curso_actual);
				fail("Debe lanzar la excepcion de Asignatura no encontrada");
			} catch (AsignaturaNoEncontradoException e) {
				//OK
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testPermisosInsuficientesAsignatura() {
		Asignatura asi = new Asignatura(null, null, null, null, null, null, null, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarAsignaturaAlumno(asi,new Login(222, "alvaro", "hola", true, null), curso_actual);
				fail("Deberia lanzar excepcion de permisos insuficientes");
			} catch (AsignaturaNoEncontradoException e) {
				fail("No debe lanzar la excepcion de Asignatura no encontrada");
			} catch(PermisosInsuficientesException e) {
				//OK
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testMatriculaNoEncontradaAsignatura() {
		Asignatura asi = new Asignatura(null, null, null, null, null, null, null, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarAsignaturaAlumno(asi,new Login(222, "alvaro", "hola", true, null), curso_actual);
				fail("Deberia lanzar excepcion de matricula no encontrada");
			} catch (AsignaturaNoEncontradoException e) {
				fail("No debe lanzar la excepcion de Asignatura no encontrada");
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				//OK
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF4"})
	@Test
	public void testMostrarAsignaturaAlumno() {
		Asignatura asi = new Asignatura(null, null, null, null, null, null, null, null, null, null, null, null, null);
		String curso_actual = "2003";
		try {
			try {
				gestionAlumno.MostrarAsignaturaAlumno(asi,new Login(222, "alvaro", "hola", true, null), curso_actual);
				
			} catch (AsignaturaNoEncontradoException e) {
				fail("No debe lanzar la excepcion de Asignatura no encontrada");
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	
}