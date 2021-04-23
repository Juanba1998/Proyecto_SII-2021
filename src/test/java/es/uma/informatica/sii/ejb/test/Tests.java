package es.uma.informatica.sii.ejb.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.uma.informatica.ejb.tarea2.*;
import es.uma.informatica.sii.anotaciones.Requisitos;

public class Tests {
	
	private static final Logger LOG = Logger.getLogger(Tests.class.getCanonicalName());
	
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrabajoTest";
	
	private static final String EXCEL_EJB = "java:global/classes/ExcelEJB";
	private static final String EXPEDIENTES_EJB = "java:global/classes/ExpedientesEJB";
	private static final String GRUPOS_EJB = "java:global/classes/GrupoEJB";
	private static final String LOGIN_EJB = "java:global/classes/LoginEJB";
	private static final String SOLICITUD_EJB = "java:global/classes/SolicitudEJB";

	
	private static EJBContainer ejbContainer;
	private static Context ctx;

	private GestionExcel gestionExcel;
	private GestionExpedientes gestionExpedientes;
	private GestionGrupos gestionGrupos;
	private GestionLogin gestionLogin;
	private GestionSolicitud gestionSolicitud;
	
	@BeforeClass
	public static void setUpClass() {
		Properties properties = new Properties();
		properties.setProperty(GLASSFISH_CONFIGI_FILE_PROPERTY, CONFIG_FILE);
		ejbContainer = EJBContainer.createEJBContainer(properties);
		ctx = ejbContainer.getContext();
	}
	
	@Before
	public void setup() throws NamingException  {
		gestionExcel = (GestionExcel) ctx.lookup(EXCEL_EJB);
		gestionExpedientes = (GestionExpedientes) ctx.lookup(EXPEDIENTES_EJB);
		gestionGrupos = (GestionGrupos) ctx.lookup(GRUPOS_EJB);
		gestionLogin = (GestionLogin) ctx.lookup(LOGIN_EJB);
		gestionSolicitud = (GestionSolicitud) ctx.lookup(SOLICITUD_EJB);
		BaseDatos.inicializaBaseDatos(UNIDAD_PERSITENCIA_PRUEBAS);
	}
	
	@Requisitos({"RF7"})
	@Test
	public void testSolicitudDuplicada() {
		
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}
	
	
}
