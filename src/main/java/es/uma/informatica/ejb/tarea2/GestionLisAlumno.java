package es.uma.informatica.ejb.tarea2;

import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Alumno;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Titulacion;
//import es.uma.informatica.jpa.tarea1.Login;

@Local
public interface GestionLisAlumno {


		public void MostrarTodoAlumno(/*Login login*/) throws TrabajoException;
		
		public void MostrarTitulacionAlumno(Titulacion titu/*, Login login*/) throws TrabajoException;
		
		public void MostrarAsignaturaAlumno(Titulacion titu, Asignatura asi/*, Login login*/) throws TrabajoException;
		
		public List<Expedientes> getExpediente(/*Login login*/) throws TrabajoException;
	
	}  

	
	

