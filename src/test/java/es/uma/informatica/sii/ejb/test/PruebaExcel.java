package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.fail;


import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;


import org.junit.Test;

import es.uma.informatica.ejb.excepciones.AlumnoExistenteExpection;
import es.uma.informatica.ejb.excepciones.ExpedientesExistenteExpection;
import es.uma.informatica.ejb.excepciones.MatriculaExistenteExpection;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.tarea2.GestionExcel;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class PruebaExcel{

	
	public static EJBContainer ejbContainer;
	public static Context ctx;
	


	private static GestionExcel gestionExcel;
	
	

	
	@Requisitos({"RF1"})
	@Test

	public void testinsertarAlumnoExistente() throws TrabajoException {
		
			try {
			
				gestionExcel.insertExcelData("/home/alumno/Escritorio/SII/Proyecto_SII-2021/DatosAlumnadoFAKE.xlsx","Hoja1");
				
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
