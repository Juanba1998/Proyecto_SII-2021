package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;


import es.uma.informatica.ejb.excepciones.TrabajoException;

@Local
public interface GestionExcel {

	public void insertExcelData() throws TrabajoException;
	
} 
