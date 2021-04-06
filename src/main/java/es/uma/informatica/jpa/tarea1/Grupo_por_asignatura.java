package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Grupo_por_asignatura implements Serializable{
	
	private static final long serialVersionUID = 1L;



	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private String Curso_Academico;
	
	@Column
	private String Oferta;
	
	
	@OneToMany (mappedBy = "")
	private List<Expedientes> lista_expedientes;
	@Id 
	@ManyToOne
	private Grupo grupo;
	
	@Id 
	@ManyToOne
	private Asignatura Asignatura;
	
	public Grupo_por_asignatura(String curso_academico, String oferta ,List<Expedientes> lista_expedientes) {
		super();
		Curso_Academico = curso_academico;
		Oferta = oferta;
	}
	
	public Grupo_por_asignatura() {
		
	}


	public String getCurso_Academico() {
		return Curso_Academico;
	}


	public void setCurso_Academico(String curso_academico) {
		Curso_Academico = curso_academico;
	}


	public String getOferta() {
		return Oferta;
	}


	public void setOferta(String oferta) {
		Oferta = oferta;
	}

	public List<Expedientes> getLista_expedientes() {
		return lista_expedientes;
	}


	public void setLista_expedientes(List<Expedientes> lista_expedientes) {
		this.lista_expedientes = lista_expedientes;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Oferta == null) ? 0 : Oferta.hashCode());
		result = prime * result + ((Curso_Academico == null) ? 0 : Curso_Academico.hashCode());
		result = prime * result + ((lista_expedientes == null) ? 0 : lista_expedientes.hashCode());
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
		Grupo_por_asignatura other = (Grupo_por_asignatura) obj;
		if (Curso_Academico == null) {
			if (other.Curso_Academico != null)
				return false;
		} else if (!Curso_Academico.equals(other.Curso_Academico))
			return false;
		if (Oferta == null) {
			if (other.Oferta != null)
				return false;
		} else if (!Oferta.equals(other.Oferta))
			return false;
		if (lista_expedientes == null) {
			if (other.lista_expedientes != null)
				return false;
		} else if (!lista_expedientes.equals(other.lista_expedientes))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Grupo_por_asignatura [Curso_Academico=" + Curso_Academico + ", Oferta=" + Oferta +  ", lista_expedientes="
				+ lista_expedientes + "]";
	}
	
}
