package homes;

import java.util.Map;

import model.Ciudad;
import model.Contacto;
import model.Evento;

import org.uqbar.commons.model.Home;

/**
 * Implementacion dummy que crea las homes en-memoria
 * 
 * @author jfernandes
 */
public class InMemoryHomeFactory implements HomeFactory {

	@Override
	public void addHomes(Map<Class<?>, Home<?>> homes) {
		homes.put(Contacto.class, new ContactoHomeColeccionImpl());
		homes.put(Evento.class, new EventoHomeColeccionImpl());
		homes.put(Ciudad.class, new CiudadHomeColeccionImpl());
	}

}
