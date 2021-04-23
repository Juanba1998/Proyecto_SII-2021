package es.uma.informatica.ejb.tarea2;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.SolicitudDuplicadaException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;


@Stateless
public class SolicitudEJB implements GestionSolicitud {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	@EJB
	private LoginEJB LoginEJB;

	@Override
	public void aniadirSolicitud(Login login, Solicitud solicitud) throws PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, SolicitudDuplicadaException {
		
		LoginEJB.login(login);
		
		if(login.getTipo() != 1) throw new PermisosInsuficientesException();
		else {
			
			Solicitud solicitudExistente = em.find(Solicitud.class, solicitud.getCodigo());
			
			if (solicitudExistente != null) {
				throw new SolicitudDuplicadaException();
			}
			
			solicitud.setAlumno(login.getAlumno());
			em.persist(solicitud);
		}
		
		
	}



}
