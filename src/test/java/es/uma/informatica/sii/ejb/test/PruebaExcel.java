package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.fail;

import java.sql.Date;
import java.util.Properties;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.excepciones.AlumnoExistenteExpection;
import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.ExpedientesExistenteExpection;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.MatriculaExistenteExpection;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.SolicitudDuplicadaException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.ExcelEJB;
import es.uma.informatica.ejb.tarea2.GestionExcel;
import es.uma.informatica.ejb.tarea2.GestionSolicitud;
import es.uma.informatica.jpa.tarea1.Solicitud;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class PruebaExcel{
	
	
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	
	private static final String Excel_EJB = "java:global/classes/ExcelEJB";

	private static GestionExcel gestionExcel;
	
	
	
	@Before
	public void setup() throws NamingException  {
		
		gestionExcel = (GestionExcel) SuiteTest.ctx.lookup(Excel_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF1"})
	@Test
	public void testinsertarSolicitudDuplicada() {
		ExcelEJB ex =  new ExcelEJB("/home/alumno/Escritorio/SII/Proyecto_SII-2021/DatosAlumnadoFAKE.xlsx", "Hoja1");
		
		
			try {
				ex.insertExcelData();
				fail("F");
			} catch (AlumnoExistenteExpection e) {
				//OK
			} catch(MatriculaExistenteExpection e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(ExpedientesExistenteExpection e) {
				fail("No deberia lanzar excepcion de usuario inexistente");
			}
		
		
	}
	
}
