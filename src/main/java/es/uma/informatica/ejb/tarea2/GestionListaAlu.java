package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Titulacion;

@Local
public interface GestionListaAlu {
	/**RF-04: lista alumnos por asignatura
	 *
	  * La aplicación podrá permitir al personal de secretaría
	  * consultar alumnos por asignatura y titulacion
	  * 
	  * Pasos necesario:
	  * - Comprobar login si es de personal de secretaria
	  * - Mostrar campo de la tabla expedientes
	  * - Mostrar alumnos solo si se cumple la condicion
	  * 
	  * Necesarios tres métodos: mostrar todos, mostrar en una titulacion, mostrar en una asginatura
	  * */
	
 	public void MostrarTodosAlumnos(Login login) throws TrabajoException;
	
	public void MostrarAlumnosTitu(Expedientes exp, Login login,Titulacion titu) throws TrabajoException;
	
	public void MostrarAlumnosTituAsig(Expedientes exp, Login login,Titulacion titu, Asignatura asi) throws TrabajoException;
	
}
