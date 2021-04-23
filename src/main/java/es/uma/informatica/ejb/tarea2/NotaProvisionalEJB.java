package es.uma.informatica.ejb.tarea2;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class NotaProvisionalEJB
 */
@Stateless
public class NotaProvisionalEJB implements GestionNotaProvisional {
	
	@PersistenceContext(name="trabajo")
	//private EntityManager em;

	@Override
	public void mostrarNMP(Expedientes expedientes) throws TrabajoException {
		// TODO Auto-generated method stub
		
		
	}
	
	
}
