package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Login;

/**
 * Session Bean implementation class ExpedientesEJB
 */
@Stateless
public class ExpedientesEJB implements GestionExpedientes {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	//@EJB
	//private LoginEJB LoginEJB;
	
	public void MostrarTodasNMP(Login login) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		List<Expedientes> lista_exp = getExpedientes(login);
		
		for(Expedientes e : lista_exp) {
			System.out.println("NumExpediente: " + e.getNum_Expediente() + "; Nota Media: " + e.getNota_Media_Provisional()); 
		}		
	} 
	
	public void MostrarNMPExpediente(Expedientes exp, Login login) throws ExpedienteNoEncontradoException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		String str = "";
		Expedientes expedienteEntity = em.find(Expedientes.class, exp);
		
		if (expedienteEntity == null) throw new ExpedienteNoEncontradoException();
		
		List<Expedientes> lista_exp = getExpedientes(login);
		
		for(Expedientes e : lista_exp) {
			
			if(e.equals(expedienteEntity)) str += "NumExpediente: " + e.getNum_Expediente() + "; Nota Media: " + e.getNota_Media_Provisional();
			System.out.println(str);
		}		
	}
	

	@SuppressWarnings("unchecked")
	public List<Expedientes> getExpedientes(Login login) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		

		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		
		else {
		
			Query query = em.createQuery("SELECT exp FROM Expedientes exp");
			List<Expedientes> lista_expedientes = query.getResultList();
		
			if(lista_expedientes == null) throw new ExpedienteNoEncontradoException();
		
			return lista_expedientes;
		}
	}

}
