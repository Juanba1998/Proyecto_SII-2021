package es.uma.informatica.sii.trabajo.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.tarea1.Login;


public class BaseDeDatos {
	public static void inicializar(String unidadPersistencia) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(unidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		/* Comentar la línea de abajo si los datos se incluyen en un script de SQL */
		datos(em); 
		
		em.close();
		emf.close();
		
	}

	public static void datos(EntityManager em) {
		Login usuario = new Login();
		usuario.setCodigo(12345);
		usuario.setUsuario("Dio");
		usuario.setContrasena("123");
		usuario.setAlumno(null);
		usuario.setEsAlumno(true);
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		
	}
}
