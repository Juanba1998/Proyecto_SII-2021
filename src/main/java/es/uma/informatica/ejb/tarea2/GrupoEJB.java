package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.AsignaturaNoEncontradoException;
import es.uma.informatica.ejb.excepciones.GrupoExistenteException;
import es.uma.informatica.ejb.excepciones.GrupoNoExistenteException;
import es.uma.informatica.ejb.excepciones.GrupoPorAsignaturaNoEncontradoException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.jpa.tarea1.Asignatura;
import es.uma.informatica.jpa.tarea1.Grupo;
import es.uma.informatica.jpa.tarea1.Grupo_por_asignatura;
import es.uma.informatica.jpa.tarea1.Login;

@Stateless
public class GrupoEJB implements GestionGrupos {
	
	//private static final Logger LOG = Logger.getLogger(GrupoEJB.class.getCanonicalName());

	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	//@EJB
	//private LoginEJB LoginEJB;

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
	
	public void agruparGrupos(Grupo g, Grupo sgrupo, Asignatura asi, Login login, String curso_actual) throws PermisosInsuficientesException, AsignaturaNoEncontradoException, GrupoNoExistenteException, GrupoPorAsignaturaNoEncontradoException  {
		
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		else {
			
			Asignatura asignaturaExistente = em.find(Asignatura.class, asi.getReferencia());
			
			if (asignaturaExistente == null) throw new AsignaturaNoEncontradoException();
						
			Grupo grupoExistente = em.find(Grupo.class, g.getID());
			if (grupoExistente == null) throw new GrupoNoExistenteException();
				
			List<Grupo_por_asignatura> lista_gpa = getGruposAsignaturas(login);
			
			for(Grupo_por_asignatura gr : lista_gpa) {
				
				if((gr.getCurso_Academico().equals(curso_actual)) && (gr.getAsignatura().equals(asi)) && (gr.getGrupo().equals(g))) {
					
					List<Grupo> grupos = sgrupo.getGrupos_grupo();
					grupos.add(g);
					sgrupo.setGrupos_grupo(grupos);
				}
			}
		}	
	}	

	@Override
	public void asignarplazas(Login login, Integer nplazas, Grupo grupo) throws PermisosInsuficientesException, GrupoNoExistenteException  {
		
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		else {
			
			Grupo grupoEntity = em.find(Grupo.class, grupo.getID());
			
			if (grupoEntity == null) throw new GrupoNoExistenteException();
			
			grupo.setPlazas(nplazas);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Grupo_por_asignatura> getGruposAsignaturas(Login login) throws PermisosInsuficientesException, GrupoPorAsignaturaNoEncontradoException {
		
		//LoginEJB.login(login);
		
		if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		
		else {
		
			Query query = em.createQuery("SELECT gpa FROM Grupo_por_asignatura gpa");
			List<Grupo_por_asignatura> lista_gasig = query.getResultList();
		
			if(lista_gasig == null) throw new GrupoPorAsignaturaNoEncontradoException();
		
			return lista_gasig;
		}
	}
}