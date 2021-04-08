package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Asignatura implements Serializable {
	
	@Id
	private Integer Referencia; 
	
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
	private String Cuatrimestre; 
	private String IdiomasDeImparticion;
	
	@ManyToOne
	private Titulacion asignaturas_titulacion;
	
	@OneToMany (mappedBy="asignatura")
	private List<Clase> clase;
	
	@OneToMany (mappedBy="asignatura") 
	private List<Asignaturas_Matricula> asignaturas_matricula;
	
	private static final long serialVersionUID = 1L;

	public Asignatura() {
		super();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Cuatrimestre == null) ? 0 : Cuatrimestre.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Duracion == null) ? 0 : Duracion.hashCode());
		result = prime * result + ((IdiomasDeImparticion == null) ? 0 : IdiomasDeImparticion.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Ofertados == null) ? 0 : Ofertados.hashCode());
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
		if (IdiomasDeImparticion == null) {
			if (other.IdiomasDeImparticion != null)
				return false;
		} else if (!IdiomasDeImparticion.equals(other.IdiomasDeImparticion))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Ofertados == null) {
			if (other.Ofertados != null)
				return false;
		} else if (!Ofertados.equals(other.Ofertados))
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
}