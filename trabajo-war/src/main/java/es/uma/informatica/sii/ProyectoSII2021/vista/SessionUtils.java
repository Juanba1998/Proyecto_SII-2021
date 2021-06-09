package es.uma.informatica.sii.ProyectoSII2021.vista;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.*;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.GestionLogin;

import es.uma.informatica.jpa.tarea1.Login;

@Named(value = "sessionUtils")
@SessionScoped
public class SessionUtils implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private GestionLogin logEjb;
    private Login log;
	
	
	public SessionUtils() {
    }

    public synchronized void setLog(Login log) {
        this.log = log;
    }

    public synchronized Login getLog() {
        return log;
    }
    
   
    
    public synchronized String invalidarSesion()
    {
        if (log != null)
        {
            log = null;
            FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        }
        return "login.xhtml";
    }
    
    public synchronized void refrescarUsuario() throws TrabajoException
    {
        
        if (log != null)
        {
            log = logEjb.refrescarLogin(log);
           
        } 
        
        
    }
    
}

