package es.uma.informatica.ejb.tarea2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.EncuestaDuplicadaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Encuesta;
import es.uma.informatica.jpa.tarea1.Login;


@Stateless
public class EncuestaEJB implements GestionEncuesta {
  
	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	public EncuestaEJB() {
		super();
	}

	@Override
	public void aniadirEncuesta(Login login, Encuesta enc) throws PermisosInsuficientesException, EncuestaDuplicadaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		if(Boolean.FALSE.equals(login.getEsAlumno())) throw new PermisosInsuficientesException();
			
		Encuesta encuestaExistente = em.find(Encuesta.class, enc.getFechaEnvio());
			
		if (encuestaExistente != null) throw new EncuestaDuplicadaException();
		em.persist(enc);
			
	}
}
