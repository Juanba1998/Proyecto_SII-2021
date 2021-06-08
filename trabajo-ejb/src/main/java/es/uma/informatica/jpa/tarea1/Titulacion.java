package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Titulacion implements Serializable {
 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private Integer creditos;
	
	@ManyToMany
	@JoinTable(name = "TitulacionCentro",
	joinColumns = @JoinColumn(name = "titu_fk"),
	inverseJoinColumns = @JoinColumn(name = "cen_fk"))
	private List<Centro> titulacionCentros;
	
	@OneToMany(mappedBy = "asignaturasTitulacion")
	private List<Asignatura> asignaturas;

	@OneToMany(mappedBy = "titulacion")
	private List<Expediente> expedientesTitulacion;

	@OneToMany(mappedBy = "titulacion")
	private List<Grupo> grupos;

	public Titulacion() {
		super();
	}

	public Titulacion(Integer codigo, String nombre, Integer creditos) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.creditos = creditos;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCreditos() {
		return creditos;
	}

	public void setCreditos(Integer creditos) {
		this.creditos = creditos;
	}

	public List<Centro> getTitulacionCentros() {
		return titulacionCentros;
	}

	public void setTitulacionCentros(List<Centro> titulacionCentros) {
		this.titulacionCentros = titulacionCentros;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Expediente> getExpedientesTitulacion() {
		return expedientesTitulacion;
	}

	public void setExpedientesTitulacion(List<Expediente> expedientesTitulacion) {
		this.expedientesTitulacion = expedientesTitulacion;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Titulacion){
        	Titulacion titul = (Titulacion) obj;
            ok = (codigo == titul.codigo) && (creditos == titul.creditos) && nombre.equalsIgnoreCase(titul.nombre);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode() + nombre.hashCode() + creditos.hashCode();
	}

	@Override
	public String toString() {
		return "Titulacion [codigo=" + codigo + ", nombre=" + nombre + ", creditos=" + creditos
				+ "]";
	}
}