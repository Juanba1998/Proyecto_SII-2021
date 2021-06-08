package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Expediente implements Serializable {
	   
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer numExpediente;
 
	private Boolean activo;
	private Double notaMediaProvisional;
	private Double creditosSuperados;
	private Double creditosFB;
	private Double creditosOB;
	private Double creditosOP;
	private Double creditosCF;
	private Double creditosPE;
	private Double creditosTF;
	
	@ManyToOne(optional=false)
	private Titulacion titulacion;
	
	@ManyToOne(optional=false)
	private Alumno alumno;
	
	@OneToMany(mappedBy = "expedienteEncuesta")
	private List<Encuesta> encuestasExpediente;
	
	@OneToMany(mappedBy = "expediente")
	private List<Matricula> matriculas;

	public Expediente() {
		super();
	}

	public Expediente(Integer numExpediente, Boolean activo, Double notaMediaProvisional, Double creditosSuperados,
			Double creditosFB, Double creditosOB, Double creditosOP, Double creditosCF, Double creditosPE, Double creditosTF) {
		this.numExpediente = numExpediente;
		this.activo = activo;
		this.notaMediaProvisional = notaMediaProvisional;
		this.creditosSuperados = creditosSuperados;
		this.creditosFB = creditosFB;
		this.creditosOB = creditosOB;
		this.creditosOP = creditosOP;
		this.creditosCF = creditosCF;
		this.creditosPE = creditosPE;
		this.creditosTF = creditosTF;
	}

	public Integer getNumExpediente() {
		return numExpediente;
	}

	public void setNumExpediente(Integer numExpediente) {
		this.numExpediente = numExpediente;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

	public Double getNotaMediaProvisional() {
		return notaMediaProvisional;
	}

	public void setNotaMediaProvisional(Double notaMediaProvisional) {
		this.notaMediaProvisional = notaMediaProvisional;
	}

	public Double getCreditosSuperados() {
		return creditosSuperados;
	}

	public void setCreditosSuperados(Double creditosSuperados) {
		this.creditosSuperados = creditosSuperados;
	}

	public Double getCreditosFB() {
		return creditosFB;
	}

	public void setCreditosFB(Double creditosFB) {
		this.creditosFB = creditosFB;
	}

	public Double getCreditosOB() {
		return creditosOB;
	}

	public void setCreditosOB(Double creditosOB) {
		this.creditosOB = creditosOB;
	}

	public Double getCreditosOP() {
		return creditosOP;
	}

	public void setCreditosOP(Double creditosOP) {
		this.creditosOP = creditosOP;
	}

	public Double getCreditosCF() {
		return creditosCF;
	}

	public void setCreditosCF(Double creditosCF) {
		this.creditosCF = creditosCF;
	}

	public Double getCreditosPE() {
		return creditosPE;
	}

	public void setCreditosPE(Double creditosPE) {
		this.creditosPE = creditosPE;
	}

	public Double getCreditosTF() {
		return creditosTF;
	}

	public void setCreditosTF(Double creditosTF) {
		this.creditosTF = creditosTF;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Encuesta> getEncuestasExpediente() {
		return encuestasExpediente;
	}

	public void setEncuestasExpediente(List<Encuesta> encuestasExpediente) {
		this.encuestasExpediente = encuestasExpediente;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Expediente){
        	Expediente exp = (Expediente) obj;
            ok = numExpediente == exp.numExpediente;
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return numExpediente.hashCode();
	}

	@Override
	public String toString() {
		return "Expedientes [numExpediente=" + numExpediente + ", activo=" + activo + ", notaMediaProvisional="
				+ notaMediaProvisional + ", creditosSuperados=" + creditosSuperados + ", creditosFB=" + creditosFB
				+ ", creditosOB=" + creditosOB + ", creditosOP=" + creditosOP + ", creditosCF=" + creditosCF
				+ ", creditosPE=" + creditosPE + ", creditosTF=" + creditosTF + "]";
	}
}