package es.uma.informatica.ejb.tarea2;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.jpa.tarea1.*;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;

@Stateless
public class LoginEJB implements GestionLogin{
 
	
@SuppressWarnings("unused")
private static final Logger LOG = Logger.getLogger(LoginEJB.class.getCanonicalName());
	
	@PersistenceContext(name="Trabajo")
	private EntityManager em;
	
	public void login(Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		Login actual = em.find(Login.class, l.getUsuario());
		
		if(actual == null) {
			throw new UsuarioInexistenteException();
		}
		
		if(!(actual.getContrasena()==l.getContrasena())) {
			throw new ContrasenaInvalidaException();
		}
	}
	
	@SuppressWarnings("unused")
	public Login refrescarLogin(Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		login(l);
		Login actual = em.find(Login.class, l.getUsuario());
		em.refresh(l);
		return l;

	}
	
}
