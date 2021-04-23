package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;
 
@SuppressWarnings("serial")
@Entity
public class Login implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Codigo;
	
	@Column(nullable = false)
	private String Usuario;
	
	@Column(nullable = false)
	private String Contrasena;
	
	//false indica personal de secretaria y true alumno
	@Column(nullable = false)
	private Boolean esAlumno;
	
	@OneToOne
	private Alumno alumno;

	public Login() {
		super();
	}

	public Login(Integer codigo, String usuario, String contrasena, Boolean esAlumno, Alumno alumno) {
		super();
		Codigo = codigo;
		Usuario = usuario;
		Contrasena = contrasena;
		this.esAlumno = esAlumno;
		this.alumno = alumno;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public void setCodigo(Integer codigo) {
		Codigo = codigo;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getContrasena() {
		return Contrasena;
	}

	public void setContrasena(String contrasena) {
		Contrasena = contrasena;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Codigo == null) ? 0 : Codigo.hashCode());
		result = prime * result + ((Contrasena == null) ? 0 : Contrasena.hashCode());
		result = prime * result + ((Usuario == null) ? 0 : Usuario.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
		result = prime * result + ((esAlumno == null) ? 0 : esAlumno.hashCode());
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
		Login other = (Login) obj;
		if (Codigo == null) {
			if (other.Codigo != null)
				return false;
		} else if (!Codigo.equals(other.Codigo))
			return false;
		if (Contrasena == null) {
			if (other.Contrasena != null)
				return false;
		} else if (!Contrasena.equals(other.Contrasena))
			return false;
		if (Usuario == null) {
			if (other.Usuario != null)
				return false;
		} else if (!Usuario.equals(other.Usuario))
			return false;
		if (alumno == null) {
			if (other.alumno != null)
				return false;
		} else if (!alumno.equals(other.alumno))
			return false;
		if (esAlumno == null) {
			if (other.esAlumno != null)
				return false;
		} else if (!esAlumno.equals(other.esAlumno))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Login [Codigo=" + Codigo + ", Usuario=" + Usuario + ", Contrasena=" + Contrasena + ", esAlumno="
				+ esAlumno + ", alumno=" + alumno + "]";
	}

	
}
