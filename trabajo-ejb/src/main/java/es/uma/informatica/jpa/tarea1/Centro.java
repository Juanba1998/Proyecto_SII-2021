package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Centro implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	 
	@Column(unique = true)
	private String Nombre;
	
	@Column(nullable = false)
	private String Direccion;
	
	private Integer TLF_Conserjeria;
	
	@ManyToMany(mappedBy = "titulacion_centros")
	private List<Titulacion> centro_titulaciones;

	public Centro(Integer iD, String nombre, String direccion, Integer tLF_Conserjeria) {
		super();
		ID = iD;
		Nombre = nombre;
		Direccion = direccion;
		TLF_Conserjeria = tLF_Conserjeria;
	}

	public Centro() {
		super();
	}

	public Centro(Integer iD, String nombre, String direccion, Integer tLF_Conserjeria,
			List<Titulacion> centro_titulaciones) {
		super();
		ID = iD;
		Nombre = nombre;
		Direccion = direccion;
		TLF_Conserjeria = tLF_Conserjeria;
		this.centro_titulaciones = centro_titulaciones;
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public Integer getTLF_Conserjeria() {
		return TLF_Conserjeria;
	}

	public void setTLF_Conserjeria(Integer tLF_Conserjeria) {
		TLF_Conserjeria = tLF_Conserjeria;
	}

	public List<Titulacion> getCentro_titulaciones() {
		return centro_titulaciones;
	}

	public void setCentro_titulaciones(List<Titulacion> centro_titulaciones) {
		this.centro_titulaciones = centro_titulaciones;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((TLF_Conserjeria == null) ? 0 : TLF_Conserjeria.hashCode());
		result = prime * result + ((centro_titulaciones == null) ? 0 : centro_titulaciones.hashCode());
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
		Centro other = (Centro) obj;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (TLF_Conserjeria == null) {
			if (other.TLF_Conserjeria != null)
				return false;
		} else if (!TLF_Conserjeria.equals(other.TLF_Conserjeria))
			return false;
		if (centro_titulaciones == null) {
			if (other.centro_titulaciones != null)
				return false;
		} else if (!centro_titulaciones.equals(other.centro_titulaciones))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Centro [ID=" + ID + ", Nombre=" + Nombre + ", Direccion=" + Direccion + ", TLF_Conserjeria="
				+ TLF_Conserjeria + ", centro_titulaciones=" + centro_titulaciones + "]";
	}
}