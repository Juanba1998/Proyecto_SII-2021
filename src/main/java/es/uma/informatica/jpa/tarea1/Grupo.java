package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	


	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@Column(unique = true)
	private String Curso;
	

	@Column(unique = true)
	private String Letra;
	
	@Column(nullable = false)
	private String Turno_Manana_Tarde;
	
	@Column(nullable = false)
	private Boolean Ingles;
	
	@Column(nullable = true)
	private Boolean Visible;
	
	@Column(nullable = true)
	private String Asignar;
	
	@Column(nullable = true)
	private Integer Plazas;
	
	

	@ManyToOne
	private Titulacion titulacion;
	
	
	public Grupo(Integer iD, String curso, String letra, String turno_manana_tarde, Boolean ingles,
			Boolean visible, String asignar, Integer plazas) {
		super();
		ID = iD;
		Curso = curso;
		Letra = letra;
		Turno_Manana_Tarde = turno_manana_tarde;
		Ingles = ingles;
		Visible = visible;
		Asignar = asignar;
		Plazas = plazas;
	}
	
	public Grupo() {
		
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public String getCurso() {
		return Curso;
	}


	public void setCurso(String curso) {
		Curso = curso;
	}


	public String getLetra() {
		return Letra;
	}


	public void setLetra(String letra) {
		Letra = letra;
	}


	public String getTurno_Manana_Tarde() {
		return Turno_Manana_Tarde;
	}


	public void setTurno_Manana_Tarde(String turno_manana_tarde) {
		Turno_Manana_Tarde = turno_manana_tarde;
	}


	public Boolean getIngles() {
		return Ingles;
	}


	public void setIngles(Boolean ingles) {
		Ingles = ingles;
	}


	public Boolean getVisible() {
		return Visible;
	}


	public void setVisible(Boolean visible) {
		Visible = visible;
	}


	public String getAsignar() {
		return Asignar;
	}


	public void setAsignar(String asignar) {
		Asignar = asignar;
	}


	public Integer getPlazas() {
		return Plazas;
	}


	public void setPlazas(Integer plazas) {
		Plazas = plazas;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ingles == null) ? 0 : Ingles.hashCode());
		result = prime * result + ((Visible == null) ? 0 : Visible.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((Turno_Manana_Tarde == null) ? 0 : Turno_Manana_Tarde.hashCode());
		result = prime * result + ((Asignar == null) ? 0 : Asignar.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Letra == null) ? 0 : Letra.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
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
		Grupo other = (Grupo) obj;
		if (Ingles == null) {
			if (other.Ingles != null)
				return false;
		} else if (!Ingles.equals(other.Ingles))
			return false;
		if (Visible == null) {
			if (other.Visible != null)
				return false;
		} else if (!Visible.equals(other.Visible))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (Turno_Manana_Tarde == null) {
			if (other.Turno_Manana_Tarde != null)
				return false;
		} else if (!Turno_Manana_Tarde.equals(other.Turno_Manana_Tarde))
			return false;
		if (Asignar == null) {
			if (other.Asignar != null)
				return false;
		} else if (!Asignar.equals(other.Asignar))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Letra == null) {
			if (other.Letra != null)
				return false;
		} else if (!Letra.equals(other.Letra))
			return false;
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		
		return true;
	}


	@Override
	public String toString() {
		return "Grupo [ID=" + ID +", Ingles=" + Ingles + ", Visible=" + Visible + ", Curso=" + Curso + ", Turno_Manana_Tarde="
				+ Turno_Manana_Tarde + ", Asignar=" + Asignar + ", Letra=" + Letra + ", Plazas="
				+ Plazas + "]";
	}
	
}
