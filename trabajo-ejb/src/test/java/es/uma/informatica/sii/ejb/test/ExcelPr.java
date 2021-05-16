package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.fail;

import java.io.File;

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
	
	private static final String EXCEL_EJB = "java:global/classes/ExcelEJB";
		
	@Before
	public void setup() throws NamingException  {
		
		gestionExcel = (GestionExcel) SuiteTest.ctx.lookup(EXCEL_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF1"})
	@Test
	/**
	 * En este test se comprueba que el método lee correctamente un fichero Excel e
	 * insertar los datos del mismo en el atributo de la entidad correspondiente
	 */
	public void testInsertardesdeExcel(){
		
		try {
			File f = new File("DatosAlumnadoFAKE.xlsx");
			gestionExcel.insertExcelData(f.getAbsolutePath(),"Hoja1");
			//OK
		} catch (AlumnoExistenteException e) {
			fail("Lanza AlumnoExistenteException");
		} catch(MatriculaExistenteException e) {
			fail("Lanza MatriculaExistenteException");
		} catch(ExpedientesExistenteException e) {
			fail("Lanza ExpedientesExistente");
		} catch(TrabajoException e) {
			fail("Lanza TrabajoException");
		}
	}
}