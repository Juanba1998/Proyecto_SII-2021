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
	
	public void mostrarTitulacionAlumno(Titulacion titu, Login login, String cursoActual) throws TrabajoException;
		
	public void mostrarAsignaturaAlumno(Asignatura asi, Login login, String cursoActual) throws TrabajoException;
		
	public List<Matricula> getListaMatricula(Login login) throws TrabajoException;
	
}  

	
	

