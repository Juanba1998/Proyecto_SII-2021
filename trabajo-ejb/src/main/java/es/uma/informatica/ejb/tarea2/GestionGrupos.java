package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import java.util.List;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Asignatura;
//import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Grupo;
import es.uma.informatica.jpa.tarea1.Grupo_por_asignatura;
import es.uma.informatica.jpa.tarea1.Login;

@Local
public interface GestionGrupos {
	
	public void aniadirSuperGrupo(Login login, Grupo sgrupo) throws TrabajoException;
	
	public void agruparGrupos(Grupo grupo, Grupo sgrupo, Asignatura asi, Login login,  String curso_actual) throws TrabajoException;
	
	public void asignarplazas(Login login, Integer nplazas, Grupo grupo) throws TrabajoException;
	
	public List<Grupo_por_asignatura> getGruposAsignaturas(Login login) throws TrabajoException;
}
 