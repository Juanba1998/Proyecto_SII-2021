package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Login;

@Local
public interface GestionExpedientes {
	
	public void MostrarTodasNMP(Login login) throws TrabajoException;
	
	public void MostrarNMPExpediente(Expedientes exp, Login login) throws TrabajoException;
	
	public List<Expedientes> getExpedientes(Login login) throws TrabajoException;
}  
