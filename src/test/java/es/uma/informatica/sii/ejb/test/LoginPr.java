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

public class LoginPr {
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	
	private GestionLogin gestionLogin;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF6"})
	@Test
	//En este test, al no existir el usuario en la base de datos, debería salir una excepción.
	//NPI
	public void testUsuarioNoEncontrado() {

		try {
			Login l = new Login(1231213, "naruto4", "boruto123", true, null);		
			gestionLogin.login(l);				
			fail("Debe lanzar la excepcion de Usuario Inexistente");
		} catch (UsuarioInexistenteException e) {
			//OK
		} catch(ContrasenaInvalidaException e) {
			fail("No deberia lanzar excepcion de contraseña invalida");
		} catch (LoginException e) {
			fail("Capturada LoginException");
		}
	}
	
	@Requisitos({"RF6"})
	@Test
	//En este test, ya que la contraseña no coincide con la que hay guardada en la base de datos, debería salir una excepción.
	public void testContrasenaInvalida() {
	
			try {
				Login l = new Login(1231213, "Manoli1", "boruto123", true, null);
				gestionLogin.login(l);
				fail("Debe lanzar la excepcion de Contrasena Invalida");
			} catch (UsuarioInexistenteException e) {
				fail("No deberia lanzar excepcion de usuario inexistente");
			} catch(ContrasenaInvalidaException e) {
				//OK
			} catch (LoginException e) {
				fail("Capturada LoginException");
			}
	}
	
	@Requisitos({"RF6"})
	@Test
	//El usuario se encuentra en la base de datos, por lo que el login se realiza de forma correcta e identifica al usuario.
	public void testLoginCorrecto() {
	
			try {
				Login l = new Login(1231213, "Manoli1", "contraseña123", false, null);
				gestionLogin.login(l);
				//OK
			} catch (UsuarioInexistenteException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			} catch(ContrasenaInvalidaException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			} catch (LoginException e) {
				fail("Capturada LoginException");
			}	
	}
}
