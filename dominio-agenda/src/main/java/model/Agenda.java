package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Agrega, elimina y organiza ciudades, contactos y eventos
 * @author sawady
 *
 */
public class Agenda {
	
	List<Ciudad> ciudades = new ArrayList<Ciudad>();
	List<Contacto> contactos = new ArrayList<Contacto>();
	List<Evento> eventos = new ArrayList<Evento>();
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}
	
	public List<Contacto> getContactos() {
		return contactos;
	}
	
	public void agregarContacto(Contacto contacto){
		this.getContactos().add(contacto);		
	}
	
	public void eliminarContacto(Contacto contacto){
		this.getContactos().remove(contacto);		
	}
	
	public void agregarCiudad(Ciudad ciudad){
		this.getCiudades().add(ciudad);
	}
	
	public void eliminarCiudad(Ciudad ciudad){
		this.getCiudades().remove(ciudad);
	}
	
	public void agregarEvento(Evento evento){
		this.getEventos().add(evento);
	}
		public void eliminarEvento(Evento evento){
		this.getEventos().remove(evento);
	}
	
}
