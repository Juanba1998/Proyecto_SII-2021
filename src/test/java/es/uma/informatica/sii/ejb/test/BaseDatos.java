package es.uma.informatica.sii.ejb.test;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.uma.informatica.jpa.tarea1.*;
 
public class BaseDatos {
	public static void inicializaBaseDatos(String nombreUnidadPersistencia) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(nombreUnidadPersistencia);
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		//ENCUESTA
		
		Encuesta encuesta1 = new Encuesta("2021-04-12 13:00",null,null);
		Encuesta encuesta2 = new Encuesta("2021-04-13 14:00",null,null);
		Encuesta encuesta3 = new Encuesta("2021-01-19 12:00",null,null);
						
		for (Encuesta encuestas: new Encuesta [] {encuesta1,encuesta2,encuesta3}){
			em.persist(encuestas);
		}
						
		/*encuesta1.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas1).collect(Collectors.toList()));
		encuesta2.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas2).collect(Collectors.toList()));
		encuesta3.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas3).collect(Collectors.toList()));*/
		
		//TITULACION
		
		Titulacion informatica = new Titulacion(8989, "Informática", 60, null, null, null, null);
		Titulacion software = new Titulacion(8990, "Software", 60, null, null, null, null);
		Titulacion computadores = new Titulacion(8980, "Computadores", 60, null, null, null, null);
				
		for (Titulacion titulaciones: new Titulacion [] {informatica, software, computadores}){
			em.persist(titulaciones);
		}
		
		//GRUPO
		
		Grupo grupo1 = new Grupo(45435, "Primero", "C", "Mañana",  true, true, "", 40, null, null, null, null, null, null);
		Grupo grupo2 = new Grupo(42335, "Segundo", "B", "Mañana", false, true, "", 60, null, null, null, null, null, null);
		Grupo grupo3 = new Grupo(45895, "Tercero", "A", "Mañana", false, true, "", 50, null, null, null, null, null, null);
							
		for (Grupo grupos: new Grupo [] {grupo1,grupo2,grupo3}){
			em.persist(grupos);
		}
						
		grupo1.setTitulacion(informatica);
		grupo2.setTitulacion(software);
		grupo3.setTitulacion(informatica);
							
		/*grupo1.setClase(Stream.of(clase1).collect(Collectors.toList()));
		grupo2.setClase(Stream.of(clase2).collect(Collectors.toList()));
		grupo3.setClase(Stream.of(clase3).collect(Collectors.toList());*/
										
		/*grupo1.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas1).collect(Collectors.toList()));
		grupo2.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas2).collect(Collectors.toList()));
		grupo3.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas3).collect(Collectors.toList()));*/
											
		/*grupo1.setAsignaturas_matricula(Stream.of(matricula1).collect(Collectors.toList()));
		grupo2.setAsignaturas_matricula(Stream.of(matricula2).collect(Collectors.toList()));
		grupo3.setAsignaturas_matricula(Stream.of(matricula3).collect(Collectors.toList()));*/
							
		grupo1.setGrupos_grupo(Stream.of(grupo1).collect(Collectors.toList()));
		grupo2.setGrupos_grupo(Stream.of(grupo2).collect(Collectors.toList()));
		grupo3.setGrupos_grupo(Stream.of(grupo3).collect(Collectors.toList()));
						
		grupo1.setId_grupo(grupo1);
		grupo2.setId_grupo(grupo2);
		grupo3.setId_grupo(grupo3);
		
		//Bajado de titulacion porque grupo1 no estaba declarado en ese momento
		informatica.setGrupos(Stream.of(grupo1).collect(Collectors.toList()));
		
		//ALUMNO
		
		Alumno alumno1 = new Alumno ( "27372494W", "Jose Manuel Kaneki", "josemanu@uma.es", "manteca@gmail.com", "123 123 123",
				"321 321 321", "Calle falsa 2", "Pueblo 1","Málaga", 12319, false, null, null, null, null);
				
		Alumno alumno2 = new Alumno ("27372494Z", "Levi Ackermann", "leviacker@uma.es","shinzou_no_sasageyo@gmail.com","123 423 123",
				"319 321 321", "Calle real 3", "Pueblo 3","Málaga", 12719, false, null, null, null, null);
				
		Alumno alumno3 = new Alumno ("27372400P", "Jujut Sukai Sen", "jujutsu@uma.es","itadori.bestoprota@hotmail.com","127 892 123",
				"893 783 938", "Calle del amor 9", "Torrequebrada","Málaga",12319, true,null,null,null, null);
				
		for (Alumno alumnos: new Alumno [] {alumno1,alumno2,alumno3}) {
			em.persist(alumnos);
		} 
																
		//EXPEDIENTES
		
		Expedientes exp1 = new Expedientes(12345, true, 4.0, 20.0, 10.0, 10.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null);
		Expedientes exp2 = new Expedientes(12346, true, 6.0, 30.0, 10.0, 10.0, 6.0, 4.0, 0.0, 0.0, null, null, null, null);
		Expedientes exp3 = new Expedientes(12347, true, 1.0,  0.0,  0.0, 10.0, 0.0, 0.0, 0.0, 0.0, null, null, null, null);
					
		exp1.setTitulacion(informatica);
		exp2.setTitulacion(informatica);
		exp3.setTitulacion(software);
					
		exp1.setAlumno(alumno1);
		exp2.setAlumno(alumno2);
		exp3.setAlumno(alumno3);

		for (Expedientes expedientes: new Expedientes [] {exp1,exp2,exp2}){
			em.persist(expedientes);
		}
				
		exp1.setEncuestas_expediente(Stream.of(encuesta1).collect(Collectors.toList()));
		exp2.setEncuestas_expediente(Stream.of(encuesta2).collect(Collectors.toList()));
		exp3.setEncuestas_expediente(Stream.of(encuesta3).collect(Collectors.toList()));
						
