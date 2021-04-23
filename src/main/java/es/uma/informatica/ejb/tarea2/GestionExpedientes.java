package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Expedientes;
import es.uma.informatica.jpa.tarea1.Login;

@Local
public interface GestionExpedientes {
	/**RF-02: Consultar nota media provisional
	 *
	  * La aplicación podrá permitir al personal de secretaría
	  * consultar la nota media provisional de los alumno.
	  * 
	  * Pasos necesario:
	  * - Comprobar login si es de personal de secretaria
	  * - Mostrar campo de la tabla expedientes
	  * 
	  * Necesarios dos métodos: Uno muestra una lista de notas medias provisionales y
	  * el otro la nota media provisional de un expediente en específico
	  * */
	
	public void MostrarTodasNMP(Login login) throws TrabajoException;
	
	public void MostrarNMPExpediente(Expedientes exp, Login login) throws TrabajoException;
}
