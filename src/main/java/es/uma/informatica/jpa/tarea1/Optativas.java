package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Optativas
 *
 */
@Entity
public class Optativas extends Asignatura implements Serializable{

	private Integer plazas;
	private String Mencion;
	
	private static final long serialVersionUID = 1L;

	public Optativas() {
		super();
	}

	public Optativas(Integer referencia, Integer codigo, Integer creditos, Integer ofertados, String nombre,
			String curso, String duracion, String cuatrimestre, String idiomasDeImparticion, Integer plazas, String mencion) {
		super(referencia, codigo, creditos, ofertados, nombre, 
				curso, duracion, cuatrimestre, idiomasDeImparticion);
		this.plazas = plazas;
		Mencion = mencion;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public String getMencion() {
		return Mencion;
	}

	public void setMencion(String mencion) {
		Mencion = mencion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Mencion == null) ? 0 : Mencion.hashCode());
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
		if (Mencion == null) {
			if (other.Mencion != null)
				return false;
		} else if (!Mencion.equals(other.Mencion))
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
		return "Optativas [plazas=" + plazas + ", Mencion=" + Mencion + "]";
	}

	
	
   
}
