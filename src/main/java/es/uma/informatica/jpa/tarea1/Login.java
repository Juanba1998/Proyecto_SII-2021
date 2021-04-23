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
	
	@Column(nullable = false)
	private Integer Tipo;
	
	@OneToOne
	private Alumno alumno;

	public Login() {
		super();
	}

	public Login(Integer codigo, String usuario, String contrasena, Integer tipo, Alumno alumno) {
		super();
		Codigo = codigo;
		Usuario = usuario;
		Contrasena = contrasena;
		Tipo = tipo;
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
	
	//0 es para personal de secretaria y 1 para alumno
	public Integer getTipo() {
		return Tipo;
	}

	public void setTipo(Integer tipo) {
		Tipo = tipo;
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
		result = prime * result + ((Tipo == null) ? 0 : Tipo.hashCode());
		result = prime * result + ((Usuario == null) ? 0 : Usuario.hashCode());
		result = prime * result + ((alumno == null) ? 0 : alumno.hashCode());
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
		if (Tipo == null) {
			if (other.Tipo != null)
				return false;
		} else if (!Tipo.equals(other.Tipo))
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
		return true;
	}

	@Override
	public String toString() {
		return "Login [Codigo=" + Codigo + ", Usuario=" + Usuario + ", Contrasena=" + Contrasena + ", Tipo=" + Tipo
				+ ", alumno=" + alumno + "]";
	}

}
