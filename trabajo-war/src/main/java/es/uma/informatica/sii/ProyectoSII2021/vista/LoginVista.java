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


@Named(value = "login")
@RequestScoped
public class LoginVista {
    @Inject
    private LoginEJB logEJB;

    //@Inject
    //private InfoSesion sesion;

    private Login log;

    /**
     * Creates a new instance of login
     */
    public LoginVista() {
        log = new Login();
    }

    public Login getUsuario() {
        return log;
    }

    public void setUsuario(Login usuario) {
        this.log = usuario;
    }

    public String entrar() {
        try {
        	String type = logEJB.login(log);
        	String dst = "alumno";
        	//sesion.setUsuario(negocio.refrescarUsuario(log));
            
        	if(!type.equals("alumno")) {
            	dst = "secretaria";
            }
        	
        	return "";

        } catch (UsuarioInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContrasenaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:pass", fm);
        
        } catch (TrabajoException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }
        return null;
    }
}
