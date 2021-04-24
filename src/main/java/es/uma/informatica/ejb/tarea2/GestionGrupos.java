package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Asignatura;
//import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Grupo;
import es.uma.informatica.jpa.tarea1.Login;

@Local
public interface GestionGrupos {
	
	public void aniadirSuperGrupo(Login login, Grupo sgrupo) throws TrabajoException;
	
	public void agruparGrupos(List<Grupo> gru, Asignatura asi, Login login) throws TrabajoException;
	
	public void asignarplazas(Login login, Integer nplazas, Grupo grupo) throws TrabajoException;
	
}
 