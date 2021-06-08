package es.uma.informatica.ejb.tarea2;

import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

import es.uma.informatica.jpa.tarea1.*;
import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;

/*Añadidos registrarUsuario a LoginEJB*/
@Stateless
public class LoginEJB implements GestionLogin{
 
	@SuppressWarnings("unused")
	private static final Logger LOG = Logger.getLogger(LoginEJB.class.getCanonicalName());
	
	@PersistenceContext(unitName="trabajo")
	private EntityManager em;
	
	public LoginEJB() {
		super();
	}
	  
	/**
     * Este método debe comprobar que el usuario que se le pasa como parámetro
     * es un usuario existente y con contraseña correcta (ya que estamos en la capa
     * de negocio con un Session Bean de tipo @Stateless, debemos comprobar
     * todos los accesos a la capa de nogocio). En caso negativo debe devolver debe devolver 
     * la excepción que corresponda,
     * en caso afirmativo debe devolver una entidad usuario tal con la información
     * existe ahora mismo en la BBDD.
     * @param u
     * @return 
	 * @throws Exception 
     *
    @Override
    public Login refrescarUsuario(Login u) throws TrabajoException {
    	compruebaLogin(u);
        Usuario user = em.find(Usuario.class, u.getCuenta());
        em.refresh(user);
        return user;

    }
    */
	   @Override
	    public void compruebaLogin(Login u) throws Exception {
		   
		   try{
			   Login user = em.find(Login.class, "a");
			}catch (PersistenceException e) {
			
				   throw new PersistenceException();
		}
		   //throw new UsuarioInexistenteException();
	        /*if (user == null) {
	            throw new UsuarioInexistenteException();
	        }


	        if (!user.getContrasena().equals(u.getContrasena())) {
	            throw new ContrasenaInvalidaException();
	        }*/

	    }
	

	
	
	@Override
	public Login refrescarLogin(Login l) throws Exception  {
		compruebaLogin(l);
		
		Login actual = em.find(Login.class, l.getnombreUsuario());
		em.refresh(actual);
		return actual;
	}

	@Override
	public String login(Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException {
		// TODO Auto-generated method stub
		return null;
	}

}
	