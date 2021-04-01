package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@Entity
public class Titulacion implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Codigo;
	
	@Column(nullable = false)
	private String Nombre;
	
	@Column(nullable = false)
	private Integer Creditos;
	
	@ManyToMany(mappedBy = "centro_titulaciones")
	private List<Centro> titulacion_centros;
	
	@OneToMany(mappedBy = "")
	private List<Asignatura> asignaturas_titulacion;

	@OneToMany(mappedBy = "titulacion")
	private List<Expedientes> expedientes_titulacion;

	private static final long serialVersionUID = 1L;
	
	public Titulacion(Integer codigo, String nombre, Integer creditos) {
		super();
		Codigo = codigo;
		Nombre = nombre;
		Creditos = creditos;
	}
	
	public Titulacion() {
		
	}

	public String getNombre() {
		return this.Nombre;
	}

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}
	
	public Integer getCreditos() {
		return this.Creditos;
	}

	public void setCreditos(Integer Creditos) {
		this.Creditos = Creditos;
	}
	
	public Integer getCodigo() {
		return this.Codigo;
	}

	public void setCodigo(Integer Codigo) {
		this.Codigo = Codigo;
	}
	
	public List<Centro> getTitulacion_centros() {
		return titulacion_centros;
	}

	public void setTitulacion_centros(List<Centro> titulacion_centros) {
		this.titulacion_centros = titulacion_centros;
	}

	public List<Asignatura> getAsignaturas_titulacion() {
		return asignaturas_titulacion;
	}

	public void setAsignaturas_titulacion(List<Asignatura> asignaturas_titulacion) {
		this.asignaturas_titulacion = asignaturas_titulacion;
	}

	public List<Expedientes> getExpedientes_titulacion() {
		return expedientes_titulacion;
	}

	public void setExpedientes_titulacion(List<Expedientes> expedientes_titulacion) {
		this.expedientes_titulacion = expedientes_titulacion;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((expedientes_titulacion == null) ? 0 : expedientes_titulacion.hashCode());
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
		Titulacion other = (Titulacion) obj;
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
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (expedientes_titulacion == null) {
			if (other.expedientes_titulacion != null)
				return false;
		} else if (!expedientes_titulacion.equals(other.expedientes_titulacion))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Titulacion [Codigo=" + Codigo + ", Nombre=" + Nombre + ", Creditos=" + Creditos
				+ ", expedientes_titulacion=" + expedientes_titulacion + "]";
	}
}