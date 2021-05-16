package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Asignatura implements Serializable {
	 
	@Id
	private Integer Referencia; 
	
	@Column(nullable=false)
	private Integer Codigo;
	
	@Column(nullable=false)
	private Integer Creditos;
	
	@Column(nullable=false)
	private Integer Ofertada;
	
	@Column(nullable=false)
	private String Nombre;
	
	private String Curso;
	private String Caracter;
	private String Duracion;
	private String Cuatrimestre; 
	private String Idiomas_de_Imparticion;
	
	@ManyToOne(optional=false)
	private Titulacion asignaturas_titulacion;
	
	@OneToMany (mappedBy="asignatura")
	private List<Clase> clase;
	
	@OneToMany (mappedBy="asignatura") 
	private List<Asignaturas_Matricula> asignaturas_matricula;

	public Asignatura() {
		super();
	}

	public Asignatura(Integer referencia, Integer codigo, Integer creditos, Integer ofertada, String nombre,
			String curso, String caracter, String duracion, String cuatrimestre, String idiomas_de_Imparticion,
			Titulacion asignaturas_titulacion, List<Clase> clase, List<Asignaturas_Matricula> asignaturas_matricula) {
		super();
		Referencia = referencia;
		Codigo = codigo;
		Creditos = creditos;
		Ofertada = ofertada;
		Nombre = nombre;
		Curso = curso;
		Caracter = caracter;
		Duracion = duracion;
		Cuatrimestre = cuatrimestre;
		Idiomas_de_Imparticion = idiomas_de_Imparticion;
		this.asignaturas_titulacion = asignaturas_titulacion;
		this.clase = clase;
		this.asignaturas_matricula = asignaturas_matricula;
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

	public Integer getOfertada() {
		return Ofertada;
	}

	public void setOfertada(Integer ofertada) {
		Ofertada = ofertada;
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

	public String getCaracter() {
		return Caracter;
	}

	public void setCaracter(String caracter) {
		Caracter = caracter;
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

	public String getIdiomas_de_Imparticion() {
		return Idiomas_de_Imparticion;
	}

	public void setIdiomas_de_Imparticion(String idiomas_de_Imparticion) {
		Idiomas_de_Imparticion = idiomas_de_Imparticion;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Caracter == null) ? 0 : Caracter.hashCode());
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Cuatrimestre == null) ? 0 : Cuatrimestre.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Duracion == null) ? 0 : Duracion.hashCode());
		result = prime * result + ((Idiomas_de_Imparticion == null) ? 0 : Idiomas_de_Imparticion.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Ofertada == null) ? 0 : Ofertada.hashCode());
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
		result = prime * result + ((asignaturas_matricula == null) ? 0 : asignaturas_matricula.hashCode());
		result = prime * result + ((asignaturas_titulacion == null) ? 0 : asignaturas_titulacion.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Asignatura other = (Asignatura) obj;
		if (Caracter == null) {
			if (other.Caracter != null)
				return false;
		} else if (!Caracter.equals(other.Caracter))
			return false;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Creditos == null) {
			if (other.Creditos != null)
				return false;
		} else if (!Creditos.equals(other.Creditos))
			return false;
		if (Cuatrimestre == null) {
			if (other.Cuatrimestre != null)
				return false;
		} else if (!Cuatrimestre.equals(other.Cuatrimestre))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (Duracion == null) {
			if (other.Duracion != null)
				return false;
		} else if (!Duracion.equals(other.Duracion))
			return false;
		if (Idiomas_de_Imparticion == null) {
			if (other.Idiomas_de_Imparticion != null)
				return false;
		} else if (!Idiomas_de_Imparticion.equals(other.Idiomas_de_Imparticion))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Ofertada == null) {
			if (other.Ofertada != null)
				return false;
		} else if (!Ofertada.equals(other.Ofertada))
			return false;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		if (asignaturas_matricula == null) {
			if (other.asignaturas_matricula != null)
				return false;
		} else if (!asignaturas_matricula.equals(other.asignaturas_matricula))
			return false;
		if (asignaturas_titulacion == null) {
			if (other.asignaturas_titulacion != null)
				return false;
		} else if (!asignaturas_titulacion.equals(other.asignaturas_titulacion))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignatura [Referencia=" + Referencia + ", Codigo=" + Codigo + ", Creditos=" + Creditos + ", Ofertada="
				+ Ofertada + ", Nombre=" + Nombre + ", Curso=" + Curso + ", Caracter=" + Caracter + ", Duracion="
				+ Duracion + ", Cuatrimestre=" + Cuatrimestre + ", Idiomas_de_Imparticion=" + Idiomas_de_Imparticion
				+ ", asignaturas_titulacion=" + asignaturas_titulacion + ", clase=" + clase + ", asignaturas_matricula="
				+ asignaturas_matricula + "]";
	}

}