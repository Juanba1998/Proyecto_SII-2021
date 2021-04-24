package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import es.uma.informatica.ejb.excepciones.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.excepciones.GrupoExistenteException;
import es.uma.informatica.ejb.excepciones.GrupoNoExistenteException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Grupo;
import es.uma.informatica.jpa.tarea1.Grupo_por_asignatura;
import es.uma.informatica.jpa.tarea1.Grupo_por_asignatura.Grupo_por_asignaturaID;
import es.uma.informatica.jpa.tarea1.Login;

@Stateless
public class GrupoEJB implements GestionGrupos {
	
	//private static final Logger LOG = Logger.getLogger(GrupoEJB.class.getCanonicalName());

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	//@EJB
	private LoginEJB LoginEJB;

	@Override
	public void aniadirSuperGrupo(Login login, Grupo sgrupo) throws TrabajoException {

		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		else {
			
			Grupo grupoExistente = em.find(Grupo.class, sgrupo.getID());
			
			if (grupoExistente != null) throw new GrupoExistenteException();
			
			em.persist(sgrupo);
		}
		
	}
	
	public void agruparGrupos(List<Grupo> gru, Asignatura asi, Login login, String curso_actual) throws AsignaturaNoEncontradoException, PermisosInsuficientesException, GrupoNoExistenteException {
		
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		else {
			
			Asignatura asignaturaExistente = em.find(Asignatura.class, asi.getReferencia());
			
			if (asignaturaExistente == null) throw new AsignaturaNoEncontradoException();
						
			for(Grupo g: gru) {
				Grupo grupoExistente = em.find(Grupo.class, g.getID());
				if (grupoExistente == null) throw new GrupoNoExistenteException();
				
			}
			
		
		}
	}
	

	@Override
	public void asignarplazas(Login login, Integer nplazas, Grupo grupo) throws TrabajoException {
		
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		else {
			
			Grupo grupoEntity = em.find(Grupo.class, grupo.getID());
			
			if (grupoEntity == null) throw new GrupoNoExistenteException();
			
			grupo.setPlazas(nplazas);
		}
	}
}