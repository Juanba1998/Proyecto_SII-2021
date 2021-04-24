package es.uma.informatica.ejb.tarea2;

import java.util.List;

//import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.EncuestaDuplicadaException;
import es.uma.informatica.ejb.excepciones.EncuestaNoEncontradaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.PermisosInsuficientesException;
import es.uma.informatica.ejb.excepciones.SolicitudDuplicadaException;
import es.uma.informatica.ejb.excepciones.SolicitudNoEncontradaException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.Encuesta;
//import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;


@Stateless
public class EncuestaEJB implements GestionEncuesta {
 
	@PersistenceContext(name="trabajo")
	private EntityManager em;
	
	/*@EJB
	private LoginEJB LoginEJB;*/

	@Override
	public void aniadirEncuesta(/*Login login,*/Encuesta enc) throws TrabajoException {
		
		//LoginEJB.login(login);
		
		//if(login.getEsAlumno() == false) throw new PermisosInsuficientesException();
		//else {
			
			Encuesta EncuestaExistente = em.find(Encuesta.class, enc.getFecha_de_envio());
			
			if (EncuestaExistente != null) {
				throw new EncuestaDuplicadaException();
			}
			
			//enc.setExpediente(enc.getExpediente().setAlumno(login.getAlumno());
			em.persist(enc);
		//}
		
		}

	@Override
	public void verEncuesta(/*Login login,*/Encuesta enc) throws TrabajoException {
		
		String str = "";
		Encuesta encuestaEntity = em.find(Encuesta.class, enc);
		
		if (encuestaEntity == null) throw new EncuestaNoEncontradaException();
		
		List<Encuesta> lista_encuesta = getEncuesta(/*login*/);
		
		for(Encuesta s : lista_encuesta) {
			
			if(s.equals(encuestaEntity)) str += "Fecha: " + s.getFecha_de_envio() + "; Alumno: " + s.getExpediente().getAlumno().getNombre_completo() + "; DNI Alumno" + s.getExpediente().getAlumno().getDNI();
			System.out.println(str);
		}		
		
	}

	@Override
	public List<Encuesta> getEncuesta(/*Login login,*/) throws TrabajoException {
		

		//LoginEJB.login(login);
		
		//if(login.getEsAlumno() == true) throw new PermisosInsuficientesException();
		
		//else {
		
			Query query = em.createQuery("SELECT enc FROM Encuesta enc");
			@SuppressWarnings("unchecked")
			List<Encuesta> lista_encuesta = query.getResultList();
		
			if(lista_encuesta == null) throw new EncuestaNoEncontradaException();
		
			return lista_encuesta;
		//}

	}
}
