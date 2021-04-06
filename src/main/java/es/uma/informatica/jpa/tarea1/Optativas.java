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

	
	
   
}
