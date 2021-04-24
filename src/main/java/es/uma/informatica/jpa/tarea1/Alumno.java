package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Alumno implements Serializable{
 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer ID;
	
	@Column(unique = true)
	private String DNI;
	
	@Column(nullable = false)
	private String Nombre_completo;
	
	@Column(nullable = false)
	private String Email_Institucional;
	
	private String Email_Personal;
	private Integer Telefono;
	private Integer Movil;
	private String Direccion;
	private String Localidad;
	private String Provincia;
	private Integer CodigoPostal;
	private Boolean AlumnoMovilidad;
	private List<String> grupos_asignados; 
	
	
	@OneToMany (mappedBy = "alumno", cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Expedientes> lista_expedientes;
	
	@OneToMany (mappedBy = "alumno")
	private List<Solicitud> lista_solicitudes;
	
	@OneToOne(optional = false)
	private Login login;

	public Alumno() {
		super();
	}



	public Alumno(Integer iD, String dNI, String nombre_completo, String email_Institucional, String email_Personal,
			Integer telefono, Integer movil, String direccion, String localidad, String provincia, Integer codigoPostal,
			Boolean alumnoMovilidad, List<String> grupos_asignados, List<Expedientes> lista_expedientes,
			List<Solicitud> lista_solicitudes, Login login) {
		super();
		ID = iD;
		DNI = dNI;
		Nombre_completo = nombre_completo;
		Email_Institucional = email_Institucional;
		Email_Personal = email_Personal;
		Telefono = telefono;
		Movil = movil;
		Direccion = direccion;
		Localidad = localidad;
		Provincia = provincia;
		CodigoPostal = codigoPostal;
		AlumnoMovilidad = alumnoMovilidad;
		this.grupos_asignados = grupos_asignados;
		this.lista_expedientes = lista_expedientes;
		this.lista_solicitudes = lista_solicitudes;
		this.login = login;
	}



	


	public List<String> getGrupos_asignados() {
		return grupos_asignados;
	}



	public void setGrupos_asignados(List<String> grupos_asignados) {
		this.grupos_asignados = grupos_asignados;
	}



	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre_completo() {
		return Nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		Nombre_completo = nombre_completo;
	}

	public String getEmail_Institucional() {
		return Email_Institucional;
	}

	public void setEmail_Institucional(String email_Institucional) {
		Email_Institucional = email_Institucional;
	}

	public String getEmail_Personal() {
		return Email_Personal;
	}

	public void setEmail_Personal(String email_Personal) {
		Email_Personal = email_Personal;
	}

	public Integer getTelefono() {
		return Telefono;
	}

	public void setTelefono(Integer telefono) {
		Telefono = telefono;
	}

	public Integer getMovil() {
		return Movil;
	}

	public void setMovil(Integer movil) {
		Movil = movil;
	}

	public String getDireccion() {
		return Direccion;
	}

	public void setDireccion(String direccion) {
		Direccion = direccion;
	}

	public String getLocalidad() {
		return Localidad;
	}

	public void setLocalidad(String localidad) {
		Localidad = localidad;
	}

	public String getProvincia() {
		return Provincia;
	}

	public void setProvincia(String provincia) {
		Provincia = provincia;
	}

	public Integer getCodigoPostal() {
		return CodigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		CodigoPostal = codigoPostal;
	}

	public Boolean getAlumnoMovilidad() {
		return AlumnoMovilidad;
	}

	public void setAlumnoMovilidad(Boolean alumnoMovilidad) {
		AlumnoMovilidad = alumnoMovilidad;
	}

	public List<Expedientes> getLista_expedientes() {
		return lista_expedientes;
	}

	public void setLista_expedientes(List<Expedientes> lista_expedientes) {
		this.lista_expedientes = lista_expedientes;
	}

	public List<Solicitud> getLista_solicitudes() {
		return lista_solicitudes;
	}

	public void setLista_solicitudes(List<Solicitud> lista_solicitudes) {
		this.lista_solicitudes = lista_solicitudes;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((AlumnoMovilidad == null) ? 0 : AlumnoMovilidad.hashCode());
		result = prime * result + ((CodigoPostal == null) ? 0 : CodigoPostal.hashCode());
		result = prime * result + ((DNI == null) ? 0 : DNI.hashCode());
		result = prime * result + ((Direccion == null) ? 0 : Direccion.hashCode());
		result = prime * result + ((Email_Institucional == null) ? 0 : Email_Institucional.hashCode());
		result = prime * result + ((Email_Personal == null) ? 0 : Email_Personal.hashCode());
		result = prime * result + ((ID == null) ? 0 : ID.hashCode());
		result = prime * result + ((Localidad == null) ? 0 : Localidad.hashCode());
		result = prime * result + ((Movil == null) ? 0 : Movil.hashCode());
		result = prime * result + ((Nombre_completo == null) ? 0 : Nombre_completo.hashCode());
		result = prime * result + ((Provincia == null) ? 0 : Provincia.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((grupos_asignados == null) ? 0 : grupos_asignados.hashCode());
		result = prime * result + ((lista_expedientes == null) ? 0 : lista_expedientes.hashCode());
		result = prime * result + ((lista_solicitudes == null) ? 0 : lista_solicitudes.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
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
		Alumno other = (Alumno) obj;
		if (AlumnoMovilidad == null) {
			if (other.AlumnoMovilidad != null)
				return false;
		} else if (!AlumnoMovilidad.equals(other.AlumnoMovilidad))
			return false;
		if (CodigoPostal == null) {
			if (other.CodigoPostal != null)
				return false;
		} else if (!CodigoPostal.equals(other.CodigoPostal))
			return false;
		if (DNI == null) {
			if (other.DNI != null)
				return false;
		} else if (!DNI.equals(other.DNI))
			return false;
		if (Direccion == null) {
			if (other.Direccion != null)
				return false;
		} else if (!Direccion.equals(other.Direccion))
			return false;
		if (Email_Institucional == null) {
			if (other.Email_Institucional != null)
				return false;
		} else if (!Email_Institucional.equals(other.Email_Institucional))
			return false;
		if (Email_Personal == null) {
			if (other.Email_Personal != null)
				return false;
		} else if (!Email_Personal.equals(other.Email_Personal))
			return false;
		if (ID == null) {
			if (other.ID != null)
				return false;
		} else if (!ID.equals(other.ID))
			return false;
		if (Localidad == null) {
			if (other.Localidad != null)
				return false;
		} else if (!Localidad.equals(other.Localidad))
			return false;
		if (Movil == null) {
			if (other.Movil != null)
				return false;
		} else if (!Movil.equals(other.Movil))
			return false;
		if (Nombre_completo == null) {
			if (other.Nombre_completo != null)
				return false;
		} else if (!Nombre_completo.equals(other.Nombre_completo))
			return false;
		if (Provincia == null) {
			if (other.Provincia != null)
				return false;
		} else if (!Provincia.equals(other.Provincia))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		if (grupos_asignados == null) {
			if (other.grupos_asignados != null)
				return false;
		} else if (!grupos_asignados.equals(other.grupos_asignados))
			return false;
		if (lista_expedientes == null) {
			if (other.lista_expedientes != null)
				return false;
		} else if (!lista_expedientes.equals(other.lista_expedientes))
			return false;
		if (lista_solicitudes == null) {
			if (other.lista_solicitudes != null)
				return false;
		} else if (!lista_solicitudes.equals(other.lista_solicitudes))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Alumno [ID=" + ID + ", DNI=" + DNI + ", Nombre_completo=" + Nombre_completo + ", Email_Institucional="
				+ Email_Institucional + ", Email_Personal=" + Email_Personal + ", Telefono=" + Telefono + ", Movil="
				+ Movil + ", Direccion=" + Direccion + ", Localidad=" + Localidad + ", Provincia=" + Provincia
				+ ", CodigoPostal=" + CodigoPostal + ", AlumnoMovilidad=" + AlumnoMovilidad + ", grupos_asignados="
				+ grupos_asignados + ", lista_expedientes=" + lista_expedientes + ", lista_solicitudes="
				+ lista_solicitudes + ", login=" + login + "]";
	}


	
}