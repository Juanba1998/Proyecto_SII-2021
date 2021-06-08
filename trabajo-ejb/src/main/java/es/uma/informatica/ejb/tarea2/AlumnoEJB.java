package es.uma.informatica.ejb.tarea2;

import java.util.List;

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
import es.uma.informatica.jpa.tarea1.Titulacion;

@Stateless
public class AlumnoEJB implements GestionAlumno {

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	//private List<Matricula> lista_mat;
	
	public AlumnoEJB() {
		super();
	}
	
	//mostrar todos los nombres y dni de alumnos dentro de una titulacion
	@Override
	public void mostrarTitulacionAlumno(Titulacion titu, Login login, String cursoActual) throws TitulacionNoEncontradoException, PermisosInsuficientesException, MatriculaNoEncontradaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		String str = "";

		Titulacion tituEntity = em.find(Titulacion.class, titu.getCodigo());
		
		if (tituEntity == null) throw new TitulacionNoEncontradoException();
		
		List<Matricula> listaMat = getListaMatricula(login);
		
		/*lista_mat = null;
		for(Expedientes e: titu.getExpedientes_titulacion()) {
			for(Matricula m : e.getMatriculas()) {
				if (m.getCurso_academico().equalsIgnoreCase(curso_actual)) lista_mat.add(m);
			}
		}*/

		for(Matricula m : listaMat) {
			
			if(m.getCursoAcademico().equalsIgnoreCase(cursoActual)) {
				str += "Titulacion: " + titu.getNombre() + "\n" + "Nombre Alumno: " + m.getExpediente().getAlumno().getNombreCompleto();
				System.out.println(str);
			}
		}		
	}
	
	//mostrar todos los nombres y dni de alumnos dentro de una asignatura
	@Override
	public void mostrarAsignaturaAlumno(Asignatura asi, Login login, String cursoActual) throws AsignaturaNoEncontradoException, PermisosInsuficientesException, MatriculaNoEncontradaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		String str = "";
		
		Asignatura asiEntity = em.find(Asignatura.class, asi.getReferencia());
		
		if (asiEntity == null) throw new AsignaturaNoEncontradoException();
		
		List<Matricula> listaMat = getListaMatricula(login);

		for(Matricula m : listaMat) {
			
			if(m.getCursoAcademico().equalsIgnoreCase(cursoActual)) {
				str += "Asignatura: " + asi.getNombre() + "\n" + "Nombre Alumno: " + m.getExpediente().getAlumno().getNombreCompleto();
				System.out.println(str);
			}
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> getListaMatricula(Login login) throws PermisosInsuficientesException, MatriculaNoEncontradaException, LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		
		if(Boolean.TRUE.equals(login.getEsAlumno())) throw new PermisosInsuficientesException();

		Query query = em.createQuery("SELECT mat FROM Matricula mat");
		List<Matricula> listaMatricula = query.getResultList();	
		if(listaMatricula == null) throw new MatriculaNoEncontradaException();
	
		return listaMatricula;
	}
}