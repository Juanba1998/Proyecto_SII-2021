package es.uma.informatica.sii.ejb.test; //cambiar

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashMap;
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
		
		//ALUMNO
		
		Alumno alumno1 = new Alumno (123,"27372494W", "Jose Manuel Kaneki", "josemanu@uma.es","manteca@gmail.com",123123123,321321321,
				"Calle falsa 2", "Pueblo 1","Málaga",12319, false,null,null,null);
		Alumno alumno2 = new Alumno (124,"27372494Z", "Levi Ackermann", "leviacker@uma.es","shinzou_no_sasageyo@gmail.com",123423123,319321321,
				"Calle real 3", "Pueblo 3","Málaga",12719, false,null,null,null);
		Alumno alumno3 = new Alumno (125,"27372400P", "Jujut Sukai Sen", "jujutsu@uma.es","itadori.bestoprota@hotmail.com",127892123,893783938,"Calle del amor 9",
		"Torrequebrada","Málaga",12319, true,null,null,null);
		
		for (Alumno alumnos: new Alumno [] {alumno1,alumno2,alumno3}) {
			em.persist(alumnos);
		}
		
			alumno1.setLista_Expedientes(Stream.of(exp1)
					.collect(Collectors.toSet()));
			alumno2.setLista_Expedientes(Stream.of(exp2)
					.collect(Collectors.toSet()));
			alumno3.setLista_Expedientes(Stream.of(exp3)
					.collect(Collectors.toSet()));
					
			alumno1.setLista_Solicitudes(Stream.of(solicitud1)
					.collect(Collectors.toSet()));
			alumno2.setLista_Solicitudes(Stream.of(solicitud2)
					.collect(Collectors.toSet()));
			alumno3.setLista_Solicitudes(Stream.of(solicitud3)
					.collect(Collectors.toSet()));
					
			alumno1.setLogin (login2);
			alumno1.setLogin (login3);
			alumno1.setLogin (login4);
		
		//ASIGNATURA
		
		Asignatura lengua = new Asignatura (24,223,6,40,"Lengua","Tercero","Obligatoria", "2 meses", "Primero", 
		"Español, Chino");
		Asignatura programacionDeSistemas = new Asignatura ("ref3",225,6,45,"Programación de Sistemas","Primero","Obligatoria", "4 meses", "Primero", 
		"Español");
		
		for (Asignatura asignaturas: new Asignatura [] {lengua,programacionSistemas}) {
			em.persist(asignaturas);
			
			lengua.setAsignaturas_titulacion(informatica);
			programacionDeSistemas.setAsignaturas_titulacion(software);
			/*
			lengua.setClase(Stream.of(clase1)
						.collect(Collectors.toSet()));
			programacionDeSistemas.setClase(Stream.of(clase2)
						.collect(Collectors.toSet())); */
			
			/*
			lengua.setClase(Stream.of(asignaturasMatricula1)
						.collect(Collectors.toSet()));
			programacionDeSistemas.setClase(Stream.of(AsignaturasMatricula2)
						.collect(Collectors.toSet())); */
		
		//ASIGNATURAS_MATRICULA
		
		//CENTRO
		
		Centro UMA = new Centro(323, "UMA", "Calle Universidad 4", 123456987)
		
		for (Centro centros: new Centro [] {UMA}){
			em.persist(centros);
		}
		
			UMA.setCentro_Titulaciones(Stream.of(informatica, software)
						.collect(Collectors.toSet());
		
		
		//CLASE, NO LA ENTIENDO
		
		
		
		//ENCUESTA
		
		Encuesta encuesta1 = new (Date.valueOf("2021-04-12"));
		Encuesta encuesta2 = new (Date.valueOf("2021-04-13"));
		Encuesta encuesta3 = new (Date.valueOf("2021-01-19"));
		
		for (Encuesta encuestas: new Encuesta [] {encuesta1,encuesta2,encuesta3}){
			em.persist(encuestas);
		}
		
			/*
			encuesta1.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas1)
							.collect(Collectors.toSet());
			encuesta2.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas2)
							.collect(Collectors.toSet());
			encuesta3.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas3)
							.collect(Collectors.toSet());
			*/
		
		//EXCEL ALUMNOS
		
		ExcelAlumnos ExcelAlu1
		
		//EXCEL ASIGNATURAS
		
		ExcelAlumnos ExcelSsig1
		
		//EXPEDIENTES
		
		Expedientes exp1 = new Expedientes(12345, True, 4,
			20, 10, 10, 0,0,0,0);
		Expedientes exp2 = new Expedientes(12346, True, 6,
			30, 10, 10, 6,4,0,0);
		Expedientes exp3 = new Expedientes(12347, True, 1,
			0, 0, 10, 0,0,0,0);
			
			exp1.setTitulacion(informatica);
			exp2.setTitulacion(informatica);
			exp3.setTitulacion(software);
			
			exp1.setAlumno(alumno1);
			exp2.setAlumno(alumno2);
			exp3.setAlumno(alumno3);

			for (Expedientes expedientes: new Expedientes [] {exp1,exp2,exp2}){
			em.persist(expedientes);
		}
			exp1.setEncuestas_expediente(Stream.of(encuesta1)
							.collect(Collectors.toSet());
			exp2.setEncuestas_expediente(Stream.of(encuesta2)
							.collect(Collectors.toSet());
			exp3.setEncuestas_expediente(Stream.of()
							.collect(Collectors.toSet(encuesta3));
				/*				
			exp1.setMatriculas(Stream.of(matricula1)
							.collect(Collectors.toSet());
			exp2.setMatriculas(Stream.of(matricula2)
							.collect(Collectors.toSet());
			exp3.setMatriculas(Stream.of(matriucla3)
							.collect(Collectors.toSet());
							*/
		
		
		
		//GRUPO
		
		Grupo grupo1 = new Grupo(45435, "Primero", "A", "Mañana", True, True,
			"","40");
		Grupo grupo2 = new Grupo(42335, "Primero", "A", "Mañana", False, True,
			"","60");
		Grupo grupo3 = new Grupo(45895, "Segundo", "B", "Mañana", False, True,
			"","50");
			
		for (Grupo grupos: new Grupo [] {grupo1,grupo2,grupo3}){
			em.persist(grupos);
		}
		
			grupo1.setTitulacion(informatica);
			grupo2.setTitulacion(software);
			grupo3.setTitulacion(informatica);
			
			/*
			grupo1.setClase(Stream.of(clase1)
								.collect(Collectors.toSet());
			grupo2.setClase(Stream.of(clase2)
								.collect(Collectors.toSet());
			grupo3.setClase(Stream.of(clase3)
								.collect(Collectors.toSet());
								*/
						
						/*
			grupo1.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas1)
							.collect(Collectors.toSet());
			grupo2.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas2)
							.collect(Collectors.toSet());
			grupo3.setGrupo_por_asignatura(Stream.of(grupoPorAsignaturas3)
							.collect(Collectors.toSet());
							*/
							
				/*			
			grupo1.setAsignaturas_matricula(Stream.of(matricula1)
							.collect(Collectors.toSet());
			grupo2.setAsignaturas_matricula(Stream.of(matricula2)
							.collect(Collectors.toSet());
			grupo3.setAsignaturas_matricula(Stream.of(matricula3)
							.collect(Collectors.toSet());
							*/
			
			grupo1.setGrupos_grupo(Stream.of(grupo1)
							.collect(Collectors.toSet());
			grupo2.setGrupos_grupo(Stream.of(grupo2)
							.collect(Collectors.toSet());
			grupo3.setGrupos_grupo(Stream.of(grupo3)
							.collect(Collectors.toSet());
		
			grupo1.setId_grupo(grupo1);
			grupo2.setId_grupo(grupo2);
			grupo3.setId_grupo(grupo3);
		
		//GRUPO_POR_ASIGNATURA TAMPOCO LA ENTIENDO
		
		//LOGIN
		
		Login login1 = new Login(1231213, "Manoli1", "contraseña123", 0);
		Login login2 = new Login(1238630, "kaneki2", "clavesecreta", 1);
		Login login3 = new Login(1237213, "levi3", "micontraseña", 1);
		Login login4 = new Login(1238873, "juju4", "contra123", 1);
		
		for (Login logins: new Login [] {login1,login2,login3,login4}){
			em.persist(logins);
		}
			
			login2.setAlumno(alumno1);
			login3.setAlumno(alumno2);
			login4.setAlumno(alumno3);
		
		//MATRICULA TAMPOCO LA ENTIENDO
		
		
		//OPTATIVAS
		
		Asignatura frances = new Asignatura ("ref2",224,6,50,"Francés","Primero","Optativa", "6 meses", "Segundo", 
		"Francés",30,"Sistemas de la información");
		
		for (Optativas optativas: new Optativas [] {frances}){
			em.persist(optativas);
		}
		
			frances.setAsignaturas_titulacion(informatica);
			/*
			frances.setClase(Stream.of(clase1)*/
			
			/*
			frances.setClase(Stream.of(asignaturasMatricula1)*/
		
		//SOLICITUD
		
		Solicitud solicitud1 = new Solicitud(567, "Descripcion1", Date.valueOf("2021-04-11"));
		Solicitud solicitud2 = new Solicitud(537, "Descripcion2", Date.valueOf("2021-04-14"));
		Solicitud solicitud3 = new Solicitud(569, "Descripcion3", Date.valueOf("2021-01-11"));

		for (Solicitud solicitudes: new Solicitud [] {solicitud1, solicitud2, solicitud3}){
			em.persist(solicitudes);
		}
		
		
		solicitud1.setAlumno(alumno1);
		solicitud1.setAlumno(alumno2);
		solicitud1.setAlumno(alumno3);
		
		//TITULACION
		
		Titulacion informatica = new Titulacion Titulacion(8989, "Informática", 60);
		Titulacion software = new Titulacion Titulacion(8990, "Software", 60);
		
		for (Titulacion titulaciones: new Titulacion [] {informatica, software}){
			em.persist(titulaciones);
		}

			informatica.setGrupos_grupo(Stream.of(grupo1)
							.collect(Collectors.toSet());


			
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
