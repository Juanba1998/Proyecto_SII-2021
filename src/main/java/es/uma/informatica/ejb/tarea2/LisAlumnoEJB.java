package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.ExpedienteNoEncontradoException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.TitulacionNoEncontradoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Expedientes;
//import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Titulacion;

/**
 * Session Bean implementation class ExpedientesEJB
 */
@Stateless
public class LisAlumnoEJB implements GestionLisAlumno {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	//@EJB
	//private LoginEJB LoginEJB;
	
	//mostrar todos los nombres y dni de alumnos
	public void MostrarTodoAlumno(/*Login login*/) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException{
		
		List<Expedientes> lista_exp = getExpediente(/*login*/);
		for(Expedientes e : lista_exp) {
			System.out.println("Nombre Alumno: " + e.getAlumno().getNombre_completo() + ", DNI: " + e.getAlumno().getDNI()); 
		}		
	} 
	

	//mostrar todos los nombres y dni de alumnos dentro de una titulacion
	public void MostrarTitulacionAlumno(Titulacion titu/*, Login login*/) throws ExpedienteNoEncontradoException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, TitulacionNoEncontradoException{
		
		String str = "";

		Titulacion TituEntity = em.find(Titulacion.class, titu);
		
		if (TituEntity == null) throw new TitulacionNoEncontradoException();
		
		List<Expedientes> lista_exp = getExpediente(/*login*/);

		for(Expedientes e : lista_exp) {
			
			if(e.getTitulacion().equals(TituEntity)) str += "Nombre Alumno: " + e.getAlumno().getNombre_completo() + ", DNI: " + e.getAlumno().getDNI();
			System.out.println(str);
		}		
	}
	


	//mostrar todos los nombres y dni de alumnos dentro de una asignatura
	public void MostrarAsignaturaAlumno(Titulacion titu, Asignatura asi)  throws ExpedienteNoEncontradoException, PermisosInsuficientesException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, TitulacionNoEncontradoException, AsignaturaNoEncontradoException{
		
		String str = "";

		Titulacion TituEntity = em.find(Titulacion.class, titu);
		Asignatura AsiEntity = em.find(Asignatura.class, asi);
		
		if (TituEntity == null) throw new TitulacionNoEncontradoException();
		if (AsiEntity == null) throw new AsignaturaNoEncontradoException();
		
		List<Expedientes> lista_exp = getExpediente(/*login*/);

		for(Expedientes e : lista_exp) {
			
			if(e.getTitulacion().equals(TituEntity) && e.getTitulacion().equals(AsiEntity.getAsignaturas_titulacion())) str += "Nombre Alumno: " + e.getAlumno().getNombre_completo() + ", DNI: " + e.getAlumno().getDNI();
			System.out.println(str);
		}		
	}



	@SuppressWarnings("unchecked")
	public List<Expedientes> getExpediente(/*Login login*/) throws PermisosInsuficientesException, ExpedienteNoEncontradoException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		

		//LoginEJB.login(login);
		
		//if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		
	//	else {
		 
			Query query = em.createQuery("SELECT exp FROM Expedientes exp");
			List<Expedientes> lista_expedientes = query.getResultList();
		
			if(lista_expedientes == null) throw new ExpedienteNoEncontradoException();
		
			return lista_expedientes;
		//}
	}



}
