package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@IdClass(Matricula.MatriculaID.class)
@SuppressWarnings("serial")
public class Matricula implements Serializable {

	public static class MatriculaID implements Serializable{
		
		private String cursoAcademico;
		private Integer expediente;
		
		public MatriculaID() {
			super();
		}
		
		public MatriculaID(String cursoAcademico, Integer expediente) {
			this.cursoAcademico = cursoAcademico;
			this.expediente = expediente;
		}
			
		public String getCursoAcademico() {
			return cursoAcademico;
		}

		public void setCursoAcademico(String cursoAcademico) {
			this.cursoAcademico = cursoAcademico;
		}

		public Integer getExpediente() {
			return expediente;
		}

		public void setExpediente(Integer expediente) {
			this.expediente = expediente;
		}
		
		@Override
		public boolean equals(Object obj) {
			boolean ok = false;
			
	        if(obj instanceof MatriculaID){
	        	MatriculaID matrid = (MatriculaID) obj;
	            ok = cursoAcademico.equalsIgnoreCase(matrid.cursoAcademico) && (expediente == matrid.expediente);
	        }
	        
	        return ok;
		}
		
		@Override
		public int hashCode() {
			return cursoAcademico.hashCode() + expediente.hashCode();
		}

		@Override
		public String toString() {
			return "MatriculaID [cursoAcademico=" + cursoAcademico + ", expediente=" + expediente + "]";
		}
	}
	   
	@Id
	private String cursoAcademico;
	
	private String estado;
	private Integer numArchivo;
	private String turnoPreferente;
	
	@Column(nullable = false)
	private String fechaMatricula;
	
	private Boolean nuevoIngreso;
	
	private String listadoAsignaturas;

	@Id
	@ManyToOne(optional=false, cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private Expediente expediente;
	
	@OneToMany (mappedBy = "matricula")
	private List<AsignaturasMatricula> asignaturasMatricula;

	public Matricula() {
		super();
	}

	public Matricula(String cursoAcademico, String estado, Integer numArchivo, String turnoPreferente,
			String fechaMatricula, Boolean nuevoIngreso, String listadoAsignaturas) {
		super();
		this.cursoAcademico = cursoAcademico;
		this.estado = estado;
		this.numArchivo = numArchivo;
		this.turnoPreferente = turnoPreferente;
		this.fechaMatricula = fechaMatricula;
		this.nuevoIngreso = nuevoIngreso;
		this.listadoAsignaturas = listadoAsignaturas;
	}

	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Integer getNumArchivo() {
		return numArchivo;
	}

	public void setNumArchivo(Integer numArchivo) {
		this.numArchivo = numArchivo;
	}

	public String getTurnoPreferente() {
		return turnoPreferente;
	}

	public void setTurnoPreferente(String turnoPreferente) {
		this.turnoPreferente = turnoPreferente;
	}

	public String getFechaMatricula() {
		return fechaMatricula;
	}

	public void setFechaMatricula(String fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}

	public Boolean getNuevoIngreso() {
		return nuevoIngreso;
	}

	public void setNuevoIngreso(Boolean nuevoIngreso) {
		this.nuevoIngreso = nuevoIngreso;
	}

	public String getListadoAsignaturas() {
		return listadoAsignaturas;
	}

	public void setListadoAsignaturas(String listadoAsignaturas) {
		this.listadoAsignaturas = listadoAsignaturas;
	}

	public Expediente getExpediente() {
		return expediente;
	}

	public void setExpediente(Expediente expediente) {
		this.expediente = expediente;
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
		
        if(obj instanceof Matricula){
        	Matricula matr = (Matricula) obj;
            ok = cursoAcademico.equalsIgnoreCase(matr.cursoAcademico) && expediente.equals(matr.expediente)
            		&& fechaMatricula.equalsIgnoreCase(matr.fechaMatricula);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return cursoAcademico.hashCode() + expediente.hashCode() + fechaMatricula.hashCode();
	}

	@Override
	public String toString() {
		return "Matricula [cursoAcademico=" + cursoAcademico + ", estado=" + estado + ", numArchivo=" + numArchivo
				+ ", turnoPreferente=" + turnoPreferente + ", fechaMatricula=" + fechaMatricula + ", nuevoIngreso="
				+ nuevoIngreso + ", listadoAsignaturas=" + listadoAsignaturas + "]";
	}
}