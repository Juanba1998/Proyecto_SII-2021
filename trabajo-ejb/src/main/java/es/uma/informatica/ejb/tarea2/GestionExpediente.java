package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Expediente;
import es.uma.informatica.jpa.tarea1.Login;

@Local
public interface GestionExpediente {
	
	public void mostrarTodasNotasMedias(Login login) throws TrabajoException;
	
	public void mostrarUnaNotaMedia(Expediente exp, Login login) throws TrabajoException;
	
	public List<Expediente> getExpedientes(Login login) throws TrabajoException;
}  
