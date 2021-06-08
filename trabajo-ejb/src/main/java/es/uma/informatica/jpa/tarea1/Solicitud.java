package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Solicitud implements Serializable {
 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(nullable = false)
	private String descripcion;
	
	@Column(nullable = false)
	private Date fechaSolicitud;
	
	@ManyToOne(optional = false)
	private Alumno alumno;

	public Solicitud() {
		super();
	}

	public Solicitud(Integer codigo, String descripcion, Date fechaSolicitud) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.fechaSolicitud = fechaSolicitud;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Solicitud){
        	Solicitud sol = (Solicitud) obj;
            ok = (codigo == sol.codigo) && descripcion.equalsIgnoreCase(sol.descripcion) && fechaSolicitud.equals(sol.fechaSolicitud);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return codigo.hashCode() + fechaSolicitud.hashCode() + descripcion.hashCode();
	}

	@Override
	public String toString() {
		return "Solicitud [codigo=" + codigo + ", descripcion=" + descripcion + ", fechaSolicitud=" + fechaSolicitud
				+ "]";
	}
}
