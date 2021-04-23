package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Titulacion implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer CodigoTitulacion;
	
	@Column(nullable = false)
	private String Nombre;
	
	@Column(nullable = false)
	private Integer Creditos;
	
	@ManyToMany
	@JoinTable(name = "Titulacion_Centro",
	joinColumns = @JoinColumn(name = "titu_fk"),
	inverseJoinColumns = @JoinColumn(name = "cen_fk"))
	private List<Centro> titulacion_centros;
	
	@OneToMany(mappedBy = "asignaturas_titulacion")
	private List<Asignatura> asignaturas;

	@OneToMany(mappedBy = "titulacion")
	private List<Expedientes> expedientes_titulacion;

	@OneToMany(mappedBy = "titulacion")
	private List<Grupo> grupos;

	public Titulacion() {
		super();
	}

	public Titulacion(Integer codigoTitulacion, String nombre, Integer creditos, List<Centro> titulacion_centros,
			List<Asignatura> asignaturas, List<Expedientes> expedientes_titulacion, List<Grupo> grupos) {
		super();
		CodigoTitulacion = codigoTitulacion;
		Nombre = nombre;
		Creditos = creditos;
		this.titulacion_centros = titulacion_centros;
		this.asignaturas = asignaturas;
		this.expedientes_titulacion = expedientes_titulacion;
		this.grupos = grupos;
	}

	public Integer getCodigoTitulacion() {
		return CodigoTitulacion;
	}

	public void setCodigoTitulacion(Integer codigoTitulacion) {
		CodigoTitulacion = codigoTitulacion;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Integer getCreditos() {
		return Creditos;
	}

	public void setCreditos(Integer creditos) {
		Creditos = creditos;
	}

	public List<Centro> getTitulacion_centros() {
		return titulacion_centros;
	}

	public void setTitulacion_centros(List<Centro> titulacion_centros) {
		this.titulacion_centros = titulacion_centros;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Expedientes> getExpedientes_titulacion() {
		return expedientes_titulacion;
	}

	public void setExpedientes_titulacion(List<Expedientes> expedientes_titulacion) {
		this.expedientes_titulacion = expedientes_titulacion;
	}

	public List<Grupo> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodigoTitulacion == null) ? 0 : CodigoTitulacion.hashCode());
		result = prime * result + ((Creditos == null) ? 0 : Creditos.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((asignaturas == null) ? 0 : asignaturas.hashCode());
		result = prime * result + ((expedientes_titulacion == null) ? 0 : expedientes_titulacion.hashCode());
		result = prime * result + ((grupos == null) ? 0 : grupos.hashCode());
		result = prime * result + ((titulacion_centros == null) ? 0 : titulacion_centros.hashCode());
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
		if (CodigoTitulacion == null) {
			if (other.CodigoTitulacion != null)
				return false;
		} else if (!CodigoTitulacion.equals(other.CodigoTitulacion))
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
		if (asignaturas == null) {
			if (other.asignaturas != null)
				return false;
		} else if (!asignaturas.equals(other.asignaturas))
			return false;
		if (expedientes_titulacion == null) {
			if (other.expedientes_titulacion != null)
				return false;
		} else if (!expedientes_titulacion.equals(other.expedientes_titulacion))
			return false;
		if (grupos == null) {
			if (other.grupos != null)
				return false;
		} else if (!grupos.equals(other.grupos))
			return false;
		if (titulacion_centros == null) {
			if (other.titulacion_centros != null)
				return false;
		} else if (!titulacion_centros.equals(other.titulacion_centros))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Titulacion [CodigoTitulacion=" + CodigoTitulacion + ", Nombre=" + Nombre + ", Creditos=" + Creditos
				+ ", titulacion_centros=" + titulacion_centros + ", asignaturas=" + asignaturas
				+ ", expedientes_titulacion=" + expedientes_titulacion + ", grupos=" + grupos + "]";
	}

	
}