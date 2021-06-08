package es.uma.informatica.sii.ProyectoSII2021.vista;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.LoginEJB;
import es.uma.informatica.jpa.tarea1.Login;
import es.uma.informatica.sii.ProyectoSII2021.backing.SessionUtils;


@Named(value = "loginVista")
@RequestScoped
public class LoginVista {
    //@Inject
    //private LoginEJB logEJB;

   @Inject
   private SessionUtils session;

   // private Login log;

    /**
     * Creates a new instance of login
     */
    public LoginVista() {
      // log = new Login();
    	
    }
/*
    public Login getUsuario() {
        return log;
    }

    public void setUsuario(Login usuario) {
        this.log = usuario;
    }
*/
    public String entrar() {
        
        
        	
        	return "alumnoInicio.xhtml";

    }
}