package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;
 
@SuppressWarnings("serial")
@Entity
@IdClass(GrupoPorAsignatura.GrupoPorAsignaturaID.class)
public class GrupoPorAsignatura implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String cursoAcademico;
	
	private String oferta;
	
	@Id @ManyToOne(optional=false)
	private Grupo grupo;
	
	@Id @ManyToOne(optional=false)
	private Asignatura asignatura;

	@ManyToMany
	@JoinColumns({
		@JoinColumn(name="fk_ca", referencedColumnName="cursoAcademico"),
		@JoinColumn(name="fk_grupo", referencedColumnName="grupo"),
		@JoinColumn(name="fk_asig", referencedColumnName="asignatura")
	})
	private List<Encuesta> encuesta;
	
	public static class GrupoPorAsignaturaID implements Serializable{
		
		private String cursoAcademico;
		private Integer grupo;
		private Integer asignatura;
		
		public GrupoPorAsignaturaID() {
			super();
		}

		public GrupoPorAsignaturaID(String cursoAcademico, Integer grupo, Integer asignatura) {
			this.cursoAcademico = cursoAcademico;
			this.grupo = grupo;
			this.asignatura = asignatura;
		}

		public String getCursoAcademico() {
			return cursoAcademico;
		}

		public void setCursoAcademico(String cursoAcademico) {
			this.cursoAcademico = cursoAcademico;
		}

		public Integer getGrupo() {
			return grupo;
		}

		public void setGrupo(Integer grupo) {
			this.grupo = grupo;
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
			
	        if(obj instanceof GrupoPorAsignaturaID){
	        	GrupoPorAsignaturaID grasid = (GrupoPorAsignaturaID) obj;
	            ok = cursoAcademico.equalsIgnoreCase(grasid.cursoAcademico) && (grupo == grasid.grupo) && (asignatura == grasid.asignatura);
	        }
	        
	        return ok;
		}
		
		@Override
		public int hashCode() {
			return cursoAcademico.hashCode() + grupo.hashCode() + asignatura.hashCode();
		}

		@Override
		public String toString() {
			return "GrupoPorAsignaturaID [cursoAcademico=" + cursoAcademico + ", grupo=" + grupo + ", asignatura="
					+ asignatura + "]";
		}
	}

	public GrupoPorAsignatura() {
		super();
	}

	public GrupoPorAsignatura(String cursoAcademico, String oferta, Grupo grupo, Asignatura asignatura,
			List<Encuesta> encuesta) {
		super();
		this.cursoAcademico = cursoAcademico;
		this.oferta = oferta;
		this.grupo = grupo;
		this.asignatura = asignatura;
		this.encuesta = encuesta;
	}
	
	public String getCursoAcademico() {
		return cursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		this.cursoAcademico = cursoAcademico;
	}

	public String getOferta() {
		return oferta;
	}

	public void setOferta(String oferta) {
		this.oferta = oferta;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public List<Encuesta> getEncuesta() {
		return encuesta;
	}

	public void setEncuesta(List<Encuesta> encuesta) {
		this.encuesta = encuesta;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof GrupoPorAsignatura){
        	GrupoPorAsignatura gras = (GrupoPorAsignatura) obj;
            ok = cursoAcademico.equalsIgnoreCase(gras.cursoAcademico) && grupo.equals(gras.grupo) && asignatura.equals(gras.asignatura);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return cursoAcademico.hashCode() + grupo.hashCode() + asignatura.hashCode();
	}

	@Override
	public String toString() {
		return "GrupoPorAsignatura [cursoAcademico=" + cursoAcademico + ", oferta=" + oferta + ", grupo=" + grupo
				+ ", asignatura=" + asignatura + ", encuesta=" + encuesta + "]";
	}
}