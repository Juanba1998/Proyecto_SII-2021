package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import javax.persistence.*;

import es.uma.informatica.jpa.tarea1.Matricula.MatriculaId;

@Entity
<<<<<<< HEAD
@IdClass(Asignaturas_Matricula.Asignatura_MatriculaID.class)
@SuppressWarnings("serial")
=======


>>>>>>> parent of bf8c2e1... UPDATE
public class Asignaturas_Matricula implements Serializable {
	
	@Id @ManyToOne(optional=false)
	private Asignatura asignatura;
	
	@Id @ManyToOne(optional=false)
	private Matricula matricula;
	
	@ManyToOne
	private Grupo grupo;

	public static class Asignatura_MatriculaID implements Serializable{
		
		private Matricula.MatriculaId matricula;
		private Integer asignatura;
		
		public Asignatura_MatriculaID() {
			super();
		}

		public Asignatura_MatriculaID(MatriculaId matricula, Integer asignatura) {
			super();
			this.matricula = matricula;
			this.asignatura = asignatura;
		}

		public Matricula.MatriculaId getMatricula() {
			return matricula;
		}

		public void setMatricula(Matricula.MatriculaId matricula) {
			this.matricula = matricula;
		}

		public Integer getAsignatura() {
			return asignatura;
		}

		public void setAsignatura(Integer asignatura) {
			this.asignatura = asignatura;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
			result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
			Asignatura_MatriculaID other = (Asignatura_MatriculaID) obj;
			if (asignatura == null) {
				if (other.asignatura != null)
					return false;
			} else if (!asignatura.equals(other.asignatura))
				return false;
			if (matricula == null) {
				if (other.matricula != null)
					return false;
			} else if (!matricula.equals(other.matricula))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Asignatura_MatriculaID [matricula=" + matricula + ", asignatura=" + asignatura + "]";
		}
			
	}

	public Asignaturas_Matricula() {
		super();
	}

	public Asignaturas_Matricula(Asignatura asignatura, Grupo grupo, Matricula matricula) {
		super();
		this.asignatura = asignatura;
		this.grupo = grupo;
		this.matricula = matricula;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
		Asignaturas_Matricula other = (Asignaturas_Matricula) obj;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Asignaturas_Matricula [asignatura=" + asignatura + ", grupo=" + grupo + ", matricula=" + matricula
				+ "]";
	}
}