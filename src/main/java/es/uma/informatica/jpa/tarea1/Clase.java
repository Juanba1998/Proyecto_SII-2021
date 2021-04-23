package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	 
	public static class ClaseId implements Serializable{
		
		private Date dia;
		private Date horaInicio;
		private int grupo;
		
		public ClaseId() {
			super();
		}

		public ClaseId(Date dia, Date horaInicio, int grupo) {
			super();
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

		public Date getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(Date horaInicio) {
			this.horaInicio = horaInicio;
		}

		public int getGrupo() {
			return grupo;
		}

		public void setGrupo(int grupo) {
			this.grupo = grupo;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((dia == null) ? 0 : dia.hashCode());
			result = prime * result + grupo;
			result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
			ClaseId other = (ClaseId) obj;
			if (dia == null) {
				if (other.dia != null)
					return false;
			} else if (!dia.equals(other.dia))
				return false;
			if (grupo != other.grupo)
				return false;
			if (horaInicio == null) {
				if (other.horaInicio != null)
					return false;
			} else if (!horaInicio.equals(other.horaInicio))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "ClaseId [dia=" + dia + ", horaInicio=" + horaInicio + ", grupo=" + grupo + "]";
		}
		
		
	}
	
	@Id
	private Date dia;
	
	@Id
	private Date horaInicio;
	
	private Date HoraFin;
	
	@ManyToOne(optional=false)
	private Asignatura asignatura;
	
	@Id @ManyToOne(optional=false)
	private Grupo grupo;

	public Clase() {
		super();
	}

	public Clase(Date dia, Date horaInicio, Date horaFin, Asignatura asignatura, Grupo grupo) {
		super();
		this.dia = dia;
		this.horaInicio = horaInicio;
		HoraFin = horaFin;
		this.asignatura = asignatura;
		this.grupo = grupo;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(Date horaFin) {
		HoraFin = horaFin;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((HoraFin == null) ? 0 : HoraFin.hashCode());
		result = prime * result + ((asignatura == null) ? 0 : asignatura.hashCode());
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
		result = prime * result + ((horaInicio == null) ? 0 : horaInicio.hashCode());
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
		Clase other = (Clase) obj;
		if (HoraFin == null) {
			if (other.HoraFin != null)
				return false;
		} else if (!HoraFin.equals(other.HoraFin))
			return false;
		if (asignatura == null) {
			if (other.asignatura != null)
				return false;
		} else if (!asignatura.equals(other.asignatura))
			return false;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (horaInicio == null) {
			if (other.horaInicio != null)
				return false;
		} else if (!horaInicio.equals(other.horaInicio))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Clase [dia=" + dia + ", horaInicio=" + horaInicio + ", HoraFin=" + HoraFin + ", asignatura="
				+ asignatura + ", grupo=" + grupo + "]";
	}

	
}
