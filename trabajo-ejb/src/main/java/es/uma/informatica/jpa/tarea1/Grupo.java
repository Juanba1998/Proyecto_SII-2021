package es.uma.informatica.jpa.tarea1;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
 
@SuppressWarnings("serial")
@Entity
public class Grupo implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private String curso;
	
	@Column(unique = true)
	private String letra;
	
	@Column(nullable = false)
	private String turno;
	
	@Column(nullable = false)
	private Boolean ingles;
	
	private Boolean visible;
	private String asignar;
	private Integer plazas;

	@ManyToOne(optional=false)
	private Titulacion titulacion;
	
	@OneToMany(mappedBy="grupo")
	private List<Clase> clase;
	
	@OneToMany(mappedBy="grupo")
	private List<GrupoPorAsignatura> grupoPorAsignatura;

	@OneToMany(mappedBy = "grupo")
	private List<AsignaturasMatricula> asignaturasMatricula;
	
	@OneToMany(mappedBy = "grupoReflex")
	private List<Grupo> gruposGrupo;
	
	@ManyToOne
	private Grupo grupoReflex;

	public Grupo() {
		super();
	}

	public Grupo(Integer id, String curso, String letra, String turno, Boolean ingles, Boolean visible, String asignar, Integer plazas) {
		this.id = id;
		this.curso = curso;
		this.letra = letra;
		this.turno = turno;
		this.ingles = ingles;
		this.visible = visible;
		this.asignar = asignar;
		this.plazas = plazas;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Boolean getIngles() {
		return ingles;
	}

	public void setIngles(Boolean ingles) {
		this.ingles = ingles;
	}

	public Boolean getVisible() {
		return visible;
	}

	public void setVisible(Boolean visible) {
		this.visible = visible;
	}

	public String getAsignar() {
		return asignar;
	}

	public void setAsignar(String asignar) {
		this.asignar = asignar;
	}

	public Integer getPlazas() {
		return plazas;
	}

	public void setPlazas(Integer plazas) {
		this.plazas = plazas;
	}

	public Titulacion getTitulacion() {
		return titulacion;
	}

	public void setTitulacion(Titulacion titulacion) {
		this.titulacion = titulacion;
	}

	public List<Clase> getClase() {
		return clase;
	}

	public void setClase(List<Clase> clase) {
		this.clase = clase;
	}

	public List<GrupoPorAsignatura> getGrupoPorAsignatura() {
		return grupoPorAsignatura;
	}

	public void setGrupoPorAsignatura(List<GrupoPorAsignatura> grupoPorAsignatura) {
		this.grupoPorAsignatura = grupoPorAsignatura;
	}

	public List<AsignaturasMatricula> getAsignaturasMatricula() {
		return asignaturasMatricula;
	}

	public void setAsignaturasMatricula(List<AsignaturasMatricula> asignaturasMatricula) {
		this.asignaturasMatricula = asignaturasMatricula;
	}

	public List<Grupo> getGruposGrupo() {
		return gruposGrupo;
	}

	public void setGruposGrupo(List<Grupo> gruposGrupo) {
		this.gruposGrupo = gruposGrupo;
	}

	public Grupo getGrupoReflex() {
		return grupoReflex;
	}

	public void setGrupoReflex(Grupo grupoReflex) {
		this.grupoReflex = grupoReflex;
	}

	@Override
	public boolean equals(Object obj) {
		boolean ok = false;
		
        if(obj instanceof Grupo){
        	Grupo gr = (Grupo) obj;
            ok = (id == gr.id) && turno.equalsIgnoreCase(gr.turno) && curso.equalsIgnoreCase(gr.curso) && letra.equalsIgnoreCase(gr.letra)
            		&& ingles.equals(gr.ingles);
        }
        
        return ok;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode() + turno.hashCode() + curso.hashCode() + letra.hashCode() + ingles.hashCode();
		
	}

	@Override
	public String toString() {
		return "Grupo [id=" + id + ", curso=" + curso + ", letra=" + letra + ", turno=" + turno + ", ingles=" + ingles
				+ ", visible=" + visible + ", asignar=" + asignar + ", plazas=" + plazas + "]";
	}
}