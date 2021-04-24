package es.uma.informatica.sii.ejb.test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Date;
//import java.util.logging.Logger;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.ejb.excepciones.*;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class PruebasGrupo {
	//private static final Logger LOG = Logger.getLogger(PruebasSolicitud.class.getCanonicalName());
	
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	
	private GestionLogin gestionLogin;
	private GestionSolicitud gestionGrupo;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		gestionGrupo = (GestionGrupo) SuiteTest.ctx.lookup(GRUPO_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF5"})
	@Test
	//En este test todo va bien y se puede añadir un grupo
	public void testAniadurGrupoOK() {
		Grupo grupo1 = new Grupo(45435, "Primero", "C", "Mañana",  true, true, "", 40, null, null, null, null, null, null);
		Login login1 = new Login(1231213, "Manoli1", "contraseña123", false, null);
		
		
		try {
			gestionGrupo.aniadirSuperGrupo(login1, grupo1)
			//OK
			} catch (PermisosInsuficientesException e) {
				fail("No debe lanzar excepción de permisos insuficientes");
		
	
	}
	
	@Requisitos({"RF5"})
	@Test
	//En este test el usuario no tiene permisos suficientes y por lo tanto salta una excepción.
	public void testAniadurGrupoPermisosInsuficientes() {
		Grupo grupo1 = new Grupo(45435, "Primero", "C", "Mañana",  true, true, "", 40, null, null, null, null, null, null);
		Login login4 = new Login(1238873, "juju4", "contra123", true, null);
		
		
		try {
			gestionGrupo.aniadirSuperGrupo(login1, grupo1)
				
			} catch (PermisosInsuficientesException e) {
				fail("Debe lanzar excepción de permisos insuficientes");
				//OK
		
	
	}
	
	
}