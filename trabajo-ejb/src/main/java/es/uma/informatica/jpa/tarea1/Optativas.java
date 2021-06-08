package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;

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
			String curso, String caracter, String duracion, String cuatrimestre, String idiomasImparticion,
			Integer plazas, String mencion) {
		super(referencia, codigo, creditos, ofertada, nombre, curso, caracter, duracion, cuatrimestre,
				idiomasImparticion);
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
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Optativas [" + super.toString() +"plazas=" + plazas + ", mencion=" + mencion + "]";
	}
}