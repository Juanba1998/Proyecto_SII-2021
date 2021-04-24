package es.uma.informatica.sii.ejb.test;


//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class EncuestaPr {	
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	//private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String ENCUESTA_EJB = "java:global/classes/EncuestaEJB";
	
	//private GestionLogin gestionLogin;
	private GestionEncuesta gestionEncuesta;
		
	@Before
	public void setup() throws NamingException  {
		//gestionLogin = (GestionLogin) ctx.lookup(LOGIN_EJB);
		gestionEncuesta = (GestionEncuesta) SuiteTest.ctx.lookup(ENCUESTA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	

	@Requisitos({"RF3"})
	@Test
	public void testrealizarEncuesta() {

		
		try {
			Encuesta encuesta1 = new Encuesta("2021-04-12 13:00",null,null);
			try {
				gestionEncuesta.aniadirEncuesta(new Login(1237213, "levi3", "micontraseña", true, null),encuesta1);
				
			} catch (EncuestaDuplicadaException e) {
				fail("Debe lanzar la excepcion de Encuesta Duplicada");
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			}
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	@Requisitos({"RF3"})
	@Test
	public void testinsertarEncuestaDuplicada() {
		
		try {
			Encuesta encuesta = new Encuesta("2021-04-12 13:00",null,null);
			try {
				gestionEncuesta.aniadirEncuesta(new Login(1237213, "levi3", "micontraseña", true, null),encuesta);
				gestionEncuesta.aniadirEncuesta(new Login(1237213, "levi3", "micontraseña", true, null),encuesta);
				fail("Debe lanzar la excepcion de Encuesta Duplicada");
			} catch (EncuestaDuplicadaException e) {
				//OK
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			}
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF3"})
	@Test
	public void testPermisosInsuficientes() {
		try {
			Encuesta encuesta = new Encuesta("2021-04-12 13:00",null,null);
			try {
				gestionEncuesta.aniadirEncuesta(new Login(1231213, "Manoli1", "contraseña123", false, null),encuesta);
				
				fail("Debe lanzar la excepcion de Permisos Insuficientes");
			} catch (EncuestaDuplicadaException e) {
				fail("No deberia lanzar excepcion de encuesta duplicada");
				
			} catch(PermisosInsuficientesException e) {
				//OK
			}
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}

}