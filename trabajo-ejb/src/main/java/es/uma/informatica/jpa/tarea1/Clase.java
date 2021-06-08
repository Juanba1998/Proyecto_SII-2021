package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	
	public static class ClaseId implements Serializable{
		
		@Temporal(TemporalType.DATE)
		
		private Date dia;
		private String horaInicio;
		private Integer grupo;
		
		public ClaseId() {
			super();
		}

		public ClaseId(Date dia, String horaInicio, Integer grupo) {
			this.dia = dia;
			this.horaInicio = horaInicio;
			this.grupo = grupo;
		}

		public Date getDia() {
			return dia;
		}

		public void setDia(Date dia) {
			this.dia = dia;
		}

		public String getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(String horaInicio) {
			this.horaInicio = horaInicio;
		}

		public Integer getGrupo() {
			return grupo;
		}

		public void setGrupo(Integer grupo) {
			this.grupo = grupo;
		}
		
		@Override
		public boolean equals(Object obj) {
			boolean ok = false;
			
	        if(obj instanceof ClaseId){
	        	ClaseId cid = (ClaseId) obj;
	            ok = dia.equals(cid.dia) && horaInicio.equalsIgnoreCase(cid.horaInicio) && (grupo == cid.grupo);
	        }
	        
	        return ok;
		}

		@Override
		public int hashCode() {
			return dia.hashCode() + horaInicio.hashCode() + grupo.hashCode();
		}

		@Override
		public String toString() {
			return "ClaseId [dia=" + dia + ", horaInicio=" + horaInicio + ", grupo=" + grupo + "]";
		}
	}
	
	@Id @Temporal(TemporalType.DATE)
	private Date dia;
	
	@Id
	private String horaInicio;
	
	private String horaFin;
	
	@ManyToOne(optional=false)
	private Asignatura asignatura;
	
	@Id @ManyToOne(optional=false)
	private Grupo grupo;

	public Clase() {
		super();
	}

	public Clase(Date dia, String horaInicio, String horaFin, Asignatura asignatura) {
		this.dia = dia;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.asignatura = asignatura;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
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

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Clase){
        	Clase cl = (Clase) obj;
            ok = dia.equals(cl.dia) && horaInicio.equalsIgnoreCase(cl.horaInicio) && grupo.equals(cl.grupo);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return dia.hashCode() + horaInicio.hashCode() + grupo.hashCode();
	}

	@Override
	public String toString() {
		return "Clase [dia=" + dia + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + "]";
	}
}