		/*exp1.setMatriculas(Stream.of(matricula1).collect(Collectors.toList()));
		exp2.setMatriculas(Stream.of(matricula2).collect(Collectors.toList()));
		exp3.setMatriculas(Stream.of(matriucla3).collect(Collectors.toList()));*/
		
		
		//Bajado de alumno porque exp1, exp2, exp3 no estaban declarados cuando se crearon los alumnos
		alumno1.setLista_expedientes(Stream.of(exp1).collect(Collectors.toList()));
		alumno2.setLista_expedientes(Stream.of(exp2).collect(Collectors.toList()));
		alumno3.setLista_expedientes(Stream.of(exp3).collect(Collectors.toList()));
		
		//SOLICITUD
		
		Solicitud solicitud1 = new Solicitud(567, "Descripcion1", Date.valueOf("2021-04-11"), null);
		Solicitud solicitud2 = new Solicitud(537, "Descripcion2", Date.valueOf("2021-04-14"), null);
		Solicitud solicitud3 = new Solicitud(569, "Descripcion3", Date.valueOf("2021-01-11"), null);

		for (Solicitud solicitudes: new Solicitud [] {solicitud1, solicitud2, solicitud3}){
			em.persist(solicitudes);
		}
		
		solicitud1.setAlumno(alumno1);
		solicitud1.setAlumno(alumno2);
		solicitud1.setAlumno(alumno3);
		
		//Bajado de alumno porque solicitud1, solicitud2, solicitud3 no estaban declarados cuando se crearon los alumnos
		alumno1.setLista_solicitudes(Stream.of(solicitud1).collect(Collectors.toList()));
		alumno2.setLista_solicitudes(Stream.of(solicitud2).collect(Collectors.toList()));
		alumno3.setLista_solicitudes(Stream.of(solicitud3).collect(Collectors.toList()));
		
		//LOGIN
		
		Login login1 = new Login(1231213, "Manoli1", "contraseña123", false, null);
		Login login2 = new Login(1238630, "kaneki2", "clavesecreta", true, null);
		Login login3 = new Login(1237213, "levi3", "micontraseña", true, null);
		Login login4 = new Login(1238873, "juju4", "contra123", true, null);
				
		for (Login logins: new Login [] {login1,login2,login3,login4}){
			em.persist(logins);
		}
					
		login2.setAlumno(alumno1);
		login3.setAlumno(alumno2);
		login4.setAlumno(alumno3);
		
		//Bajado de alumno porque login2, login3, login4 no estaban declarados cuando se crearon los alumnos
		alumno1.setLogin(login2);
		alumno2.setLogin(login3);
		alumno3.setLogin(login4);
		
		//ASIGNATURA
		
		Asignatura lengua = new Asignatura (101, 223, 6, 40, "Lengua", "Tercero", "Obligatoria",
				"2 meses", "Primero", "Español, Chino", null, null, null);
		
		Asignatura programacionDeSistemas = new Asignatura (102, 225, 6, 45, "Programación de Sistemas", "Primero", "Obligatoria",
				"4 meses", "Primero", "Español", null, null, null);
		
		for (Asignatura asignaturas: new Asignatura [] {lengua,programacionDeSistemas}) {
			em.persist(asignaturas);
			
			lengua.setAsignaturas_titulacion(informatica);
			programacionDeSistemas.setAsignaturas_titulacion(software);
			
			/*lengua.setClase(Stream.of(clase1).collect(Collectors.toList()));
			programacionDeSistemas.setClase(Stream.of(clase2).collect(Collectors.toList())); */
			
			/*
			lengua.setClase(Stream.of(asignaturasMatricula1).collect(Collectors.toList()));
			programacionDeSistemas.setClase(Stream.of(AsignaturasMatricula2).collect(Collectors.toList())); */
		}
		
		//OPTATIVAS
		
		Optativas frances = new Optativas(103, 224, 6, 50, "Francés", "Primero", "Optativa", "6 meses",
				"Segundo", "Francés",null, null, null, 30, "Sistemas de la información");
				
		for (Optativas optativas: new Optativas [] {frances}){
			em.persist(optativas);
		}
				
		frances.setAsignaturas_titulacion(informatica);
			
		/*frances.setClase(Stream.of(clase1)*/	
		/*frances.setClase(Stream.of(asignaturasMatricula1)*/
		
		//CENTRO
		
		Centro UMA = new Centro(323, "UMA", "Calle Universidad 4", 123456987);
		
		for (Centro centros: new Centro [] {UMA}){
			em.persist(centros);
		}
		
		UMA.setCentro_titulaciones(Stream.of(informatica, software).collect(Collectors.toList()));
		
		//ASIGNATURAS_MATRICULA
		
		//CLASE, NO LA ENTIENDO
		
		//GRUPO_POR_ASIGNATURA TAMPOCO LA ENTIENDO
		
		//MATRICULA TAMPOCO LA ENTIENDO
		Matricula m1 = new Matricula("2020/2021", "Finalizado", 1, "Tarde", "2021-04-22",false,"Calculo,Algebra,Estadistica,PL",exp1,null);
		Matricula m2 = new Matricula("2020/2021", "Finalizado", 2, "Tarde", "2021-04-22",false,"Calculo,Algebra,Estadistica,PL",exp2,null);
		Matricula m3 = new Matricula("2020/2021", "Finalizado", 3, "Tarde", "2021-04-22",false,"Calculo,Algebra,Estadistica,PL",exp3,null);
		
		for (Matricula mat: new Matricula[] {m1,m2,m3}){
			em.persist(mat);
		}
		
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
