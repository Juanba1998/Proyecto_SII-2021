package es.uma.informatica.sii.ejb.test;

import java.util.Properties;
import java.util.logging.Logger;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import es.uma.informatica.ejb.tarea2.*;


public class Tests {
	
	private static final Logger LOG = Logger.getLogger(Tests.class.getCanonicalName());
	
	//private static final String PRODUCTOS_EJB = "java:global/classes/ProductosEJB";
	private static final String GLASSFISH_CONFIGI_FILE_PROPERTY = "org.glassfish.ejb.embedded.glassfish.configuration.file";
	private static final String CONFIG_FILE = "target/test-classes/META-INF/domain.xml";
	//private static final String LOTES_EJB = "java:global/classes/LotesEJB";
	//private static final String UNIDAD_PERSITENCIA_PRUEBAS = "TrazabilidadTest";
	
	private static EJBContainer ejbContainer;
	private static Context ctx;

	private GestionExcel gestionExcel;
	private GestionExpedientes gestionExpedientes;
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
		
	}
	
	@AfterClass
	public static void tearDownClass() {
		if (ejbContainer != null) {
			ejbContainer.close();
		}
	}
	
	
}
