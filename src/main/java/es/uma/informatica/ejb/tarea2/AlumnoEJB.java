package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Titulacion;

/**
 * Session Bean implementation class ExpedientesEJB
 */
@Stateless
public class AlumnoEJB implements GestionListaAlu {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	@EJB
	private LoginEJB LoginEJB;
	
	public void MostrarTodosAlumnos(Login login) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		List<Expedientes> lista_exp = getExpedientes(login);
		
		for(Expedientes e : lista_exp) {
			System.out.println("DNI: " + e.getAlumno().getDNI() + "; Nombre: " + e.getAlumno().getNombre_completo()); 
		}
	}
	
	
 
	@SuppressWarnings("unchecked")
	private List<Expedientes> getExpedientes(Login login) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		

		LoginEJB.login(login);
		
		if(login.getTipo() > 0) throw new PermisosInsuficientesException();
		
		else {
		
			Query query = em.createQuery("SELECT exp FROM Expedientes exp");
			List<Expedientes> lista_expedientes = query.getResultList();
		
			if(lista_expedientes == null) throw new ExpedienteNoEncontradoException();
		
			return lista_expedientes;
		}
	}

	
	@Override
	public void MostrarAlumnosTitu(Expedientes exp, Login login, Titulacion titu) throws ExpedienteNoEncontradoException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
			
			String str = "";
			Expedientes expedienteEntity = em.find(Expedientes.class, exp);
			
			if(titu == null) throw new TitulacionNoExiste();
			
			if (expedienteEntity == null) throw new ExpedienteNoEncontradoException();
			
			List<Expedientes> lista_exp = getExpedientes(login);
			
			for(Expedientes e : lista_exp) {
				
				if(e.equals(expedienteEntity) && titu.equals(e.getTitulacion().getCodigoTitulacion())) str += "DNI: " + e.getAlumno().getDNI() + "; Nombre: " + e.getAlumno().getNombre_completo();
				System.out.println(str);
			}		
		}

	@Override
	public void MostrarAlumnosTituAsig(Expedientes exp, Login login, Titulacion titu, Asignatura asi)
			throws TrabajoException {
		// TODO Auto-generated method stub
		
	}



}
