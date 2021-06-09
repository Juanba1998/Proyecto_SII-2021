package es.uma.informatica.sii.ProyectoSII2021.vista;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.GestionSolicitud;
import es.uma.informatica.ejb.tarea2.SolicitudEJB;
import es.uma.informatica.jpa.tarea1.Alumno;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.jpa.tarea1.Solicitud;


@Named(value = "solicitud")
@RequestScoped
public class SolicitudVista {
    @Inject
    private GestionSolicitud solEJB;

    @Inject
    private SessionUtils session;
    
    private Solicitud sol;
    private Alumno alu;
    private Login log;

    
    public SolicitudVista() {
        sol = new Solicitud();
    }
    

    public Solicitud getSol() {
		return sol;
	}

	public void setSol(Solicitud sol) {
		this.sol = sol;
	}
	
	

	public String enviar() throws TrabajoException {
        
		sol.setCodigo(123);
		sol.setFechaSolicitud(new Date());
		sol.setAlumno(alu);
        solEJB.aniadirSolicitud(log,sol);
        
        return "alumnoInicio.xhtml";
        
    }
}
