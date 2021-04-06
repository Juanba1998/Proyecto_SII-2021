package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Clase
 *
 */
@Entity
@IdClass(Clase.ClaseId.class)
public class Clase implements Serializable {
	
	public static class ClaseId implements Serializable{
		private Date dia;
		private Date horaInicio;
		private int grupo;
	}
	
	@Id
	private Date dia;
	@Id
	private Date horaInicio;
	
	@Column(nullable=false)
	private Date HoraFin;
	
	@ManyToOne
	private Asignatura asignatura;
	
	@Id //esto es porque es debil
	@ManyToOne
	private Grupo grupo;
	
	private static final long serialVersionUID = 1L;

	public Clase() {
	}

	public Clase(Date dia, Date horaInicio, Date horaFin) {
		super();
		this.dia = dia;
		this.horaInicio = horaInicio;
		HoraFin = horaFin;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Clase [dia=" + dia + ", horaInicio=" + horaInicio + ", HoraFin=" + HoraFin + ", asignatura="
				+ asignatura + ", grupo=" + grupo + "]";
	}
	
	
   
	//Generar hash y equals cuando este todo
	
	
	
}
