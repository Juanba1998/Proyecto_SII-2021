package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.String;
import javax.persistence.*;

@SuppressWarnings("serial")
@Entity
public class ExcelAsignaturas implements Serializable {
	
	//@Id @GeneratedValue(strategy = GenerationType.AUTO)
	//private Integer Codigo;

	@Column(nullable = false)
	private String Titulacion;
	
	@Column(nullable = false)
	private Boolean Ofertada;
	
	@Column(nullable = false)
	private Integer CodigoAsignatura;
	
	@Column(nullable = false)
	private String Referencia;
	
	@Column(nullable = false)
	private String NombreAsignatura;
	
	@Column(nullable = false)
	private String Curso;
	
	@Column(nullable = false)
	private String CreditosTeoria;
	
	@Column(nullable = false)
	private String CreditosPractica;
	
	@Column(nullable = false)
	private String CreditosTotales;
	
	@Column(nullable = false)
	private String Cuatrimestre;
	
	private String Plazas;
	private String OtroIdioma;
	
	public ExcelAsignaturas() {
		super();
	}
	
	public ExcelAsignaturas(String titulacion, Boolean ofertada, Integer codigoAsignatura, String referencia,
			String nombreAsignatura, String curso, String creditosTeoria, String creditosPractica,
			String creditosTotales, String cuatrimestre, String plazas, String otroIdioma) {
		super();
		Titulacion = titulacion;
		Ofertada = ofertada;
		CodigoAsignatura = codigoAsignatura;
		Referencia = referencia;
		NombreAsignatura = nombreAsignatura;
		Curso = curso;
		CreditosTeoria = creditosTeoria;
		CreditosPractica = creditosPractica;
		CreditosTotales = creditosTotales;
		Cuatrimestre = cuatrimestre;
		Plazas = plazas;
		OtroIdioma = otroIdioma;
	}
	
	public String getTitulacion() {
		return Titulacion;
	}
	
	public void setTitulacion(String titulacion) {
		Titulacion = titulacion;
	}
	
	public Boolean getOfertada() {
		return Ofertada;
	}
	
	public void setOfertada(Boolean ofertada) {
		Ofertada = ofertada;
	}
	
	public Integer getCodigoAsignatura() {
		return CodigoAsignatura;
	}
	
	public void setCodigoAsignatura(Integer codigoAsignatura) {
		CodigoAsignatura = codigoAsignatura;
	}
	
	public String getReferencia() {
		return Referencia;
	}
	
	public void setReferencia(String referencia) {
		Referencia = referencia;
	}
	
	public String getNombreAsignatura() {
		return NombreAsignatura;
	}
	
	public void setNombreAsignatura(String nombreAsignatura) {
		NombreAsignatura = nombreAsignatura;
	}
	
	public String getCurso() {
		return Curso;
	}
	
	public void setCurso(String curso) {
		Curso = curso;
	}
	
	public String getCreditosTeoria() {
		return CreditosTeoria;
	}
	
	public void setCreditosTeoria(String creditosTeoria) {
		CreditosTeoria = creditosTeoria;
	}
	
	public String getCreditosPractica() {
		return CreditosPractica;
	}
	
	public void setCreditosPractica(String creditosPractica) {
		CreditosPractica = creditosPractica;
	}
	
	public String getCreditosTotales() {
		return CreditosTotales;
	}
	
	public void setCreditosTotales(String creditosTotales) {
		CreditosTotales = creditosTotales;
	}
	
	public String getCuatrimestre() {
		return Cuatrimestre;
	}
	
	public void setCuatrimestre(String cuatrimestre) {
		Cuatrimestre = cuatrimestre;
	}
	
	public String getPlazas() {
		return Plazas;
	}
	
	public void setPlazas(String plazas) {
		Plazas = plazas;
	}
	
	public String getOtroIdioma() {
		return OtroIdioma;
	}
	
