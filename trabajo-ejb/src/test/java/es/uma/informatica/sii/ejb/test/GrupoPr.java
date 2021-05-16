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

public class GrupoPr {
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String GRUPO_EJB = "java:global/classes/GrupoEJB";
	
	private GestionLogin gestionLogin;
	private GestionGrupos gestionGrupo;
		
	@Before
	public void setup() throws NamingException  {
		gestionLogin = (GestionLogin) SuiteTest.ctx.lookup(LOGIN_EJB);
		gestionGrupo = (GestionGrupos) SuiteTest.ctx.lookup(GRUPO_EJB);;
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	//FALTAN TEST + DOCUMENTACION
	
	@Requisitos({"RF5"})
	@Test
	//En este test todo va bien y se puede añadir un grupo
	public void testAniadirSuperGrupo() {
		
		try {
			Grupo gr = new Grupo(454351, "Cuarto", "F", "Mañana",  true, true, "", 40, null, null, null, null, null, null);
			gr.setTitulacion(new Titulacion(8989, "Informática", 60, null, null, null, null));
			Login l = new Login(1231213, "Manoli1", "contraseña123", false, null);
			try {
				gestionLogin.login(l);			
				gestionGrupo.aniadirSuperGrupo(l, gr);
				//OK
			} catch (PermisosInsuficientesException e) {
				fail("Lanza PermisosInsuficientesException");
			} catch (GrupoExistenteException e) {
				fail("Lanza GrupoExistenteException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}

		}catch (TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
	
	@Requisitos({"RF5"})
	@Test
	//En este test el usuario no tiene permisos suficientes y por lo tanto salta una excepción.
	public void testPermisosInsuficientes_AniadirSuperGrupo() {
				
		try {
			Grupo grupo = new Grupo(4544, "Primero", "C", "Mañana",  true, true, "", 40, null, null, null, null, null, null);
			Login l = new Login(1238873, "juju4", "contra123", true, null);
			
			try {
				gestionLogin.login(l);
				gestionGrupo.aniadirSuperGrupo(l, grupo);
				fail("Debe lanzar PermisosInsuficientesException");
			} catch (PermisosInsuficientesException e) {
				//OK
			} catch (GrupoExistenteException e) {
				fail("Lanza GrupoExistenteException");
			} catch(LoginException e) {
				fail("Lanza una excepción relacionada con el login");
			}
		}catch(TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
}