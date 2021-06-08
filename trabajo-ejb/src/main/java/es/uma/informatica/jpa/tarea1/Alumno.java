package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class Alumno implements Serializable{
 
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private String dni;
	
	@Column(nullable = false)
	private String nombreCompleto;
	
	@Column(nullable = false)
	private String emailInstitucional;
	
	private String emailPersonal;
	private String telefono;
	private String movil;
	private String direccion;
	private String localidad;
	private String provincia;
	private Integer codigoPostal;
	private Boolean alumnoMovilidad;
	
	@Column
	@ElementCollection(targetClass=String.class)
	private List<String> gruposAsignados; 
	
	@OneToMany (mappedBy = "alumno", cascade= {CascadeType.PERSIST,CascadeType.REMOVE})
	private List<Expediente> listaExpedientes;
	
	@OneToMany (mappedBy = "alumno")
	private List<Solicitud> listaSolicitudes;
	
	@OneToOne(optional = false)
	private Login login;

	public Alumno() {
		super();
	}

	public Alumno(Integer id, String dni, String nombreCompleto, String emailInstitucional, String emailPersonal,
			String telefono, String movil, String direccion, String localidad, String provincia, Integer codigoPostal,
			Boolean alumnoMovilidad) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombreCompleto = nombreCompleto;
		this.emailInstitucional = emailInstitucional;
		this.emailPersonal = emailPersonal;
		this.telefono = telefono;
		this.movil = movil;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.codigoPostal = codigoPostal;
		this.alumnoMovilidad = alumnoMovilidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEmailInstitucional() {
		return emailInstitucional;
	}

	public void setEmailInstitucional(String emailInstitucional) {
		this.emailInstitucional = emailInstitucional;
	}

	public String getEmailPersonal() {
		return emailPersonal;
	}

	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public Integer getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(Integer codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public Boolean getAlumnoMovilidad() {
		return alumnoMovilidad;
	}

	public void setAlumnoMovilidad(Boolean alumnoMovilidad) {
		this.alumnoMovilidad = alumnoMovilidad;
	}

	public List<String> getGruposAsignados() {
		return gruposAsignados;
	}

	public void setGruposAsignados(List<String> gruposAsignados) {
		this.gruposAsignados = gruposAsignados;
	}

	public List<Expediente> getListaExpedientes() {
		return listaExpedientes;
	}

	public void setListaExpedientes(List<Expediente> listaExpedientes) {
		this.listaExpedientes = listaExpedientes;
	}

	public List<Solicitud> getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(List<Solicitud> listaSolicitudes) {
		this.listaSolicitudes = listaSolicitudes;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
		
	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Alumno){
            Alumno al = (Alumno) obj;
            ok = (id == al.id) && dni.equalsIgnoreCase(al.dni) && nombreCompleto.equalsIgnoreCase(al.nombreCompleto) &&
            		emailInstitucional.equalsIgnoreCase(al.emailInstitucional);
        }
        
        return ok;
		
	}

	@Override
	public int hashCode() {
		return id.hashCode() + dni.hashCode() + nombreCompleto.hashCode() + emailInstitucional.hashCode();
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", dni=" + dni + ", nombreCompleto=" + nombreCompleto + ", emailInstitucional="
				+ emailInstitucional + ", emailPersonal=" + emailPersonal + ", telefono=" + telefono + ", movil="
				+ movil + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia=" + provincia
				+ ", codigoPostal=" + codigoPostal + ", alumnoMovilidad=" + alumnoMovilidad + "]";
	}
}