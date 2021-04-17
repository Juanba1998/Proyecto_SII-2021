package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;


@SuppressWarnings("serial")
@Entity
public class ExcelAlumnos implements Serializable {
	
	//@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer Codigo;
	
	private String CursoAcademico;
	private String TipoEstudio;
	private String EstadoMatricula;	
	private String Documento;
	private String Nombre;
	private String PrimerApellido;
	private String SegundoApellido;
	private Integer NumExpediente;
	private Integer NumArchivo;
	private String Email_institucional;
	private String Email_personal;
	private String Telefono;
	private String Movil;
	private String Direccion_notificacion;
	private String Localidad_notificacion;
	private String Provincia_notificacion;
	private String CP_notificacion;
	private Date Fecha_matriculacion;
	private String Turno_preferente;
	private String Grupo_asignado;
	private Double Nota_media;
	private Integer Creditos_superados;
	private Integer Creditos_FB;
	private Integer Creditos_OB;
	private Integer Creditos_OP;
	private Integer Creditos_CF;
	private Integer Creditos_PE;
	private Integer Creditos_TF;
	
	public ExcelAlumnos() {
		super();
	}

	public ExcelAlumnos(String cursoAcademico, String tipoEstudio, String estadoMatricula, String documento,
			String nombre, String primerApellido, String segundoApellido, Integer numExpediente, Integer numArchivo,
			String email_institucional, String email_personal, String telefono, String movil,
			String direccion_notificacion, String localidad_notificacion, String provincia_notificacion,
			String cP_notificacion, Date fecha_matriculacion, String turno_preferente, String grupo_asignado,
			Double nota_media, Integer creditos_superados, Integer creditos_FB, Integer creditos_OB,
			Integer creditos_OP, Integer creditos_CF, Integer creditos_PE, Integer creditos_TF) {
		super();
		CursoAcademico = cursoAcademico;
		TipoEstudio = tipoEstudio;
		EstadoMatricula = estadoMatricula;
		Documento = documento;
		Nombre = nombre;
		PrimerApellido = primerApellido;
		SegundoApellido = segundoApellido;
		NumExpediente = numExpediente;
		NumArchivo = numArchivo;
		Email_institucional = email_institucional;
		Email_personal = email_personal;
		Telefono = telefono;
		Movil = movil;
		Direccion_notificacion = direccion_notificacion;
		Localidad_notificacion = localidad_notificacion;
		Provincia_notificacion = provincia_notificacion;
		CP_notificacion = cP_notificacion;
		Fecha_matriculacion = fecha_matriculacion;
		Turno_preferente = turno_preferente;
		Grupo_asignado = grupo_asignado;
		Nota_media = nota_media;
		Creditos_superados = creditos_superados;
		Creditos_FB = creditos_FB;
		Creditos_OB = creditos_OB;
		Creditos_OP = creditos_OP;
		Creditos_CF = creditos_CF;
		Creditos_PE = creditos_PE;
		Creditos_TF = creditos_TF;
	}

	public String getCursoAcademico() {
		return CursoAcademico;
	}

	public void setCursoAcademico(String cursoAcademico) {
		CursoAcademico = cursoAcademico;
	}

	public String getTipoEstudio() {
		return TipoEstudio;
	}

	public void setTipoEstudio(String tipoEstudio) {
		TipoEstudio = tipoEstudio;
	}

	public String getEstadoMatricula() {
		return EstadoMatricula;
	}

	public void setEstadoMatricula(String estadoMatricula) {
		EstadoMatricula = estadoMatricula;
	}

	public String getDocumento() {
		return Documento;
	}

