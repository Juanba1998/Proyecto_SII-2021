package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;

@Local
public interface GestionSolicitud {
	
	public void aniadirSolicitud(Login login, Solicitud solicitud) throws TrabajoException;
	
	
}
 