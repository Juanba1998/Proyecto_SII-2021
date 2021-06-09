package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.*;

@Local
public interface GestionLogin {
	
	
	
	public Login refrescarLogin (Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, TrabajoException;

	void compruebaLogin(Login u) throws TrabajoException;
}
