package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;

@Local
public interface GestionSolicitud {
	
	public void aniadirSolicitud(Login login, Solicitud solicitud) throws TrabajoException;
	
	public void verSolicitud(Login login, Solicitud sol) throws TrabajoException;
	
	public List<Solicitud> getSolicitudes(Login login) throws TrabajoException;
	
}
