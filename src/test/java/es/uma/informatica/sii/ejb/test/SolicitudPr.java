package es.uma.informatica.sii.ejb.test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class SolicitudPr {
	
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String SOLICITUD_EJB = "java:global/classes/SolicitudEJB";
	
	private GestionLogin gestionLogin;
	private GestionSolicitud gestionSolicitud;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		gestionSolicitud = (GestionSolicitud) SuiteTest.ctx.lookup(SOLICITUD_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF7"})
	@Test
	//En este test se prueba la excepcion SolcitudDuplicadaException
	public void testinsertarSolicitudDuplicada() {
		
		try {
			Solicitud solicitud = new Solicitud(567,"Quiero cambiar de 3ºA al B por incompatibilidad horaria", Date.valueOf("2021-04-23"), null);
			Login l = new Login(1237213, "levi3", "micontraseña", true, null);
			try {
				gestionLogin.login(l);
				gestionSolicitud.aniadirSolicitud(l, solicitud);
				fail("Debe lanzar la excepcion de Solcictud Duplicada");
			} catch (SolicitudDuplicadaException e) {
				//OK
			} catch(PermisosInsuficientesException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(UsuarioInexistenteException e) {
				fail("No deberia lanzar excepcion de usuario inexistente");
			} catch(ContrasenaInvalidaException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			} catch(LoginException e) {
				fail("No deberia capturar LoginException");
			}
		
		}catch (TrabajoException e) {
			throw new RuntimeException(e);
		}
	}
}