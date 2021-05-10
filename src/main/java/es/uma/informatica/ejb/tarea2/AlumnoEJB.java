package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.MatriculaNoEncontradaException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.TitulacionNoEncontradoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Matricula;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Titulacion;

@Stateless
public class AlumnoEJB implements GestionAlumno {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	//@EJB
	//private LoginEJB LoginEJB;
	
	public AlumnoEJB() {}
	
	//mostrar todos los nombres y dni de alumnos dentro de una titulacion
	@Override
	public void MostrarTitulacionAlumno(Titulacion titu, Login login, String curso_actual) throws TitulacionNoEncontradoException, PermisosInsuficientesException, MatriculaNoEncontradaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		String str = "";

		Titulacion TituEntity = em.find(Titulacion.class, titu.getCodigoTitulacion());
		
		if (TituEntity == null) throw new TitulacionNoEncontradoException();
		
		List<Matricula> lista_mat = getListaMatricula(login);

		for(Matricula m : lista_mat) {
			
			if(m.getCurso_academico().equalsIgnoreCase(curso_actual)) 
			str += "Titulacion: " + titu + "\n" + "Nombre Alumno: " + m.getExpediente().getAlumno().getNombre_completo();
			System.out.println(str);
		}		
	}
	
	//mostrar todos los nombres y dni de alumnos dentro de una asignatura
	@Override
	public void MostrarAsignaturaAlumno(Asignatura asi, Login login, String curso_actual) throws AsignaturaNoEncontradoException, PermisosInsuficientesException, MatriculaNoEncontradaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		String str = "";
		
		Asignatura AsiEntity = em.find(Asignatura.class, asi.getReferencia());
		
		if (AsiEntity == null) throw new AsignaturaNoEncontradoException();
		
		List<Matricula> lista_mat = getListaMatricula(login);

		for(Matricula m : lista_mat) {
			
			if(m.getCurso_academico().equalsIgnoreCase(curso_actual)) 
			str += "Asignatura: " + asi + "\n" + "Nombre Alumno: " + m.getExpediente().getAlumno().getNombre_completo();
			System.out.println(str);
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> getListaMatricula(Login login) throws PermisosInsuficientesException, MatriculaNoEncontradaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
	
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		
		else {
			Query query = em.createQuery("SELECT mat FROM Matricula mat");
		
		List<Matricula> lista_matricula = query.getResultList();
	
		if(lista_matricula == null) throw new MatriculaNoEncontradaException();
	
		return lista_matricula;
		}
	}



}