package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Titulacion;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Matricula;

@Local
public interface GestionAlumno {

		
		public void MostrarTitulacionAlumno(Titulacion titu, Login login, String curso_actual) throws TrabajoException;
		
		public void MostrarAsignaturaAlumno(Asignatura asi, Login login, String curso_actual) throws TrabajoException;
		
		public List<Matricula> getListaMatricula(Login login) throws TrabajoException;
	
	}  

	
	

