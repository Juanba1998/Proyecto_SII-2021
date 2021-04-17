package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

@Local
public interface GestionNotaProvisional {
	
	public void mostrarNMP() throws TrabajoException;

}
