package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.SolicitudDuplicadaException;
import es.uma.informatica.ejb.excepciones.SolicitudNoEncontradaException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;

@Stateless
public class SolicitudEJB implements GestionSolicitud {

	@PersistenceContext(name= "TrabajoTest")
	private EntityManager em;
	
	public SolicitudEJB() {
		super();
	}
	
	public void aniadirSolicitud(Login login, Solicitud solicitud) throws SolicitudDuplicadaException, PermisosInsuficientesException {
		
		if(Boolean.FALSE.equals(login.getEsAlumno())) throw new PermisosInsuficientesException();
		else {
			
			Solicitud solicitudExistente = em.find(Solicitud.class, solicitud.getCodigo());
			
			if (solicitudExistente != null) {
				throw new SolicitudDuplicadaException();
			}
			
			solicitud.setAlumno(login.getAlumno());
			em.persist(solicitud);
		}
	}
	
	@Override
	public void verSolicitud(Login login, Solicitud sol) throws SolicitudNoEncontradaException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		String str = "";
		Solicitud solicitudEntity = em.find(Solicitud.class, sol.getCodigo());
		
		if (solicitudEntity == null) throw new SolicitudNoEncontradaException();
		
		List<Solicitud> listaSol = getSolicitudes(login);
		
		for(Solicitud s : listaSol) {
			
			if(s.equals(solicitudEntity)) str += "Codigo: " + s.getCodigo() + "; Fecha Solicitud: " + s.getFechaSolicitud() + "\nDescripcion:\n" + s.getDescripcion();
			System.out.println(str);
		}		
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Solicitud> getSolicitudes(Login login) throws PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, SolicitudNoEncontradaException {
		
		if(Boolean.TRUE.equals(login.getEsAlumno())) throw new PermisosInsuficientesException();
		
		else {
		
			Query query = em.createQuery("SELECT sol FROM Solicitud sol");
			List<Solicitud> listaSolicitudes = query.getResultList();
		
			if(listaSolicitudes == null) throw new SolicitudNoEncontradaException();
		
			return listaSolicitudes;
		}
	}
}
