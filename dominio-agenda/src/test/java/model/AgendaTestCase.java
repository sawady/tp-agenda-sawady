package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import junit.framework.TestCase;

public class AgendaTestCase {
	
	private Agenda agendaVacia;
	
	public Agenda getAgendaVacia() {
		return agendaVacia;
	}
	
	public void setAgendaVacia(Agenda agendaVacia) {
		this.agendaVacia = agendaVacia;
	}
	
	@Before
	public void setUp(){
		this.setAgendaVacia(new Agenda());
	}
	
	/**
	 * Un objeto agenda recien creado debe tener las listas
	 * de ciudades y de contactos vacías
	 */
	@Test
	public void agendaNuevaTieneListasVacias(){		
		assertTrue(this.getAgendaVacia().getCiudades().isEmpty());
		assertTrue(this.getAgendaVacia().getContactos().isEmpty());		
	}
	
}
