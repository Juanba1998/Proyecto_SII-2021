package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Encuesta
 *
 */
@Entity

public class Encuesta implements Serializable {

	   
	@Id
	private Date Fecha_de_envio;
	private static final long serialVersionUID = 1L;

	
	public Encuesta(Date fecha_de_envio) {
		super();
		Fecha_de_envio = fecha_de_envio;
	}
	
	public Encuesta() {
		
	}   
	public Date getFecha_de_envio() {
		return this.Fecha_de_envio;
	}

	public void setFecha_de_envio(Date Fecha_de_envio) {
		this.Fecha_de_envio = Fecha_de_envio;
	}
   
}
