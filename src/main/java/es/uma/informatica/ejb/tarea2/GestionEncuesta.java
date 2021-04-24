package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Encuesta;
//import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;
 
@Local
public interface GestionEncuesta {
	  
	public void aniadirEncuesta(/*Login login, */Encuesta enc) throws TrabajoException;
	
	public void verEncuesta(/*Login login,*/ Encuesta enc) throws TrabajoException;
	
	public List<Encuesta> getEncuesta(/*Login login*/) throws TrabajoException;
	
}
