package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Centro implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	 
	@Column(unique = true)
	private String nombre;
	
	@Column(nullable = false)
	private String direccion;
	
	private Integer tlfConserjeria;
	
	@ManyToMany(mappedBy = "titulacionCentros")
	private List<Titulacion> centroTitulaciones;
	
	public Centro() {
		super();
	}
	
	public Centro(Integer id, String nombre, String direccion, Integer tlfConserjeria) {
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.tlfConserjeria = tlfConserjeria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTlfConserjeria() {
		return tlfConserjeria;
	}

	public void setTlfConserjeria(Integer tlfConserjeria) {
		this.tlfConserjeria = tlfConserjeria;
	}

	public List<Titulacion> getCentroTitulaciones() {
		return centroTitulaciones;
	}

	public void setCentroTitulaciones(List<Titulacion> centroTitulaciones) {
		this.centroTitulaciones = centroTitulaciones;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Centro){
        	Centro c = (Centro) obj;
            ok = (id == c.id) && nombre.equalsIgnoreCase(c.nombre) && direccion.equals(c.direccion);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode() + nombre.hashCode() + direccion.hashCode();
	}

	@Override
	public String toString() {
		return "Centro [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", tlfConserjeria=" + tlfConserjeria + "]";
	}
}