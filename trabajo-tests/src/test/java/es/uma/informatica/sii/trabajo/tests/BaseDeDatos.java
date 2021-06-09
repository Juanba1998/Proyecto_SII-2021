package es.uma.informatica.sii.trabajo.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.tarea1.Alumno;
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
		usuario.setEsAlumno(true);
		
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		
		Alumno alumno1 = new Alumno (12345,"27372494W", "Jose Manuel Kaneki", "josemanu@uma.es", "manteca@gmail.com", "123 123 123",
		"321 321 321", "Calle falsa 2", "Pueblo 1","Málaga", 12319, false);
		alumno1.setLogin(usuario);
		usuario.setAlumno(alumno1);
		
		em.getTransaction().begin();
		em.persist(alumno1);
		em.getTransaction().commit();
		
	}
}
