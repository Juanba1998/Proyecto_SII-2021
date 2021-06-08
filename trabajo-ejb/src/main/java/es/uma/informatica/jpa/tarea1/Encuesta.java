package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Encuesta implements Serializable {
	
	@Id
	private String fechaEnvio;
 
	@ManyToOne(optional=false)
	private Expediente expedienteEncuesta;
	
	@ManyToMany(mappedBy="encuesta")
	private List<GrupoPorAsignatura> grupoPorAsignatura;

	public Encuesta() {
		super();
	}
	
	public Encuesta(String fechaEnvio, Expediente expedienteEncuesta) {
		this.fechaEnvio = fechaEnvio;
		this.expedienteEncuesta = expedienteEncuesta;
	}
	
	public String getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(String fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	public Expediente getExpediente() {
		return expedienteEncuesta;
	}

	public void setExpediente(Expediente expedienteEncuesta) {
		this.expedienteEncuesta = expedienteEncuesta;
	}

	public List<GrupoPorAsignatura> getGrupoPorAsignatura() {
		return grupoPorAsignatura;
	}

	public void setGrupoPorAsignatura(List<GrupoPorAsignatura> grupoPorAsignatura) {
		this.grupoPorAsignatura = grupoPorAsignatura;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Encuesta){
        	Encuesta enc = (Encuesta) obj;
            ok = fechaEnvio.equalsIgnoreCase(enc.fechaEnvio);
        }
        
        return ok;
	}

	@Override
	public int hashCode() {
		return fechaEnvio.hashCode();
	}

	@Override
	public String toString() {
		return "Encuesta [fechaEnvio=" + fechaEnvio + ", expediente=" + expedienteEncuesta + "]";
	}
}