package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Asignatura
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)


public class Asignatura implements Serializable {

	@Id
	private Integer Referencia; //autogenerado?
	
	@Column(nullable=false)
	private Integer Codigo;
	@Column(nullable=false)
	private Integer Creditos;
	@Column(nullable=false)
	private Integer Ofertados;
	@Column(nullable=false)
	private String Nombre;
	
	private String Curso;
	private String Duracion;
	private String Cuatrimestre; //Pone unidad temporal, pero cuatrimastre no es un date, asi que lo he dejado en String
	private String IdiomasDeImparticion;
	
	@ManyToOne
	private Titulacion asignaturas_titulacion;
	
	@OneToMany (mappedBy="asignatura")
	private List <Clase> clase;
	@OneToMany (mappedBy="") //rellenar con asignaturas matricula
	private List <Asignaturas_Matricula> asignaturas_matricula;
	
	private static final long serialVersionUID = 1L;

	public Asignatura() {
		
	}

	public Asignatura(Integer referencia, Integer codigo, Integer creditos, Integer ofertados, String nombre,
			String curso, String duracion, String cuatrimestre, String idiomasDeImparticion) {
		super();
		Referencia = referencia;
		Codigo = codigo;
		Creditos = creditos;
		Ofertados = ofertados;
		Nombre = nombre;
		Curso = curso;
		Duracion = duracion;
		Cuatrimestre = cuatrimestre;
		IdiomasDeImparticion = idiomasDeImparticion;
	}

	public Integer getReferencia() {
		return Referencia;
	}

	public void setReferencia(Integer referencia) {
		Referencia = referencia;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public Integer getCreditos() {
		return Creditos;
	}

	public void setCreditos(Integer creditos) {
		Creditos = creditos;
	}

	public Integer getOfertados() {
		return Ofertados;
	}

	public void setOfertdos(Integer ofertados) {
		Ofertados = ofertados;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getCurso() {
		return Curso;
	}

	public void setCurso(String curso) {
		Curso = curso;
	}

	public String getDuracion() {
		return Duracion;
	}

	public void setDuracion(String duracion) {
		Duracion = duracion;
	}

	public String getCuatrimestre() {
		return Cuatrimestre;
	}

	public void setCuatrimestre(String cuatrimestre) {
		Cuatrimestre = cuatrimestre;
	}

	public String getIdiomasDeImparticion() {
		return IdiomasDeImparticion;
	}

	public void setIdiomasDeImparticion(String idiomasDeImparticion) {
		IdiomasDeImparticion = idiomasDeImparticion;
	}

	public Titulacion getAsignaturas_titulacion() {
		return asignaturas_titulacion;
	}

	public void setAsignaturas_titulacion(Titulacion asignaturas_titulacion) {
		this.asignaturas_titulacion = asignaturas_titulacion;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

	public List<Asignaturas_Matricula> getAsignaturas_matricula() {
		return asignaturas_matricula;
	}

	public void setAsignaturas_matricula(List<Asignaturas_Matricula> asignaturas_matricula) {
		this.asignaturas_matricula = asignaturas_matricula;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Asignatura [Referencia=" + Referencia + ", Codigo=" + Codigo + ", Creditos=" + Creditos + ", Ofertados="
				+ Ofertados + ", Nombre=" + Nombre + ", Curso=" + Curso + ", Duracion=" + Duracion + ", Cuatrimestre="
				+ Cuatrimestre + ", IdiomasDeImparticion=" + IdiomasDeImparticion + ", asignaturas_titulacion="
				+ asignaturas_titulacion + ", clase=" + clase + ", asignaturas_matricula=" + asignaturas_matricula
				+ "]";
	}
	
	//Generar hash y equals cuando este todo
	
	
   
}
