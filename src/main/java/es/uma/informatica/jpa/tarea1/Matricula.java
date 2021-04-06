package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Matricula
 *
 */
@Entity
@IdClass(Matricula.MatriculaId.class)
public class Matricula implements Serializable {

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

	@Id
	@ManyToOne
	private Expedientes expediente;
	
	@OneToMany
	private List<Asignaturas_Matricula> asignatura_matricula;
	
	public Matricula(String curso_academico, String estado, Integer num_Archivo, String turno_Preferente,
			Date fecha_de_matricula, Boolean nuevo_Ingreso, String listado_Asignaturas, Integer num_Expediente) {
		super();
		Curso_academico = curso_academico;
		Estado = estado;
		Num_Archivo = num_Archivo;
		Turno_Preferente = turno_Preferente;
		Fecha_de_matricula = fecha_de_matricula;
		Nuevo_Ingreso = nuevo_Ingreso;
		Listado_Asignaturas = listado_Asignaturas;
		Num_Expediente = num_Expediente;
	}
	public Matricula() {
		
	}   
	public String getCurso_academico() {
		return this.Curso_academico;
	}

	public void setCurso_academico(String Curso_academico) {
		this.Curso_academico = Curso_academico;
	}   
	public String getEstado() {
		return this.Estado;
	}

	public void setEstado(String Estado) {
		this.Estado = Estado;
	}   
	public Integer getNum_Archivo() {
		return this.Num_Archivo;
	}

	public void setNum_Archivo(Integer Num_Archivo) {
		this.Num_Archivo = Num_Archivo;
	}   
	public String getTurno_Preferente() {
		return this.Turno_Preferente;
	}

	public void setTurno_Preferente(String Turno_Preferente) {
		this.Turno_Preferente = Turno_Preferente;
	}   
	public Date getFecha_de_matricula() {
		return this.Fecha_de_matricula;
	}

	public void setFecha_de_matricula(Date Fecha_de_matricula) {
		this.Fecha_de_matricula = Fecha_de_matricula;
	}   
	public Boolean getNuevo_Ingreso() {
		return this.Nuevo_Ingreso;
	}

	public void setNuevo_Ingreso(Boolean Nuevo_Ingreso) {
		this.Nuevo_Ingreso = Nuevo_Ingreso;
	}   
	public String getListado_Asignaturas() {
		return this.Listado_Asignaturas;
	}

	public void setListado_Asignaturas(String Listado_Asignaturas) {
		this.Listado_Asignaturas = Listado_Asignaturas;
	}   
	public Integer getNum_Expediente() {
		return this.Num_Expediente;
	}

	public void setNum_Expediente(Integer Num_Expediente) {
		this.Num_Expediente = Num_Expediente;
	}
   
}
