package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Expediente;
import es.uma.informatica.jpa.tarea1.Login;

@Stateless
public class ExpedienteEJB implements GestionExpediente {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	public ExpedienteEJB() {
		super();
	}
	
	@Override
	public void mostrarTodasNotasMedias(Login login) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		List<Expediente> listaExp = getExpedientes(login);
		
		for(Expediente e : listaExp) {
			System.out.println("NumExpediente: " + e.getNumExpediente() + "; Nota Media: " + e.getNotaMediaProvisional()); 
		}		
	} 
	
	@Override
	public void mostrarUnaNotaMedia(Expediente exp, Login login) throws ExpedienteNoEncontradoException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		String str = "";
		Expediente expedienteEntity = em.find(Expediente.class, exp.getNumExpediente());
		
		if (expedienteEntity == null) throw new ExpedienteNoEncontradoException();
		
		List<Expediente> listaExp = getExpedientes(login);
		
		for(Expediente e : listaExp) {
			
			if(e.equals(expedienteEntity)) str += "NumExpediente: " + e.getNumExpediente() + "; Nota Media: " + e.getNotaMediaProvisional();
			System.out.println(str);
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Expediente> getExpedientes(Login login) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
				
		if(Boolean.TRUE.equals(login.getEsAlumno())) throw new PermisosInsuficientesException();
		
		
		Query query = em.createQuery("SELECT exp FROM Expediente exp");
		List<Expediente> listaExpedientes = query.getResultList();
		
		if(listaExpedientes == null) throw new ExpedienteNoEncontradoException();
	
		return listaExpedientes;
	}
}
