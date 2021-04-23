package es.uma.informatica.ejb.excepciones;

@SuppressWarnings("serial")
public class TrabajoException extends Exception{
	
	public TrabajoException () {};
	
	public TrabajoException(String m) {
		super(m);
	}

}
