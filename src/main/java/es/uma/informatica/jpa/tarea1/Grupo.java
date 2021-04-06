package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Grupo implements Serializable{
	
	private static final long serialVersionUID = 1L;

	

	@ManyToOne
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
	
	private Boolean Visible;
	private String Asignar;
	private Integer Plazas;
	
	

	@ManyToOne
	private Titulacion titulacion;
	
	@OneToMany(mappedBy="grupo")
	private List<Clase> clase;
	
	@OneToMany(mappedBy="grupo")
	private List<Grupo_por_asignatura> grupo_por_asignatura;

	@OneToMany(mappedBy = "grupo")
	private List<Asignaturas_Matricula> asignaturas_matricula;
	
	@OneToMany(mappedBy = "ID")
	private List<Grupo> agrupa_grupos;

	
	
	
	
	
	public Grupo(Integer iD, String curso, String letra, String turno_Manana_Tarde, Boolean ingles, Boolean visible,
			String asignar, Integer plazas, Titulacion titulacion, List<Clase> clase, List<Clase> grupo_por_asignatura,
			List<Asignaturas_Matricula> asignaturas_matricula, List<Grupo> agrupa_grupos) {
		super();
		ID = iD;
		Curso = curso;
		Letra = letra;
		Turno_Manana_Tarde = turno_Manana_Tarde;
		Ingles = ingles;
		Visible = visible;
		Asignar = asignar;
		Plazas = plazas;
		this.titulacion = titulacion;
		this.clase = clase;
		this.grupo_por_asignatura = grupo_por_asignatura;
		this.asignaturas_matricula = asignaturas_matricula;
		this.agrupa_grupos = agrupa_grupos;
	}

	
	
	public Grupo() {
		super();
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

	public void setTurno_Manana_Tarde(String turno_Manana_Tarde) {
		Turno_Manana_Tarde = turno_Manana_Tarde;
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

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

	public List<Clase> getGrupo_por_asignatura() {
		return grupo_por_asignatura;
	}

	public void setGrupo_por_asignatura(List<Clase> grupo_por_asignatura) {
		this.grupo_por_asignatura = grupo_por_asignatura;
	}

	public List<Asignaturas_Matricula> getAsignaturas_matricula() {
		return asignaturas_matricula;
	}

	public void setAsignaturas_matricula(List<Asignaturas_Matricula> asignaturas_matricula) {
		this.asignaturas_matricula = asignaturas_matricula;
	}

	public List<Grupo> getAgrupa_grupos() {
		return agrupa_grupos;
	}

	public void setAgrupa_grupos(List<Grupo> agrupa_grupos) {
		this.agrupa_grupos = agrupa_grupos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Asignar == null) ? 0 : Asignar.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Ingles == null) ? 0 : Ingles.hashCode());
		result = prime * result + ((Letra == null) ? 0 : Letra.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((Turno_Manana_Tarde == null) ? 0 : Turno_Manana_Tarde.hashCode());
		result = prime * result + ((Visible == null) ? 0 : Visible.hashCode());
		result = prime * result + ((agrupa_grupos == null) ? 0 : agrupa_grupos.hashCode());
		result = prime * result + ((asignaturas_matricula == null) ? 0 : asignaturas_matricula.hashCode());
		result = prime * result + ((clase == null) ? 0 : clase.hashCode());
		result = prime * result + ((grupo_por_asignatura == null) ? 0 : grupo_por_asignatura.hashCode());
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
		Grupo other = (Grupo) obj;
		if (Asignar == null) {
			if (other.Asignar != null)
				return false;
		} else if (!Asignar.equals(other.Asignar))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Ingles == null) {
			if (other.Ingles != null)
				return false;
		} else if (!Ingles.equals(other.Ingles))
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
		if (Turno_Manana_Tarde == null) {
			if (other.Turno_Manana_Tarde != null)
				return false;
		} else if (!Turno_Manana_Tarde.equals(other.Turno_Manana_Tarde))
			return false;
		if (Visible == null) {
			if (other.Visible != null)
				return false;
		} else if (!Visible.equals(other.Visible))
			return false;
		if (agrupa_grupos == null) {
			if (other.agrupa_grupos != null)
				return false;
		} else if (!agrupa_grupos.equals(other.agrupa_grupos))
			return false;
		if (asignaturas_matricula == null) {
			if (other.asignaturas_matricula != null)
				return false;
		} else if (!asignaturas_matricula.equals(other.asignaturas_matricula))
			return false;
		if (clase == null) {
			if (other.clase != null)
				return false;
		} else if (!clase.equals(other.clase))
			return false;
		if (grupo_por_asignatura == null) {
			if (other.grupo_por_asignatura != null)
				return false;
		} else if (!grupo_por_asignatura.equals(other.grupo_por_asignatura))
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
		return "Grupo [ID=" + ID + ", Curso=" + Curso + ", Letra=" + Letra + ", Turno_Manana_Tarde="
				+ Turno_Manana_Tarde + ", Ingles=" + Ingles + ", Visible=" + Visible + ", Asignar=" + Asignar
				+ ", Plazas=" + Plazas + ", titulacion=" + titulacion + ", clase=" + clase + ", grupo_por_asignatura="
				+ grupo_por_asignatura + ", asignaturas_matricula=" + asignaturas_matricula + ", agrupa_grupos="
				+ agrupa_grupos + "]";
	}
	
	
}
