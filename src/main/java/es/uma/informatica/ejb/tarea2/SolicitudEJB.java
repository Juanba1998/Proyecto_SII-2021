package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import javax.ejb.EJB;
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

	@PersistenceContext(name= "trabajo")
	private EntityManager em;
	
	//@EJB
	private LoginEJB LoginEJB;
	
	public void aniadirSolicitud(Login login, Solicitud solicitud) throws PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, SolicitudDuplicadaException {
		
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == false) throw new PermisosInsuficientesException();
		else {
			
			Solicitud solicitudExistente = em.find(Solicitud.class, solicitud.getCodigo());
			
			if (solicitudExistente != null) {
				throw new SolicitudDuplicadaException();
			}
			
			solicitud.setAlumno(login.getAlumno());
			em.persist(solicitud);
		}
	}

	public void verSolicitud(Login login, Solicitud sol) throws SolicitudNoEncontradaException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		String str = "";
		Solicitud solicitudEntity = em.find(Solicitud.class, sol);
		
		if (solicitudEntity == null) throw new SolicitudNoEncontradaException();
		
		List<Solicitud> lista_sol = getSolicitudes(login);
		
		for(Solicitud s : lista_sol) {
			
			if(s.equals(solicitudEntity)) str += "Codigo: " + s.getCodigo() + "; Fecha Solicitud: " + s.getFechaSolicitud() + "\nDescripcion:\n" + s.getDescripcion();
			System.out.println(str);
		}		
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Solicitud> getSolicitudes(Login login) throws PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, SolicitudNoEncontradaException {
		

		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		
		else {
		
			Query query = em.createQuery("SELECT sol FROM Solicitud sol");
			List<Solicitud> lista_solicitudes = query.getResultList();
		
			if(lista_solicitudes == null) throw new SolicitudNoEncontradaException();
		
			return lista_solicitudes;
		}
	}
}
