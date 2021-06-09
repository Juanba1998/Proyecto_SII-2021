package es.uma.informatica.sii.ProyectoSII2021.vista;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.SolicitudEJB;
import es.uma.informatica.jpa.tarea1.Solicitud;


@Named(value = "solicitud")
@RequestScoped
public class SolicitudVista {
    @Inject
    private SolicitudEJB solEJB;

    private Solicitud sol;

    private Date fecha;
    
    public SolicitudVista() {
        fecha = new Date();
        sol = new Solicitud();
    }
   
   
    public String enviar() {
        
        solEJB.aniadirSolicitud();
        
        return "alumnoInicio.xhtml";
        
    }
}
