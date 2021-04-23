package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Encuesta implements Serializable {
	
	@Id
	private Date Fecha_de_envio;
 
	@ManyToOne(optional=false)
	private Expedientes expediente;
	
	@ManyToMany(mappedBy="encuesta")
	private List<Grupo_por_asignatura> grupo_por_asignatura;

	public Encuesta() {
		super();
	}

	public Encuesta(Date fecha_de_envio, Expedientes expediente, List<Grupo_por_asignatura> grupo_por_asignatura) {
		super();
		Fecha_de_envio = fecha_de_envio;
		this.expediente = expediente;
		this.grupo_por_asignatura = grupo_por_asignatura;
	}

	public Date getFecha_de_envio() {
		return Fecha_de_envio;
	}

	public void setFecha_de_envio(Date fecha_de_envio) {
		Fecha_de_envio = fecha_de_envio;
	}

	public Expedientes getExpediente() {
		return expediente;
	}

	public void setExpediente(Expedientes expediente) {
		this.expediente = expediente;
	}

	public List<Grupo_por_asignatura> getGrupo_por_asignatura() {
		return grupo_por_asignatura;
	}

	public void setGrupo_por_asignatura(List<Grupo_por_asignatura> grupo_por_asignatura) {
		this.grupo_por_asignatura = grupo_por_asignatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Fecha_de_envio == null) ? 0 : Fecha_de_envio.hashCode());
		result = prime * result + ((expediente == null) ? 0 : expediente.hashCode());
		result = prime * result + ((grupo_por_asignatura == null) ? 0 : grupo_por_asignatura.hashCode());
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
		Encuesta other = (Encuesta) obj;
		if (Fecha_de_envio == null) {
			if (other.Fecha_de_envio != null)
				return false;
		} else if (!Fecha_de_envio.equals(other.Fecha_de_envio))
			return false;
		if (expediente == null) {
			if (other.expediente != null)
				return false;
		} else if (!expediente.equals(other.expediente))
			return false;
		if (grupo_por_asignatura == null) {
			if (other.grupo_por_asignatura != null)
				return false;
		} else if (!grupo_por_asignatura.equals(other.grupo_por_asignatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Encuesta [Fecha_de_envio=" + Fecha_de_envio + ", expediente=" + expediente + ", grupo_por_asignatura="
				+ grupo_por_asignatura + "]";
	}	
}