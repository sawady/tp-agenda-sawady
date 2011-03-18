package model;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;

public class ContactoTestCase {
	
	private Contacto contactoSawaNuevo;
	private String nombreSawa = "sawa";
	private String telSawa = "4224";
	private String mailSawa = "sawa@gmail.com";	
	private Ciudad mock_ciudad;
	private DateTime mock_fecha;
	
	@Before
	public void setUp(){
		this.contactoSawaNuevo = new Contacto(this.nombreSawa, this.telSawa, this.mailSawa, 
				this.mock_fecha, this.mock_ciudad);
		
		this.mock_ciudad = mock(Ciudad.class);
		doReturn("quilmes").when(this.mock_ciudad).getNombre();
		
		this.mock_fecha = mock(DateTime.class);
	}

}
