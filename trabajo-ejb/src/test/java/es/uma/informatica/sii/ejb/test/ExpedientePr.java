package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.fail;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class ExpedientePr {
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String EXPEDIENTE_EJB = "java:global/classes/ExpedienteEJB";
	
	private GestionLogin gestionLogin;
	private GestionExpediente gestionExpedientes;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		gestionExpedientes = (GestionExpediente) SuiteTest.ctx.lookup(EXPEDIENTE_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
		
	@Requisitos({"RF2"})
	@Test
	/**
	 * En este test se comprueba que el personal de secretaria puede
	 * consultar correctamente la nota media provisional de
	 * un expediente en específico
	 */
	public void testConsultarNMPExpediente() {

		try {
			Login l = new Login(1231213, "Manoli1", "contraseña123", false);
			Expediente exp = new Expediente(12345, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0);
			try {
				gestionLogin.login(l);
				gestionExpedientes.mostrarUnaNotaMedia(exp, l);
				//OK
			}  catch(PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch(ExpedienteNoEncontradoException e) {
				fail("Lanza ExpedienteNoEncontradoException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF2"})
	@Test
	/**
	 * En este test se comprueba que un miembro de secretaría 
	 * pueda consultar las notas medias provisionales de todos los expedientes;
	 */
	public void testConsultarTodasNMP() {

		try {
			Login l = new Login(1231213, "Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionExpedientes.mostrarTodasNotasMedias(l);
				//OK	
			} catch(PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch(ExpedienteNoEncontradoException e) {
				fail("Lanza ExpedienteNoEncontradoException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF2"})
	@Test
	/**
	 * En este test se comprueba que un alumno no puede consultar
	 * las nota media provisional de un expediente
	 * de la base de datos
	 */
	public void testPermisosInsuficientes_MostrarNMPExpediente() {
		
		try {
			Login l = new Login(1238630, "kaneki2", "clavesecreta", true);
			Expediente exp = new Expediente(12345, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0);
			
			try {
				gestionLogin.login(l);
				gestionExpedientes.mostrarUnaNotaMedia(exp, l);
				fail("Debe lanzar PermisosInsuficientesException");
			} catch(PermisosInsuficientesException e) {
				//OK
			} catch(ExpedienteNoEncontradoException e) {
				fail("Lanza ExpedienteNoEncontradoException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF2"})
	@Test
	/** En este test se comprueba que un alumno no puede consultar
	 * las notas medias provisionales de los expedientes
	 * de la base de datos
	 */
	public void testPermisosInsuficientes_MostrarTodasNMP() {
		try {
			Login l = new Login(1238630, "kaneki2", "clavesecreta", true);
			try {
				gestionLogin.login(l);
				gestionExpedientes.mostrarTodasNotasMedias(l);
				fail("Debe lanzar PermisosInsuficientesException");
			} catch(PermisosInsuficientesException e) {
				//OK
			} catch(ExpedienteNoEncontradoException e) {
				fail("Lanza ExpedienteNoEncontradoException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF2"})
	@Test
	/**
	 * En este test se comprueba que el método detecte
	 * correctamente la excepcion ExpedienteNoEncontradoException
	 * en la funcion MostrarNMPExpediente()
	 */
	public void testExpedienteNoEncontradoException_MostrarNMPExpediente() {	
		try {
			Login l = new Login(1231213, "Manoli1", "contraseña123", false);
			Expediente exp = new Expediente(11111, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0);
			try {
				gestionLogin.login(l);
				gestionExpedientes.mostrarUnaNotaMedia(exp, l);
				fail("Debe lanzar ExpedienteNoEncontradoException");
			}  catch(PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch(ExpedienteNoEncontradoException e) {
				//OK
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF2"})
	@Test
	@Ignore
	/**
	 * En este test se comprueba que el método detecte
	 * correctamente la excepcion ExpedienteNoEncontradoException
	 * en la funcion MostrarTodasNMP()
	 * No funciona el test porque la base de datos no esta vacía
	 */
	public void testExpedienteNoEncontradoException_MostrarTodasNMP() {	
		try {
			Login l = new Login(1231213, "Manoli1", "contraseña123", false);
			try {
				gestionLogin.login(l);
				gestionExpedientes.mostrarTodasNotasMedias(l);
				fail("Debe lanzar ExpedienteNoEncontradoException");
			}  catch(PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch(ExpedienteNoEncontradoException e) {
				//OK
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
}