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

public class PruebasLogin {
	private static final Logger LOG = Logger.getLogger(PruebasLogin.class.getCanonicalName());
	
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	
	private GestionLogin gestionLogin;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) ctx.lookup(LOGIN_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	

	@Requisitos({"RF6"})
	@Test
	//En este test, al no existir el usuario en la base de datos, debería salir una excepción.
	public void testusuarionoencontrado() {

			try {
				Login l = new Login(123456, "naruto4", "boruto123", true, null);
				login(l)
				
			} catch (UsuarioInexistenteException e) {
				//OK
			} catch(ContrasenaInvalidaException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			}
		
		
		
	}
	
	
	@Requisitos({"RF6"})
	@Test
	//En este test, ya que la contraseña no coincide con la que hay guardada en la base de datos, debería salir una excepción.
	public void tescontraseniainvalida() {
	
			try {
				Login l = new Login(1231213, "Manoli1", "boruto123", true, null);
				login(l)
				
			} catch (UsuarioInexistenteException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			} catch(ContrasenaInvalidaException e) {
				//OK
			}
		
		
		
	}
	
	@Requisitos({"RF6"})
	@Test
	//El usuario se encuentra en la base de datos, por lo que el login se realiza de forma correcta e identifica al usuario.
	public void testlogincorrecto() {
	
			try {
				Login l = new Login(1231213, "Manoli1", "contraseña123", false, null);
				login(l)
				//OK
			} catch (UsuarioInexistenteException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			} catch(ContrasenaInvalidaException e) {
				fail("No deberia lanzar excepcion de contraseña invalida");
			}
		
		
		
	}
	
	

}
