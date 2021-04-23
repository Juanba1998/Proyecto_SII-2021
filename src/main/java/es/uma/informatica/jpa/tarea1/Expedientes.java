package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Expedientes implements Serializable {
	    
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Num_Expediente;

	private Boolean Activo;
	private Double Nota_Media_Provisional;
	private Integer Creditos_superados;
	private Integer Creditos_FB;
	private Integer Creditos_OB;
	private Integer Creditos_OP;
	private Integer Creditos_CF;
	private Integer Creditos_PE;
	private Integer Creditos_TF;
	
	@ManyToOne(optional=false)
	private Titulacion titulacion;
	
	@ManyToOne(optional=false)
	private Alumno alumno;
	
	@OneToMany (mappedBy = "expediente")
	private List<Encuesta> encuestas_expediente;
	
	@OneToMany (mappedBy="expediente")
	private List<Matricula> matriculas;

	public Expedientes() {
		super();
	}

	public Expedientes(Integer num_Expediente, Boolean activo, Double nota_Media_Provisional,
			Integer creditos_superados, Integer creditos_FB, Integer creditos_OB, Integer creditos_OP,
			Integer creditos_CF, Integer creditos_PE, Integer creditos_TF, Titulacion titulacion, Alumno alumno,
			List<Encuesta> encuestas_expediente, List<Matricula> matriculas) {
		super();
		Num_Expediente = num_Expediente;
		Activo = activo;
		Nota_Media_Provisional = nota_Media_Provisional;
		Creditos_superados = creditos_superados;
		Creditos_FB = creditos_FB;
		Creditos_OB = creditos_OB;
		Creditos_OP = creditos_OP;
		Creditos_CF = creditos_CF;
		Creditos_PE = creditos_PE;
		Creditos_TF = creditos_TF;
		this.titulacion = titulacion;
		this.alumno = alumno;
		this.encuestas_expediente = encuestas_expediente;
		this.matriculas = matriculas;
	}

	public Integer getNum_Expediente() {
		return Num_Expediente;
	}

	public void setNum_Expediente(Integer num_Expediente) {
		Num_Expediente = num_Expediente;
	}

	public Boolean getActivo() {
		return Activo;
	}

	public void setActivo(Boolean activo) {
		Activo = activo;
	}

	public Double getNota_Media_Provisional() {
		return Nota_Media_Provisional;
	}

	public void setNota_Media_Provisional(Double nota_Media_Provisional) {
		Nota_Media_Provisional = nota_Media_Provisional;
	}

	public Integer getCreditos_superados() {
		return Creditos_superados;
	}

	public void setCreditos_superados(Integer creditos_superados) {
		Creditos_superados = creditos_superados;
	}

	public Integer getCreditos_FB() {
		return Creditos_FB;
	}

	public void setCreditos_FB(Integer creditos_FB) {
		Creditos_FB = creditos_FB;
	}

	public Integer getCreditos_OB() {
		return Creditos_OB;
	}

	public void setCreditos_OB(Integer creditos_OB) {
		Creditos_OB = creditos_OB;
	}

	public Integer getCreditos_OP() {
		return Creditos_OP;
	}

	public void setCreditos_OP(Integer creditos_OP) {
		Creditos_OP = creditos_OP;
	}

	public Integer getCreditos_CF() {
		return Creditos_CF;
	}

	public void setCreditos_CF(Integer creditos_CF) {
		Creditos_CF = creditos_CF;
	}

	public Integer getCreditos_PE() {
		return Creditos_PE;
	}

	public void setCreditos_PE(Integer creditos_PE) {
		Creditos_PE = creditos_PE;
	}

	public Integer getCreditos_TF() {
		return Creditos_TF;
	}

	public void setCreditos_TF(Integer creditos_TF) {
		Creditos_TF = creditos_TF;
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

	public List<Encuesta> getEncuestas_expediente() {
		return encuestas_expediente;
	}

	public void setEncuestas_expediente(List<Encuesta> encuestas_expediente) {
		this.encuestas_expediente = encuestas_expediente;
	}

	public List<Matricula> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matricula> matriculas) {
		this.matriculas = matriculas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Activo == null) ? 0 : Activo.hashCode());
		result = prime * result + ((Creditos_CF == null) ? 0 : Creditos_CF.hashCode());
		result = prime * result + ((Creditos_FB == null) ? 0 : Creditos_FB.hashCode());
		result = prime * result + ((Creditos_OB == null) ? 0 : Creditos_OB.hashCode());
		result = prime * result + ((Creditos_OP == null) ? 0 : Creditos_OP.hashCode());
		result = prime * result + ((Creditos_PE == null) ? 0 : Creditos_PE.hashCode());
		result = prime * result + ((Creditos_TF == null) ? 0 : Creditos_TF.hashCode());
		result = prime * result + ((Creditos_superados == null) ? 0 : Creditos_superados.hashCode());
		result = prime * result + ((Nota_Media_Provisional == null) ? 0 : Nota_Media_Provisional.hashCode());
		result = prime * result + ((Num_Expediente == null) ? 0 : Num_Expediente.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((encuestas_expediente == null) ? 0 : encuestas_expediente.hashCode());
		result = prime * result + ((matriculas == null) ? 0 : matriculas.hashCode());
		result = prime * result + ((titulacion == null) ? 0 : titulacion.hashCode());
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
		Expedientes other = (Expedientes) obj;
		if (Activo == null) {
			if (other.Activo != null)
				return false;
		} else if (!Activo.equals(other.Activo))
			return false;
		if (Creditos_CF == null) {
			if (other.Creditos_CF != null)
				return false;
		} else if (!Creditos_CF.equals(other.Creditos_CF))
			return false;
		if (Creditos_FB == null) {
			if (other.Creditos_FB != null)
				return false;
		} else if (!Creditos_FB.equals(other.Creditos_FB))
			return false;
		if (Creditos_OB == null) {
			if (other.Creditos_OB != null)
				return false;
		} else if (!Creditos_OB.equals(other.Creditos_OB))
			return false;
		if (Creditos_OP == null) {
			if (other.Creditos_OP != null)
				return false;
		} else if (!Creditos_OP.equals(other.Creditos_OP))
			return false;
		if (Creditos_PE == null) {
			if (other.Creditos_PE != null)
				return false;
		} else if (!Creditos_PE.equals(other.Creditos_PE))
			return false;
		if (Creditos_TF == null) {
			if (other.Creditos_TF != null)
				return false;
		} else if (!Creditos_TF.equals(other.Creditos_TF))
			return false;
		if (Creditos_superados == null) {
			if (other.Creditos_superados != null)
				return false;
		} else if (!Creditos_superados.equals(other.Creditos_superados))
			return false;
		if (Nota_Media_Provisional == null) {
			if (other.Nota_Media_Provisional != null)
				return false;
		} else if (!Nota_Media_Provisional.equals(other.Nota_Media_Provisional))
			return false;
		if (Num_Expediente == null) {
			if (other.Num_Expediente != null)
				return false;
		} else if (!Num_Expediente.equals(other.Num_Expediente))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (encuestas_expediente == null) {
			if (other.encuestas_expediente != null)
				return false;
		} else if (!encuestas_expediente.equals(other.encuestas_expediente))
			return false;
		if (matriculas == null) {
			if (other.matriculas != null)
				return false;
		} else if (!matriculas.equals(other.matriculas))
			return false;
		if (titulacion == null) {
			if (other.titulacion != null)
				return false;
		} else if (!titulacion.equals(other.titulacion))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Expedientes [Num_Expediente=" + Num_Expediente + ", Activo=" + Activo + ", Nota_Media_Provisional="
				+ Nota_Media_Provisional + ", Creditos_superados=" + Creditos_superados + ", Creditos_FB=" + Creditos_FB
				+ ", Creditos_OB=" + Creditos_OB + ", Creditos_OP=" + Creditos_OP + ", Creditos_CF=" + Creditos_CF
				+ ", Creditos_PE=" + Creditos_PE + ", Creditos_TF=" + Creditos_TF + ", titulacion=" + titulacion
				+ ", alumno=" + alumno + ", encuestas_expediente=" + encuestas_expediente + ", matriculas=" + matriculas
				+ "]";
	}
}