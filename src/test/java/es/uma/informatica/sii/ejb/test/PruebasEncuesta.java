package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.assertEquals;
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

public class PruebasEncuesta {
	private static final Logger LOG = Logger.getLogger(PruebasEncuesta.class.getCanonicalName());
	
	
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
			Encuesta encuesta1 = new Encuesta();
			Encuesta encuesta2 = new Encuesta();
			try {
				gestionEncuesta.aniadirEncuesta(new Login(123456, "antonio", "aceite", true, null),encuesta1);
				gestionEncuesta.aniadirEncuesta(new Login(111111, "aaaaaaa", "acenoa", true, null),encuesta2);
				
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
			Encuesta encuesta = new Encuesta();
			try {
				gestionEncuesta.aniadirEncuesta(new Login(123456, "antonio", "aceite", true, null),encuesta);
				gestionEncuesta.aniadirEncuesta(new Login(111111, "aaaaaaa", "acenoa", true, null),encuesta);
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
			Encuesta encuesta = new Encuesta();
			try {
				gestionEncuesta.aniadirEncuesta(new Login(123456, "antonio", "aceite", false, null),encuesta);
				
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