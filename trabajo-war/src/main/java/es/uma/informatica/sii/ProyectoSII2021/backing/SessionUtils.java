package es.uma.informatica.sii.ProyectoSII2021.backing;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.*;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.LoginEJB;
import es.uma.informatica.jpa.tarea1.Login;

@Named(value = "sessionUtils")
@SessionScoped
public class SessionUtils {
	@Inject
	private LoginEJB logEjb;
    private Login log;
	
	
	public SessionUtils() {
    }

    public synchronized void setLog(Login log) {
        this.log = log;
    }

    public synchronized Login getUsuario() {
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
    
    public synchronized void refrescarUsuario() throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException
    {
        
        if (log != null)
        {
            log = logEjb.refrescarLogin(log);
           
        } 
        
        
    }
    
}

