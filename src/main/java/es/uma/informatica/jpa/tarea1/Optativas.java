package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Optativas extends Asignatura implements Serializable{

	private Integer plazas;
	private String mencion;

	public Optativas() {
		super();
	}

	public Optativas(Integer referencia, Integer codigo, Integer creditos, Integer ofertada, String nombre,
			String curso, String duracion, String cuatrimestre, String idiomas_de_Imparticion,
			Titulacion asignaturas_titulacion, List<Clase> clase, List<Asignaturas_Matricula> asignaturas_matricula,
			Integer plazas, String mencion) {
		super(referencia, codigo, creditos, ofertada, nombre, curso, duracion, cuatrimestre, idiomas_de_Imparticion,
				asignaturas_titulacion, clase, asignaturas_matricula);
		this.plazas = plazas;
		this.mencion = mencion;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public String getMencion() {
		return mencion;
	}

	public void setMencion(String mencion) {
		this.mencion = mencion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((mencion == null) ? 0 : mencion.hashCode());
		result = prime * result + ((plazas == null) ? 0 : plazas.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Optativas other = (Optativas) obj;
		if (mencion == null) {
			if (other.mencion != null)
				return false;
		} else if (!mencion.equals(other.mencion))
			return false;
		if (plazas == null) {
			if (other.plazas != null)
				return false;
		} else if (!plazas.equals(other.plazas))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Optativas [plazas=" + plazas + ", mencion=" + mencion + "]";
	}
	
}