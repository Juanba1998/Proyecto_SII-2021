package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Asignaturas_Matricula implements Serializable {

	@ManyToOne
	private Asignatura asignatura;
	
	@ManyToOne
	private Grupo grupo;

	private static final long serialVersionUID = 1L;

	public Asignaturas_Matricula() {
		super();
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
	public String toString() {
		return "Asignaturas_Matricula []";
	}
   
}
