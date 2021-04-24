package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.fail;

import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;


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
	
	

	
	@Requisitos({"RF1"})
	@Test

	public void testinsertarAlumnoExistente() throws TrabajoException {
		
			try {
			
				gestionExcel.insertExcelData("/home/alumno/eclipse-workspace/trabajo/Proyecto_SII-2021/DatosAlumnadoFAKE.xlsx","Hoja1");
				
				fail("F");
			} catch (AlumnoExistenteException e) {
				//OK
			} catch(MatriculaExistenteException e) {
				fail("No deberia lanzar excepcion de permisos insuficientes");
			} catch(ExpedientesExistenteException e) {
				fail("No deberia lanzar excepcion de usuario inexistente");
			}
		
		
	}
	

}
