package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Solicitud implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Codigo;
	 
	@Column(nullable = false)
	private String Descripcion;
	
	@Column(nullable = false)
	private Date FechaSolicitud;
	
	@ManyToOne(optional = false)
	private Alumno alumno;

	public Solicitud() {
		super();
	}

	public Solicitud(Integer codigo, String descripcion, Date fechaSolicitud, Alumno alumno) {
		super();
		Codigo = codigo;
		Descripcion = descripcion;
		FechaSolicitud = fechaSolicitud;
		this.alumno = alumno;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public Date getFechaSolicitud() {
		return FechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		FechaSolicitud = fechaSolicitud;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Descripcion == null) ? 0 : Descripcion.hashCode());
		result = prime * result + ((FechaSolicitud == null) ? 0 : FechaSolicitud.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
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
		Solicitud other = (Solicitud) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Descripcion == null) {
			if (other.Descripcion != null)
				return false;
		} else if (!Descripcion.equals(other.Descripcion))
			return false;
		if (FechaSolicitud == null) {
			if (other.FechaSolicitud != null)
				return false;
		} else if (!FechaSolicitud.equals(other.FechaSolicitud))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Solicitud [Codigo=" + Codigo + ", Descripcion=" + Descripcion + ", FechaSolicitud=" + FechaSolicitud
				+ ", alumno=" + alumno + "]";
	}   
}
