package es.uma.informatica.ejb.tarea2;

import java.net.URI;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.UriBuilder;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;

/*Añadidos registrarUsuario a LoginEJB*/
@Stateless
public class LoginEJB implements GestionLogin{
 
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(LoginEJB.class.getCanonicalName());
	
	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	public LoginEJB() {
		super();
	}
	
	
	@Override
	public String login(Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		String type = "alumno";
		Login actual = em.find(Login.class, l.getCodigo());
		
	
		if(!(actual.getUsuario().equalsIgnoreCase(l.getUsuario()))) throw new UsuarioInexistenteException();
		
		if(!actual.getContrasena().equals(l.getContrasena())) throw new ContrasenaInvalidaException();
		
		if(!actual.getEsAlumno()){
			type = "secretaria";
		}
		
		return type;
	}
	
	@SuppressWarnings("unused")
	@Override
	public Login refrescarLogin(Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		login(l);
		Login actual = em.find(Login.class, l.getUsuario());
		em.refresh(l);
		return l;
	}

}
	