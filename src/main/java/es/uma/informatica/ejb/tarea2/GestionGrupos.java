package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Alumno;
import es.uma.informatica.jpa.tarea1.Grupo;

@Local
public interface GestionGrupos {
	
	public void agruparUno (Grupo g, Alumno a) throws TrabajoException;
	
	public void agruparGrupos (Alumno a);

}
 