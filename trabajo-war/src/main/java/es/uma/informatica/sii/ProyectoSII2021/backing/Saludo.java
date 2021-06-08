package es.uma.informatica.sii.ProyectoSII2021.backing;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;


@Named
@RequestScoped
public class Saludo {
	
	String saludo = "Hola Mundo";
	
	public String getSaludo() {
		return saludo;
	}
}
