package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Asignatura implements Serializable {
	 
	@Id
	private Integer referencia; 
	
	@Column(nullable=false)
	private Integer codigo;
	
	@Column(nullable=false)
	private Integer creditos;
	
	@Column(nullable=false)
	private Integer ofertada;
	
	@Column(nullable=false)
	private String nombre;
	
	private String curso;
	private String caracter;
	private String duracion;
	private String cuatrimestre; 
	private String idiomasImparticion;
	
	@ManyToOne(optional=false)
	private Titulacion asignaturasTitulacion;
	
	@OneToMany (mappedBy="asignatura")
	private List<Clase> clase;
	
	@OneToMany (mappedBy="asignatura") 
	private List<AsignaturasMatricula> asignaturasMatricula;

	public Asignatura() {
		super();
	}

	public Asignatura(Integer referencia, Integer codigo, Integer creditos, Integer ofertada, String nombre,
			String curso, String caracter, String duracion, String cuatrimestre, String idiomasImparticion) {
		super();
		this.referencia = referencia;
		this.codigo = codigo;
		this.creditos = creditos;
		this.ofertada = ofertada;
		this.nombre = nombre;
		this.curso = curso;
		this.caracter = caracter;
		this.duracion = duracion;
		this.cuatrimestre = cuatrimestre;
		this.idiomasImparticion = idiomasImparticion;
	}

	public Integer getReferencia() {
		return referencia;
	}

	public void setReferencia(Integer referencia) {
		this.referencia = referencia;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public Integer getOfertada() {
		return ofertada;
	}

	public void setOfertada(Integer ofertada) {
		this.ofertada = ofertada;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCaracter() {
		return caracter;
	}

	public void setCaracter(String caracter) {
		this.caracter = caracter;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	public String getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(String cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public String getIdiomasImparticion() {
		return idiomasImparticion;
	}

	public void setIdiomasImparticion(String idiomasImparticion) {
		this.idiomasImparticion = idiomasImparticion;
	}

	public Titulacion getAsignaturasTitulacion() {
		return asignaturasTitulacion;
	}

	public void setAsignaturasTitulacion(Titulacion asignaturasTitulacion) {
		this.asignaturasTitulacion = asignaturasTitulacion;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

	public List<AsignaturasMatricula> getAsignaturasMatricula() {
		return asignaturasMatricula;
	}

	public void setAsignaturasMatricula(List<AsignaturasMatricula> asignaturasMatricula) {
		this.asignaturasMatricula = asignaturasMatricula;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Asignatura){
            Asignatura as = (Asignatura) obj;
            ok = (referencia == as.referencia) && (codigo == as.codigo) && (creditos == as.creditos) &&
            		ofertada == as.ofertada && nombre.equalsIgnoreCase(as.nombre);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return referencia.hashCode() + codigo.hashCode() + creditos.hashCode() + ofertada.hashCode() + nombre.hashCode();
	}

	@Override
	public String toString() {
		return "Asignatura [referencia=" + referencia + ", codigo=" + codigo + ", creditos=" + creditos + ", ofertada="
				+ ofertada + ", nombre=" + nombre + ", curso=" + curso + ", caracter=" + caracter + ", duracion="
				+ duracion + ", cuatrimestre=" + cuatrimestre + ", idiomasImparticion=" + idiomasImparticion + "]";
	}
}