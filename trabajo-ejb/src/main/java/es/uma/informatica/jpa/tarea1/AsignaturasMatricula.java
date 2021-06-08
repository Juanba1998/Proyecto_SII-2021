package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@IdClass(AsignaturasMatricula.AsignaturaMatriculaID.class)
@SuppressWarnings("serial")
public class AsignaturasMatricula implements Serializable {
	 
	@Id @ManyToOne(optional=false)
	private Asignatura asignatura;
	
	@Id @ManyToOne(optional=false)
	private Matricula matricula;
	
	@ManyToOne
	private Grupo grupo;

	public static class AsignaturaMatriculaID implements Serializable{
		
		private Matricula.MatriculaID matricula;
		private Integer asignatura;
		
		public AsignaturaMatriculaID() {
			super();
		}

		public AsignaturaMatriculaID(Matricula.MatriculaID matricula, Integer asignatura) {
			this.matricula = matricula;
			this.asignatura = asignatura;
		}

		public Matricula.MatriculaID getMatricula() {
			return matricula;
		}

		public void setMatricula(Matricula.MatriculaID matricula) {

			this.matricula = matricula;
		}

		public Integer getAsignatura() {
			return asignatura;
		}

		public void setAsignatura(Integer asignatura) {
			this.asignatura = asignatura;
		}

		@Override
		public boolean equals(Object obj) {
			boolean ok = false;
			
	        if(obj instanceof AsignaturaMatriculaID){
	        	AsignaturaMatriculaID amid = (AsignaturaMatriculaID) obj;
	            ok = asignatura == amid.asignatura && matricula.equals(amid.matricula);
	        }
	        
	        return ok;
		}
		
		@Override
		public int hashCode() {
			return asignatura.hashCode() + matricula.hashCode();
		}

		@Override
		public String toString() {
			return "AsignaturaMatriculaID [matricula=" + matricula + ", asignatura=" + asignatura + "]";
		}
			
	}

	public AsignaturasMatricula() {
		super();
	}

	public AsignaturasMatricula(Asignatura asignatura, Grupo grupo, Matricula matricula) {
		
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
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof AsignaturasMatricula){
        	AsignaturasMatricula am = (AsignaturasMatricula) obj;
            ok = asignatura.equals(am.asignatura) && matricula.equals(am.matricula) && grupo.equals(am.grupo);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return asignatura.hashCode() + matricula.hashCode() + grupo.hashCode();
	}

	@Override
	public String toString() {
		return "AsignaturasMatricula [asignatura=" + asignatura + ", grupo=" + grupo + ", matricula=" + matricula
				+ "]";
	}
}