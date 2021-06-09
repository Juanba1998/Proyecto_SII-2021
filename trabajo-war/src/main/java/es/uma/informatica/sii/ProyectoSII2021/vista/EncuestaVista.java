package es.uma.informatica.sii.ProyectoSII2021.vista;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.tarea2.EncuestaEJB;
import es.uma.informatica.ejb.tarea2.GestionEncuesta;
import es.uma.informatica.jpa.tarea1.Encuesta;
import es.uma.informatica.jpa.tarea1.Expediente;
import es.uma.informatica.jpa.tarea1.Login;


@Named(value = "encuesta")
@RequestScoped
public class EncuestaVista {

	@Inject
    private GestionEncuesta encEJB;

    @Inject
    private SessionUtils session;
    private Encuesta enc;
    private Login log;
    private Expediente exp;
    
    
    
    
    public EncuestaVista() {
    	encEJB = new EncuestaEJB();
        enc = new Encuesta();
        log = new Login();
        exp = new Expediente();
    
    }
    
    

    //public EncuestaEJB getencEJB() {
	//	return encEJB;
	//}

	//public void setexp(EncuestaEJB encEJB) {
	//	this.encEJB = encEJB;
	//}
    
    
    public Expediente getexp() {
		return exp;
	}

	public void setexp(Expediente exp) {
		this.exp = exp;
	}

    public Encuesta getEnc() {
		return enc;
	}

	public void setEnc(Encuesta enc) {
		this.enc = enc;
	}

	public Login getLog() {
		return log;
	}

	public void setLog(Login log) {
		this.log = log;
	}



	public String enviar() throws TrabajoException {
        
		//enc.setFechaEnvio("hoy");
		//enc.setExpediente();
		//encEJB.aniadirEncuesta(log, enc);
        
        return "alumnoInicio.xhtml";
        
    }
}
