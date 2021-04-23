package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.jpa.tarea1.*;

@Local
public interface GestionLogin {
	
	public void login (Login l) throws LoginException;
	
	public Login refrescarLogin (Login l) throws LoginException;

	
	

}
