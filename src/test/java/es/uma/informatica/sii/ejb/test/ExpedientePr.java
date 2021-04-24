package es.uma.informatica.sii.ejb.test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class ExpedientePr {
	private static final Logger LOG = Logger.getLogger(ExpedientePr.class.getCanonicalName());
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String EXPEDIENTES_EJB = "java:global/classes/ExpedientesEJB";
	
	private GestionLogin gestionLogin;
	private GestionExpedientes GestionExpedientes;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		GestionExpedientes = (GestionExpedientes) SuiteTest.ctx.lookup(EXPEDIENTES_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF2"})
	@Test
	//En este test se compruba en el metodo de sacar todas las notas medias
	//buscamos que no sea alumno
	public void testTodoPermisoInsuficiente() {
		Login login2 = new Login(1238630, "kaneki2", "clavesecreta", true, null);
		try {
			try {
				
				GestionExpedientes.MostrarTodasNMP(login2);
				fail("Debe lanzar la excepcion de permisos insuficientes");
			} catch(PermisosInsuficientesException e) {
				//OK
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Requisitos({"RF2"})
	@Test
	//En este test se compruba en el metodo de sacar todas las notas medias
	//buscamos funcione
	public void testTodoBien() {
		Login login1 = new Login(1231213, "Manoli1", "contraseña123", false, null);
		try {
			try {
				
				GestionExpedientes.MostrarTodasNMP(login1);
				
			} catch(PermisosInsuficientesException e) {
				fail("No debe lanzar la excepcion de permisos insuficientes");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF2"})
	@Test
	//En este test se compruba en el metodo de sacar nota media de un expedientes
	//buscamos fallo en los permisos
	
	public void testnotamediaPermiso() {
		Login login2 = new Login(1238630, "kaneki2", "clavesecreta", true, null);
		Expedientes exp1 = new Expedientes(12345, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null);
		
		try {
			try {
				
				GestionExpedientes.MostrarNMPExpediente(exp1, login2);
				fail("Debe lanzar la excepcion de permisos insuficientes");
			} catch(PermisosInsuficientesException e) {
				//OK
			}catch(ExpedienteNoEncontradoException e) {
				fail("No debe lanzar la excepcion de permisos insuficientes");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF2"})
	@Test
	//En este test se compruba en el metodo de sacar nota media de un expedientes
	//buscamos fallo en encontrar expediente
	
	public void testnotamedianoexiste() {
		Login login1 = new Login(1231213, "Manoli1", "contraseña123", false, null);
		Expedientes exp1 = new Expedientes(11111, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null);
		
		try {
			try {
				
				GestionExpedientes.MostrarNMPExpediente(exp1, login1);
				fail("debe lanzar la excepcion de permisos insuficientes");
			} catch(PermisosInsuficientesException e) {
				fail("no Debe lanzar la excepcion de permisos insuficientes");
			}catch(ExpedienteNoEncontradoException e) {
				//OK
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	@Requisitos({"RF2"})
	@Test
	//En este test se compruba en el metodo de sacar nota media de un expedientes
	//buscamos bien
	
	public void testnotamediabien() {
		Login login1 = new Login(1231213, "Manoli1", "contraseña123", false, null);
		Expedientes exp1 = new Expedientes(12345, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null);
		
		try {
			try {
				
				GestionExpedientes.MostrarNMPExpediente(exp1, login1);
			} catch(PermisosInsuficientesException e) {
				fail("no Debe lanzar la excepcion de permisos insuficientes");
			}catch(ExpedienteNoEncontradoException e) {
				fail("No debe lanzar la excepcion de permisos insuficientes");
			} 
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
	
}