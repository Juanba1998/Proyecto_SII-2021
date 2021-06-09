package es.uma.informatica.sii.ejb.test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class AlumnoPr {
	
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
	//En este test se compruba en el metodo buscar por titulacion
	//si la titulacion buscada no existe en la base de datos
	public void testTitulacionNoEncontradoException() {
		
		try {
			Titulacion titu = new Titulacion(1111, "Informática", 60);
			String curso_actual = "2003";
			Login l = new Login(12345,"Manoli1", "contraseña123", false);
			
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarTitulacionAlumno(titu,l, curso_actual);
				fail("Debe lanzar la excepcion de Titulacion no encontrada");
			} catch (TitulacionNoEncontradoException e) {
				//OK
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(MatriculaNoEncontradaException e) {
				fail("No deberia lanzar excepcion de matricula no encontrada");
			} 
		
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	@Requisitos({"RF4"})
	@Test
	//En este test se compruba en el metodo buscar por titulacion
	//debe fallar si lo pide un alumno
	public void testPermisosInsuficientesTitulacion() {

		
		try {
			Titulacion titu = new Titulacion(8989, "Informática", 60);
			String cursoActual = "2003";
			Login l = new Login(12346,"kaneki2", "clavesecreta", true);
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarTitulacionAlumno(titu,l, cursoActual);
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
	@Ignore
	//En este test se compruba en el metodo buscar por titulacion
	//si la matricula no existe en la base de datos
	
	public void testMatriculaNoEncontradaTitulacion() {

		//Para arreglar este test hace falta crear una titulacion sin matriculas asociadas
		//MAL HECHO EL TEST
		try {
			Titulacion titu = new Titulacion(8989, "Informática", 60);
			Expediente exp1 = new Expediente(12345, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0);
			exp1.setTitulacion(titu);
			String curso_actual = "2003/2004";
			Login l = new Login(123457,"Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarTitulacionAlumno(titu,l, curso_actual);
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
	//En este test se compruba en el metodo buscar por titulacion
	//que este todo correcto
	public void testMostrarTitulacionAlumno() {

		try {
			Titulacion titu = new Titulacion(8989, "Informática", 60);
			String curso_actual = "2003";
			Login l = new Login(123458,"Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarTitulacionAlumno(titu,l, curso_actual);
				
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
	//En este test se compruba en el metodo buscar por asignatura
	//si la asignatura no existe en la base da datos
	public void testAsignaturaNoEncontradaAsignatura() {

		try {
			Asignatura asi = new Asignatura (001, 223, 6, 40, "Lengua", "Tercero", "Obligatoria",
					"2 meses", "Primero", "Español, Chino");
			Login l = new Login(123459,"Manoli1", "contraseña123", false);
			
			String curso_actual = "2003";
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarAsignaturaAlumno(asi,l, curso_actual);
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
	//En este test se compruba en el metodo buscar por asignatura
	//dara fallo si un alumno lo usa
	public void testPermisosInsuficientesAsignatura() {

		
		try {
			Asignatura asi = new Asignatura (101, 223, 6, 40, "Lengua", "Tercero", "Obligatoria",
					"2 meses", "Primero", "Español, Chino");
			String curso_actual = "2003";
			Login l = new Login(123460,"kaneki2", "clavesecreta", true);
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarAsignaturaAlumno(asi,l, curso_actual);
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
	@Ignore
	//En este test se compruba en el metodo buscar por asignatura
	//la matricula no se encuentra en la base de datos
	public void testMatriculaNoEncontradaAsignatura() {
		
		//Lo mismo que el otro test, hay que crear asignatura sin matricula asociada
		//MAL HECHO EL TEST
		
		try {
			Asignatura asi = new Asignatura (101, 223, 6, 40, "Lengua", "Tercero", "Obligatoria",
					"2 meses", "Primero", "Español, Chino");
			String curso_actual = "2003";
			Login l = new Login(123461,"Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarAsignaturaAlumno(asi,l, curso_actual);
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
	//En este test se compruba en el metodo buscar por asignatura
	//que todo este correcto
	public void testMostrarAsignaturaAlumno() {

		try {
			Asignatura asi = new Asignatura (101, 223, 6, 40, "Lengua", "Tercero", "Obligatoria",
					"2 meses", "Primero", "Español, Chino");
			String curso_actual = "2003";
			Login l = new Login(12363,"Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionAlumno.mostrarAsignaturaAlumno(asi,l, curso_actual);
				
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