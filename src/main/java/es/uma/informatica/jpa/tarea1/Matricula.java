package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable {

	@SuppressWarnings("serial")
	public static class MatriculaId implements Serializable{
		
		private String Curso_academico;
		private Integer expediente;
	}
	   
	@Id
	private String Curso_academico;
	
	@Column(nullable = false)
	private String Estado;
	
	private Integer Num_Archivo;
	private String Turno_Preferente;
	
	@Column(nullable = false)
	private Date Fecha_de_matricula;
	
	private Boolean Nuevo_Ingreso;
	private String Listado_Asignaturas;
	private Integer Num_Expediente;
	private static final long serialVersionUID = 1L;

	@Id @ManyToOne
	private Expedientes expediente;
	
	@OneToMany (mappedBy = "matricula")
	private List<Asignaturas_Matricula> asignatura_matricula;
	
	public Matricula(String curso_academico, String estado, Integer num_Archivo, String turno_Preferente,
			Date fecha_de_matricula, Boolean nuevo_Ingreso, String listado_Asignaturas, Integer num_Expediente,
			Expedientes expediente, List<Asignaturas_Matricula> asignatura_matricula) {
		super();
		Curso_academico = curso_academico;
		Estado = estado;
		Num_Archivo = num_Archivo;
		Turno_Preferente = turno_Preferente;
		Fecha_de_matricula = fecha_de_matricula;
		Nuevo_Ingreso = nuevo_Ingreso;
		Listado_Asignaturas = listado_Asignaturas;
		Num_Expediente = num_Expediente;
		this.expediente = expediente;
		this.asignatura_matricula = asignatura_matricula;
	}
	
	public Matricula() {
		super();
	}
	
	public String getCurso_academico() {
		return Curso_academico;
	}
	
	public void setCurso_academico(String curso_academico) {
		Curso_academico = curso_academico;
	}
	
	public String getEstado() {
		return Estado;
	}
	
	public void setEstado(String estado) {
		Estado = estado;
	}
	
	public Integer getNum_Archivo() {
		return Num_Archivo;
	}
	
	public void setNum_Archivo(Integer num_Archivo) {
		Num_Archivo = num_Archivo;
	}
	
	public String getTurno_Preferente() {
		return Turno_Preferente;
	}
	
	public void setTurno_Preferente(String turno_Preferente) {
		Turno_Preferente = turno_Preferente;
	}
	
	public Date getFecha_de_matricula() {
		return Fecha_de_matricula;
	}
	
	public void setFecha_de_matricula(Date fecha_de_matricula) {
		Fecha_de_matricula = fecha_de_matricula;
	}
	
	public Boolean getNuevo_Ingreso() {
		return Nuevo_Ingreso;
	}
	
	public void setNuevo_Ingreso(Boolean nuevo_Ingreso) {
		Nuevo_Ingreso = nuevo_Ingreso;
	}
	
	public String getListado_Asignaturas() {
		return Listado_Asignaturas;
	}
	
	public void setListado_Asignaturas(String listado_Asignaturas) {
		Listado_Asignaturas = listado_Asignaturas;
	}
	
	public Integer getNum_Expediente() {
		return Num_Expediente;
	}
	
	public void setNum_Expediente(Integer num_Expediente) {
		Num_Expediente = num_Expediente;
	}
	
	public Expedientes getExpediente() {
		return expediente;
	}
	
	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}
	
	public List<Asignaturas_Matricula> getAsignatura_matricula() {
		return asignatura_matricula;
	}
	
	public void setAsignatura_matricula(List<Asignaturas_Matricula> asignatura_matricula) {
		this.asignatura_matricula = asignatura_matricula;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Curso_academico == null) ? 0 : Curso_academico.hashCode());
		result = prime * result + ((Estado == null) ? 0 : Estado.hashCode());
		result = prime * result + ((Fecha_de_matricula == null) ? 0 : Fecha_de_matricula.hashCode());
		result = prime * result + ((Listado_Asignaturas == null) ? 0 : Listado_Asignaturas.hashCode());
		result = prime * result + ((Nuevo_Ingreso == null) ? 0 : Nuevo_Ingreso.hashCode());
		result = prime * result + ((Num_Archivo == null) ? 0 : Num_Archivo.hashCode());
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
		result = prime * result + ((Turno_Preferente == null) ? 0 : Turno_Preferente.hashCode());
		result = prime * result + ((asignatura_matricula == null) ? 0 : asignatura_matricula.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
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
		Matricula other = (Matricula) obj;
		if (Curso_academico == null) {
			if (other.Curso_academico != null)
				return false;
		} else if (!Curso_academico.equals(other.Curso_academico))
			return false;
		if (Estado == null) {
			if (other.Estado != null)
				return false;
		} else if (!Estado.equals(other.Estado))
			return false;
		if (Fecha_de_matricula == null) {
			if (other.Fecha_de_matricula != null)
				return false;
		} else if (!Fecha_de_matricula.equals(other.Fecha_de_matricula))
			return false;
		if (Listado_Asignaturas == null) {
			if (other.Listado_Asignaturas != null)
				return false;
		} else if (!Listado_Asignaturas.equals(other.Listado_Asignaturas))
			return false;
		if (Nuevo_Ingreso == null) {
			if (other.Nuevo_Ingreso != null)
				return false;
		} else if (!Nuevo_Ingreso.equals(other.Nuevo_Ingreso))
			return false;
		if (Num_Archivo == null) {
			if (other.Num_Archivo != null)
				return false;
		} else if (!Num_Archivo.equals(other.Num_Archivo))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		if (Turno_Preferente == null) {
			if (other.Turno_Preferente != null)
				return false;
		} else if (!Turno_Preferente.equals(other.Turno_Preferente))
			return false;
		if (asignatura_matricula == null) {
			if (other.asignatura_matricula != null)
				return false;
		} else if (!asignatura_matricula.equals(other.asignatura_matricula))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Matricula [Curso_academico=" + Curso_academico + ", Estado=" + Estado + ", Num_Archivo=" + Num_Archivo
				+ ", Turno_Preferente=" + Turno_Preferente + ", Fecha_de_matricula=" + Fecha_de_matricula
				+ ", Nuevo_Ingreso=" + Nuevo_Ingreso + ", Listado_Asignaturas=" + Listado_Asignaturas
				+ ", Num_Expediente=" + Num_Expediente + ", expediente=" + expediente + ", asignatura_matricula="
				+ asignatura_matricula + "]";
	}
}