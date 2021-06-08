package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import javax.persistence.*;
 
@SuppressWarnings("serial")
@Entity
public class Login implements Serializable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(nullable = false, unique = true)
	private String usuario;
	
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

	public Login(Integer codigo, String usuario, String contrasena, Boolean esAlumno) {
		this.codigo = codigo;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.esAlumno = esAlumno;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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
            ok = (codigo == log.codigo) && usuario.equalsIgnoreCase(log.usuario) &&
            		contrasena.equalsIgnoreCase(log.contrasena) && esAlumno.equals(log.esAlumno);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return usuario.hashCode() + contrasena.hashCode() + esAlumno.hashCode() + codigo.hashCode();
	}

	@Override
	public String toString() {
		return "Login [codigo=" + codigo + ", usuario=" + usuario + ", contrasena=" + contrasena + ", esAlumno="
				+ esAlumno + "]";
	}
}
