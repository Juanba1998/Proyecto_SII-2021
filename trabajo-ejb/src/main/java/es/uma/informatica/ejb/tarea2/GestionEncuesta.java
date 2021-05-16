package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Encuesta;
import es.uma.informatica.jpa.tarea1.Login;
 
@Local
public interface GestionEncuesta {
	  
	public void aniadirEncuesta(Login login, Encuesta enc) throws TrabajoException;
	
}
