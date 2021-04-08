package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@IdClass(Grupo_por_asignatura.Grupo_por_asignaturaID.class)
public class Grupo_por_asignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String Curso_Academico;
	
	private String Oferta;
	
	@Id @ManyToOne
	private Grupo grupo;
	
	@Id @ManyToOne
	private Asignatura Asignatura;

	@ManyToMany
	@JoinColumns({
		@JoinColumn(name="fk_ca", referencedColumnName="Curso_Academico"),
		@JoinColumn(name="fk_grupo", referencedColumnName="grupo"),
		@JoinColumn(name="fk_asig", referencedColumnName="Asignatura")
	})
	private List<Encuesta> encuesta;
	
	@SuppressWarnings("serial")
	public static class Grupo_por_asignaturaID implements Serializable{
		
		private String Curso_Academico;
		private Integer grupo;
		private Integer Asignatura;
	}
	
	public Grupo_por_asignatura(String curso_academico, String oferta ,List<Expedientes> lista_expedientes) {
		super();
		Curso_Academico = curso_academico;
		Oferta = oferta;
	}
	
	public Grupo_por_asignatura() {
		super();
	}

	public String getCurso_Academico() {
		return Curso_Academico;
	}

	public void setCurso_Academico(String curso_academico) {
		Curso_Academico = curso_academico;
	}

	public Asignatura getAsignatura() {
		return Asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		Asignatura = asignatura;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public String getOferta() {
		return Oferta;
	}

	public void setOferta(String oferta) {
		Oferta = oferta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Asignatura == null) ? 0 : Asignatura.hashCode());
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((Oferta == null) ? 0 : Oferta.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		Grupo_por_asignatura other = (Grupo_por_asignatura) obj;
		if (Asignatura == null) {
			if (other.Asignatura != null)
				return false;
		} else if (!Asignatura.equals(other.Asignatura))
			return false;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (Oferta == null) {
			if (other.Oferta != null)
				return false;
		} else if (!Oferta.equals(other.Oferta))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Grupo_por_asignatura [Curso_Academico=" + Curso_Academico + ", Oferta=" + Oferta + ", grupo=" + grupo
				+ ", Asignatura=" + Asignatura + "]";
	}
}