	public void setDocumento(String documento) {
		Documento = documento;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getPrimerApellido() {
		return PrimerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		PrimerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return SegundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		SegundoApellido = segundoApellido;
	}

	public Integer getNumExpediente() {
		return NumExpediente;
	}

	public void setNumExpediente(Integer numExpediente) {
		NumExpediente = numExpediente;
	}

	public Integer getNumArchivo() {
		return NumArchivo;
	}

	public void setNumArchivo(Integer numArchivo) {
		NumArchivo = numArchivo;
	}

	public String getEmail_institucional() {
		return Email_institucional;
	}

	public void setEmail_institucional(String email_institucional) {
		Email_institucional = email_institucional;
	}

	public String getEmail_personal() {
		return Email_personal;
	}

	public void setEmail_personal(String email_personal) {
		Email_personal = email_personal;
	}

	public String getTelefono() {
		return Telefono;
	}

	public void setTelefono(String telefono) {
		Telefono = telefono;
	}

	public String getMovil() {
		return Movil;
	}

	public void setMovil(String movil) {
		Movil = movil;
	}

	public String getDireccion_notificacion() {
		return Direccion_notificacion;
	}

	public void setDireccion_notificacion(String direccion_notificacion) {
		Direccion_notificacion = direccion_notificacion;
	}

	public String getLocalidad_notificacion() {
		return Localidad_notificacion;
	}

	public void setLocalidad_notificacion(String localidad_notificacion) {
		Localidad_notificacion = localidad_notificacion;
	}

	public String getProvincia_notificacion() {
		return Provincia_notificacion;
	}

	public void setProvincia_notificacion(String provincia_notificacion) {
		Provincia_notificacion = provincia_notificacion;
	}

	public String getCP_notificacion() {
		return CP_notificacion;
	}

	public void setCP_notificacion(String cP_notificacion) {
		CP_notificacion = cP_notificacion;
	}

	public Date getFecha_matriculacion() {
		return Fecha_matriculacion;
	}

	public void setFecha_matriculacion(Date fecha_matriculacion) {
		Fecha_matriculacion = fecha_matriculacion;
	}

	public String getTurno_preferente() {
		return Turno_preferente;
	}

	public void setTurno_preferente(String turno_preferente) {
		Turno_preferente = turno_preferente;
	}

	public String getGrupo_asignado() {
		return Grupo_asignado;
	}

	public void setGrupo_asignado(String grupo_asignado) {
		Grupo_asignado = grupo_asignado;
	}

	public Double getNota_media() {
		return Nota_media;
	}

	public void setNota_media(Double nota_media) {
		Nota_media = nota_media;
	}

	public Integer getCreditos_superados() {
		return Creditos_superados;
	}

	public void setCreditos_superados(Integer creditos_superados) {
		Creditos_superados = creditos_superados;
	}

	public Integer getCreditos_FB() {
		return Creditos_FB;
	}

	public void setCreditos_FB(Integer creditos_FB) {
		Creditos_FB = creditos_FB;
	}

	public Integer getCreditos_OB() {
		return Creditos_OB;
	}

	public void setCreditos_OB(Integer creditos_OB) {
		Creditos_OB = creditos_OB;
	}

	public Integer getCreditos_OP() {
		return Creditos_OP;
	}

	public void setCreditos_OP(Integer creditos_OP) {
		Creditos_OP = creditos_OP;
	}

	public Integer getCreditos_CF() {
		return Creditos_CF;
	}

	public void setCreditos_CF(Integer creditos_CF) {
		Creditos_CF = creditos_CF;
	}

	public Integer getCreditos_PE() {
		return Creditos_PE;
	}

	public void setCreditos_PE(Integer creditos_PE) {
		Creditos_PE = creditos_PE;
	}

	public Integer getCreditos_TF() {
		return Creditos_TF;
	}

	public void setCreditos_TF(Integer creditos_TF) {
		Creditos_TF = creditos_TF;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CP_notificacion == null) ? 0 : CP_notificacion.hashCode());
		result = prime * result + ((Creditos_CF == null) ? 0 : Creditos_CF.hashCode());
		result = prime * result + ((Creditos_FB == null) ? 0 : Creditos_FB.hashCode());
		result = prime * result + ((Creditos_OB == null) ? 0 : Creditos_OB.hashCode());
		result = prime * result + ((Creditos_OP == null) ? 0 : Creditos_OP.hashCode());
		result = prime * result + ((Creditos_PE == null) ? 0 : Creditos_PE.hashCode());
		result = prime * result + ((Creditos_TF == null) ? 0 : Creditos_TF.hashCode());
		result = prime * result + ((Creditos_superados == null) ? 0 : Creditos_superados.hashCode());
		result = prime * result + ((CursoAcademico == null) ? 0 : CursoAcademico.hashCode());
		result = prime * result + ((Direccion_notificacion == null) ? 0 : Direccion_notificacion.hashCode());
		result = prime * result + ((Documento == null) ? 0 : Documento.hashCode());
		result = prime * result + ((Email_institucional == null) ? 0 : Email_institucional.hashCode());
		result = prime * result + ((Email_personal == null) ? 0 : Email_personal.hashCode());
		result = prime * result + ((EstadoMatricula == null) ? 0 : EstadoMatricula.hashCode());
		result = prime * result + ((Fecha_matriculacion == null) ? 0 : Fecha_matriculacion.hashCode());
		result = prime * result + ((Grupo_asignado == null) ? 0 : Grupo_asignado.hashCode());
		result = prime * result + ((Localidad_notificacion == null) ? 0 : Localidad_notificacion.hashCode());
		result = prime * result + ((Movil == null) ? 0 : Movil.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
		result = prime * result + ((Nota_media == null) ? 0 : Nota_media.hashCode());
		result = prime * result + ((NumArchivo == null) ? 0 : NumArchivo.hashCode());
		result = prime * result + ((NumExpediente == null) ? 0 : NumExpediente.hashCode());
		result = prime * result + ((PrimerApellido == null) ? 0 : PrimerApellido.hashCode());
		result = prime * result + ((Provincia_notificacion == null) ? 0 : Provincia_notificacion.hashCode());
		result = prime * result + ((SegundoApellido == null) ? 0 : SegundoApellido.hashCode());
		result = prime * result + ((Telefono == null) ? 0 : Telefono.hashCode());
		result = prime * result + ((TipoEstudio == null) ? 0 : TipoEstudio.hashCode());
		result = prime * result + ((Turno_preferente == null) ? 0 : Turno_preferente.hashCode());
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
		ExcelAlumnos other = (ExcelAlumnos) obj;
		if (CP_notificacion == null) {
			if (other.CP_notificacion != null)
				return false;
		} else if (!CP_notificacion.equals(other.CP_notificacion))
			return false;
		if (Creditos_CF == null) {
			if (other.Creditos_CF != null)
				return false;
		} else if (!Creditos_CF.equals(other.Creditos_CF))
			return false;
		if (Creditos_FB == null) {
			if (other.Creditos_FB != null)
				return false;
		} else if (!Creditos_FB.equals(other.Creditos_FB))
			return false;
		if (Creditos_OB == null) {
			if (other.Creditos_OB != null)
				return false;
		} else if (!Creditos_OB.equals(other.Creditos_OB))
			return false;
		if (Creditos_OP == null) {
			if (other.Creditos_OP != null)
				return false;
		} else if (!Creditos_OP.equals(other.Creditos_OP))
			return false;
		if (Creditos_PE == null) {
			if (other.Creditos_PE != null)
				return false;
		} else if (!Creditos_PE.equals(other.Creditos_PE))
			return false;
		if (Creditos_TF == null) {
			if (other.Creditos_TF != null)
				return false;
		} else if (!Creditos_TF.equals(other.Creditos_TF))
			return false;
		if (Creditos_superados == null) {
			if (other.Creditos_superados != null)
				return false;
		} else if (!Creditos_superados.equals(other.Creditos_superados))
			return false;
		if (CursoAcademico == null) {
			if (other.CursoAcademico != null)
				return false;
		} else if (!CursoAcademico.equals(other.CursoAcademico))
			return false;
		if (Direccion_notificacion == null) {
			if (other.Direccion_notificacion != null)
				return false;
		} else if (!Direccion_notificacion.equals(other.Direccion_notificacion))
			return false;
		if (Documento == null) {
			if (other.Documento != null)
				return false;
		} else if (!Documento.equals(other.Documento))
			return false;
		if (Email_institucional == null) {
			if (other.Email_institucional != null)
				return false;
		} else if (!Email_institucional.equals(other.Email_institucional))
			return false;
		if (Email_personal == null) {
			if (other.Email_personal != null)
				return false;
		} else if (!Email_personal.equals(other.Email_personal))
			return false;
		if (EstadoMatricula == null) {
			if (other.EstadoMatricula != null)
				return false;
		} else if (!EstadoMatricula.equals(other.EstadoMatricula))
			return false;
		if (Fecha_matriculacion == null) {
			if (other.Fecha_matriculacion != null)
				return false;
		} else if (!Fecha_matriculacion.equals(other.Fecha_matriculacion))
			return false;
		if (Grupo_asignado == null) {
			if (other.Grupo_asignado != null)
				return false;
		} else if (!Grupo_asignado.equals(other.Grupo_asignado))
			return false;
		if (Localidad_notificacion == null) {
			if (other.Localidad_notificacion != null)
				return false;
		} else if (!Localidad_notificacion.equals(other.Localidad_notificacion))
			return false;
		if (Movil == null) {
			if (other.Movil != null)
				return false;
		} else if (!Movil.equals(other.Movil))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		if (Nota_media == null) {
			if (other.Nota_media != null)
				return false;
		} else if (!Nota_media.equals(other.Nota_media))
			return false;
		if (NumArchivo == null) {
			if (other.NumArchivo != null)
				return false;
		} else if (!NumArchivo.equals(other.NumArchivo))
			return false;
		if (NumExpediente == null) {
			if (other.NumExpediente != null)
				return false;
		} else if (!NumExpediente.equals(other.NumExpediente))
			return false;
		if (PrimerApellido == null) {
			if (other.PrimerApellido != null)
				return false;
		} else if (!PrimerApellido.equals(other.PrimerApellido))
			return false;
		if (Provincia_notificacion == null) {
			if (other.Provincia_notificacion != null)
				return false;
		} else if (!Provincia_notificacion.equals(other.Provincia_notificacion))
			return false;
		if (SegundoApellido == null) {
			if (other.SegundoApellido != null)
				return false;
		} else if (!SegundoApellido.equals(other.SegundoApellido))
			return false;
		if (Telefono == null) {
			if (other.Telefono != null)
				return false;
		} else if (!Telefono.equals(other.Telefono))
			return false;
		if (TipoEstudio == null) {
			if (other.TipoEstudio != null)
				return false;
		} else if (!TipoEstudio.equals(other.TipoEstudio))
			return false;
		if (Turno_preferente == null) {
			if (other.Turno_preferente != null)
				return false;
		} else if (!Turno_preferente.equals(other.Turno_preferente))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ExcelAlumnos [CursoAcademico=" + CursoAcademico + ", TipoEstudio=" + TipoEstudio + ", EstadoMatricula="
				+ EstadoMatricula + ", Documento=" + Documento + ", Nombre=" + Nombre + ", PrimerApellido="
				+ PrimerApellido + ", SegundoApellido=" + SegundoApellido + ", NumExpediente=" + NumExpediente
				+ ", NumArchivo=" + NumArchivo + ", Email_institucional=" + Email_institucional + ", Email_personal="
				+ Email_personal + ", Telefono=" + Telefono + ", Movil=" + Movil + ", Direccion_notificacion="
				+ Direccion_notificacion + ", Localidad_notificacion=" + Localidad_notificacion
				+ ", Provincia_notificacion=" + Provincia_notificacion + ", CP_notificacion=" + CP_notificacion
				+ ", Fecha_matriculacion=" + Fecha_matriculacion + ", Turno_preferente=" + Turno_preferente
				+ ", Grupo_asignado=" + Grupo_asignado + ", Nota_media=" + Nota_media + ", Creditos_superados="
				+ Creditos_superados + ", Creditos_FB=" + Creditos_FB + ", Creditos_OB=" + Creditos_OB
				+ ", Creditos_OP=" + Creditos_OP + ", Creditos_CF=" + Creditos_CF + ", Creditos_PE=" + Creditos_PE
				+ ", Creditos_TF=" + Creditos_TF + "]";
	}

	
}
