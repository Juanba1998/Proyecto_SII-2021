package es.uma.informatica.ejb.tarea2;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.excepciones.AgruparGruposException;
import es.uma.informatica.jpa.tarea1.Alumno;
import es.uma.informatica.jpa.tarea1.Grupo;

@Stateless
public class GrupoEJB implements GestionGrupos {
	
	private static final Logger LOG = Logger.getLogger(GrupoEJB.class.getCanonicalName());

	@PersistenceContext(name="Trabajo")
	private EntityManager em;
	
	public void agruparUno (Grupo g, Alumno a) throws AgruparGruposException{
		//No existe esta entidad ya
		/*ExcelAlumnos excel = em.find (ExcelAlumnos.class, a);
		String turnoPreferente = excel.getTurno_Preferente();
		
		if (turnoPreferente.equalsIgnoreCase("Tarde")){
			Grupo grupoB = em.find(Grupo.class,); //no tengo ni idea de como elegir el grupo al que deberian ir
		}else{
			Grupo grupoA = em.find(Grupo.class,);
		}*/

	}
	
	public void agruparGrupos (Alumno a){
		
		//for (Iterator<Alumno> it = productoEntity.getAlumno().iterator(); it.hasNext();) {
			
			//}
		
	}

}
