package es.uma.informatica.sii.ejb.test;

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
	
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String ENCUESTA_EJB = "java:global/classes/EncuestaEJB";
	
	private GestionLogin gestionLogin;
	private GestionEncuesta gestionEncuesta;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		gestionEncuesta = (GestionEncuesta) SuiteTest.ctx.lookup(ENCUESTA_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF3"})
	@Test
	/**
	 * En este test se comprueba que se pueda
	 * insertar correctamente una encuesta a la entidad
	 */
	public void testInsertarEncuesta() {

		try {
			Encuesta enc = new Encuesta("2021-04-19 13:00",null);
			Login l = new Login(1237213, "levi3", "micontraseña", true);
			try {
				gestionLogin.login(l);
				gestionEncuesta.aniadirEncuesta(l,enc);
				//OK
			} catch (EncuestaDuplicadaException e) {
				fail("Lanza EncuestaDuplicadaException");
			} catch(PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
			
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF3"})
	@Test
	/**
	 * En este test se comprueba que el método detecte
	 * correctamente la excepcion EncuestaDuplicadaException
	 */
	public void testEncuestaDuplicadaException() {
		try {
			Encuesta enc = new Encuesta("2021-04-12 13:00",null);
			Login l = new Login(1237213, "levi3", "micontraseña", true);
			try {
				gestionLogin.login(l);
				gestionEncuesta.aniadirEncuesta(l,enc);
				fail("Debe lanzar EncuestaDuplicadaException");
			} catch (EncuestaDuplicadaException e) {
				//OK
			} catch(PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF3"})
	@Test
	/**
	 * En este test se comprueba que el personal de secretaría no puede
	 * insertar una encuesta en la base de datos
	 */
	public void testPermisosInsuficientesException_AniadirEncuesta() {
		try {
			Encuesta enc = new Encuesta("2021-04-12 13:00",null);
			Login l = new Login(1231213, "Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionEncuesta.aniadirEncuesta(l,enc);
				fail("Debe lanzar PermisosInsuficientesException");
			} catch (EncuestaDuplicadaException e) {
				fail("Lanza EncuestaDuplicadaException");
			} catch(PermisosInsuficientesException e) {
				//OK
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
}