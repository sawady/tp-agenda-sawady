package homes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import model.Ciudad;

import org.uqbar.commons.model.Application;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;

/**
 * Agrega, elimina y actualiza ciudades, contactos y eventos
 * @author sawady
 *
 */
public class Agenda extends Entity implements Application {
	
	private static Agenda instance;	
	private Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();

	public Agenda(){
		new InMemoryHomeFactory().addHomes(this.homes);		
	}

	@SuppressWarnings("unchecked")
	public synchronized <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}
	
	public static Agenda initialize(HomeFactory factory) {
		instance = new Agenda();
		//HARDCODED: coupled with in-memory homes. 
		Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();
		factory.addHomes(homes);
		instance.homes = homes;
		return instance;
	}
	
	public static synchronized Agenda initialize() {
		return initialize(new InMemoryHomeFactory()); //persist with collections in memory
	}
	
	public static synchronized Agenda getInstance() {
		if (instance == null) {
			instance = initialize();
		}
		return instance;
	}

	public List<Ciudad> getCiudades() {
		return this.getHome(Ciudad.class).allInstances();
	}
	
}
