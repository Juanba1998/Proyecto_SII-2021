package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;

import es.uma.informatica.ejb.excepciones.AlumnoExistenteException;
import es.uma.informatica.ejb.excepciones.ExpedientesExistenteException;
import es.uma.informatica.ejb.excepciones.MatriculaExistenteException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.tarea2.GestionExcel;

import es.uma.informatica.sii.anotaciones.Requisitos;

public class ExcelPr{
	
	public static EJBContainer ejbContainer;
	public static Context ctx;
	


	private static GestionExcel gestionExcel;
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	
	private static final String SOLICITUD_EJB = "java:global/classes/ExcelEJB";
	
	
		
	@Before
	public void setup() throws NamingException  {
		
		gestionExcel = (GestionExcel) SuiteTest.ctx.lookup(SOLICITUD_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	

	
	@Requisitos({"RF1"})
	@Test
	
	public void testinsertarExcel() throws TrabajoException {
		
			try {
			
				gestionExcel.insertExcelData("/home/alumno/Escritorio/SII/DatosAlumnadoFAKE.xlsx","Hoja1");
				
			} catch (AlumnoExistenteException e) {
				fail("Alumno repetido");
			} catch(MatriculaExistenteException e) {
				fail("Matricula repetido");
			} catch(ExpedientesExistenteException e) {
				fail("Expediente repetido");
			}catch (NullPointerException e) {
				fail("Ruta del Excel erronea");
			}
		
		
	}
	

}
