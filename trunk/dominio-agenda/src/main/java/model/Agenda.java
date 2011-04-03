package model;

import java.util.ArrayList;
import java.util.List;

import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.ObservableObject;

/**
 * Agrega, elimina y actualiza ciudades, contactos y eventos
 * @author sawady
 *
 */
public class Agenda extends ObservableObject {
	
	public static final String ELIMINAR_EVENTO = "eliminarEvento";
	public static final String AGREGAR_EVENTO = "agregarEvento";
	public static final String ELIMINAR_CIUDAD = "eliminarCiudad";
	public static final String AGREGAR_CIUDAD = "agregarCiudad";
	public static final String ELIMINAR_CONTACTO = "eliminarContacto";
	public static final String AGREGAR_CONTACTO = "agregarContacto";
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
	
	public void agregar(Contacto contacto){
		this.getContactos().add(contacto);		
	}
	
	public void agregar(Ciudad ciudad){
		this.getCiudades().add(ciudad);
	}
	
	public void agregar(Evento evento){
		this.getEventos().add(evento);
	}
	
	public void eliminar(Ciudad ciudad){
		this.getCiudades().remove(ciudad);
	}
	
	public void eliminar(Evento evento){
		this.getEventos().remove(evento);
	}
	
	public void eliminar(Contacto contacto){
		this.getContactos().remove(contacto);		
	}

	public void update(Contacto model) {
		//TODO home
	}
	
	public void update(Ciudad ciudad){
		//TODO home
	}
	
	public void update(Evento evento){
		//TODO home 
	}
	
}
