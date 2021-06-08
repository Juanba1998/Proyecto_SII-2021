package es.uma.informatica.sii.ProyectoSII2021.vista;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.ejb.tarea2.GestionLogin;
import es.uma.informatica.ejb.tarea2.LoginEJB;
import es.uma.informatica.jpa.tarea1.Login;


@Named(value = "loginVista")
@RequestScoped
public class LoginVista {
    @Inject
    private GestionLogin logEjb;

   @Inject
   private SessionUtils session;

   private Login log;

    /**
     * Creates a new instance of login
     */
    public LoginVista() {
       log = new Login();
    	
    }

    public Login getLog() {
        return log;
    }

    public void setLog(Login log) {
        this.log = log;
    }

    public String entrar() {
    	
    	try {
            String type = logEjb.login(log);
            String dst = "alumno";
            session.setLog(logEjb.refrescarLogin(log));

            if(!type.equals("alumno")) {
                dst = "secretaria";
            }

            return "secretariaInicio.xhtml";

        } catch (UsuarioInexistenteException e) {
            FacesMessage fm = new FacesMessage("La cuenta no existe");
            FacesContext.getCurrentInstance().addMessage("login:user", fm);
        } catch (ContrasenaInvalidaException e) {
            FacesMessage fm = new FacesMessage("La contraseña no es correcta");
            FacesContext.getCurrentInstance().addMessage("login:psw", fm);

        } catch (TrabajoException e) {
            FacesMessage fm = new FacesMessage("Error: " + e);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }catch (Exception e) {
        	 FacesMessage fm = new FacesMessage("Error:" + e);
             FacesContext.getCurrentInstance().addMessage("login:user", fm);
		}
        return null;
        
    }
}