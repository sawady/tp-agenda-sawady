package homes;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uqbar.commons.model.Application;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.ObservableObject;


/**
 * Agrega, elimina y actualiza ciudades, contactos y eventos
 * @author sawady
 *
 */
public class Agenda extends Entity implements Application {
	
	private Map<Class<?>, Home<?>> homes = new HashMap<Class<?>, Home<?>>();

	public Agenda(){
		new InMemoryHomeFactory().addHomes(this.homes);		
	}

	@SuppressWarnings("unchecked")
	public synchronized <T extends Entity> Home<T> getHome(Class<? extends T> type) {
		return (Home<T>) this.homes.get(type);
	}
	
}
