package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import javax.persistence.*;

 
@SuppressWarnings("serial")
@Entity
public class Login implements Serializable {

	@Id //@GeneratedValue(strategy = GenerationType.AUTO)
	private String nombreUsuario;

	@Column(nullable = false)
	private String contrasena;
	
	//false indica personal de secretaria y true alumno
	@Column(nullable = false)
	private Boolean esAlumno;
	
	@OneToOne
	private Alumno alumno;

	public Login() {
		super();
	}

	public Login(String nombreUsuario, String contrasena, Boolean esAlumno) {
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
		this.esAlumno = esAlumno;
	}

	public String getnombreUsuario() {
		return nombreUsuario;
	}

	public void setnombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Boolean getEsAlumno() {
		return esAlumno;
	}

	public void setEsAlumno(Boolean esAlumno) {
		this.esAlumno = esAlumno;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Login){
        	Login log = (Login) obj;
            ok = (nombreUsuario == log.nombreUsuario) &&
            		contrasena.equalsIgnoreCase(log.contrasena) && esAlumno.equals(log.esAlumno);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return contrasena.hashCode() + esAlumno.hashCode() + nombreUsuario.hashCode();
	}

	@Override
	public String toString() {
		return "Login [nombreUsuario=" + nombreUsuario + ", contrasena=" + contrasena + ", esAlumno="
				+ esAlumno + "]";
	}
}