	public void setOtroIdioma(String otroIdioma) {
		OtroIdioma = otroIdioma;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CodigoAsignatura == null) ? 0 : CodigoAsignatura.hashCode());
		result = prime * result + ((CreditosPractica == null) ? 0 : CreditosPractica.hashCode());
		result = prime * result + ((CreditosTeoria == null) ? 0 : CreditosTeoria.hashCode());
		result = prime * result + ((CreditosTotales == null) ? 0 : CreditosTotales.hashCode());
		result = prime * result + ((Cuatrimestre == null) ? 0 : Cuatrimestre.hashCode());
		result = prime * result + ((Curso == null) ? 0 : Curso.hashCode());
		result = prime * result + ((NombreAsignatura == null) ? 0 : NombreAsignatura.hashCode());
		result = prime * result + ((Ofertada == null) ? 0 : Ofertada.hashCode());
		result = prime * result + ((OtroIdioma == null) ? 0 : OtroIdioma.hashCode());
		result = prime * result + ((Plazas == null) ? 0 : Plazas.hashCode());
		result = prime * result + ((Referencia == null) ? 0 : Referencia.hashCode());
		result = prime * result + ((Titulacion == null) ? 0 : Titulacion.hashCode());
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
		ExcelAsignaturas other = (ExcelAsignaturas) obj;
		if (CodigoAsignatura == null) {
			if (other.CodigoAsignatura != null)
				return false;
		} else if (!CodigoAsignatura.equals(other.CodigoAsignatura))
			return false;
		if (CreditosPractica == null) {
			if (other.CreditosPractica != null)
				return false;
		} else if (!CreditosPractica.equals(other.CreditosPractica))
			return false;
		if (CreditosTeoria == null) {
			if (other.CreditosTeoria != null)
				return false;
		} else if (!CreditosTeoria.equals(other.CreditosTeoria))
			return false;
		if (CreditosTotales == null) {
			if (other.CreditosTotales != null)
				return false;
		} else if (!CreditosTotales.equals(other.CreditosTotales))
			return false;
		if (Cuatrimestre == null) {
			if (other.Cuatrimestre != null)
				return false;
		} else if (!Cuatrimestre.equals(other.Cuatrimestre))
			return false;
		if (Curso == null) {
			if (other.Curso != null)
				return false;
		} else if (!Curso.equals(other.Curso))
			return false;
		if (NombreAsignatura == null) {
			if (other.NombreAsignatura != null)
				return false;
		} else if (!NombreAsignatura.equals(other.NombreAsignatura))
			return false;
		if (Ofertada == null) {
			if (other.Ofertada != null)
				return false;
		} else if (!Ofertada.equals(other.Ofertada))
			return false;
		if (OtroIdioma == null) {
			if (other.OtroIdioma != null)
				return false;
		} else if (!OtroIdioma.equals(other.OtroIdioma))
			return false;
		if (Plazas == null) {
			if (other.Plazas != null)
				return false;
		} else if (!Plazas.equals(other.Plazas))
			return false;
		if (Referencia == null) {
			if (other.Referencia != null)
				return false;
		} else if (!Referencia.equals(other.Referencia))
			return false;
		if (Titulacion == null) {
			if (other.Titulacion != null)
				return false;
		} else if (!Titulacion.equals(other.Titulacion))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "ExcelAsignaturas [Titulacion=" + Titulacion + ", Ofertada=" + Ofertada + ", CodigoAsignatura="
				+ CodigoAsignatura + ", Referencia=" + Referencia + ", NombreAsignatura=" + NombreAsignatura
				+ ", Curso=" + Curso + ", CreditosTeoria=" + CreditosTeoria + ", CreditosPractica=" + CreditosPractica
				+ ", CreditosTotales=" + CreditosTotales + ", Cuatrimestre=" + Cuatrimestre + ", Plazas=" + Plazas
				+ ", OtroIdioma=" + OtroIdioma + "]";
	}
	
   
}
