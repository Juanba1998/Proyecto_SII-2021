package es.uma.informatica.ejb.tarea2;

import javax.ejb.Local;

import es.uma.informatica.ejb.excepciones.ContrasenaInvalidaException;
import es.uma.informatica.ejb.excepciones.LoginException;
import es.uma.informatica.ejb.excepciones.TrabajoException;
import es.uma.informatica.ejb.excepciones.UsuarioInexistenteException;
import es.uma.informatica.jpa.tarea1.*;

@Local
public interface GestionLogin {
	
	public String login (Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException;
	
	public Login refrescarLogin (Login l) throws LoginException, UsuarioInexistenteException, ContrasenaInvalidaException, TrabajoException, Exception;

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
	void compruebaLogin(Login u) throws TrabajoException, Exception;
}
