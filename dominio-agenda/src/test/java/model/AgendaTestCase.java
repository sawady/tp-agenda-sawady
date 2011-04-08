package model;

import homes.Agenda;

public class AgendaTestCase {
	
	private Agenda agendaVacia;
	
	public Agenda getAgendaVacia() {
		return agendaVacia;
	}
	
	public void setAgendaVacia(Agenda agendaVacia) {
		this.agendaVacia = agendaVacia;
	}
	
//	@Before
//	public void setUp(){
//		this.setAgendaVacia(new Agenda(null));
//	}
//	
//	/**
//	 * Un objeto agenda recien creado debe tener las listas
//	 * de ciudades y de contactos vacías
//	 */
//	@Test
//	public void agendaNuevaTieneListasVacias(){		
//		assertTrue(this.getAgendaVacia().getCiudades().isEmpty());
//		assertTrue(this.getAgendaVacia().getContactos().isEmpty());		
//	}
	
}
