package homes;

import model.Evento;

import org.apache.commons.collections.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;
/**
 * 
 * @author npasserini
 */
public class EventoHomeColeccionImpl extends CollectionBasedHome<Evento> {

	public EventoHomeColeccionImpl() {
	}

	@Override
	public Class<Evento> getEntityType() {
		return Evento.class;
	}
	
	@Override
	public Evento createExample() {
		throw new UnsupportedOperationException("No se puede crear un ejemplo de contacto");
	}

	@Override
	protected Predicate getCriterio(Evento example) {
		throw new UnsupportedOperationException("No se puede crear un criterio para buscar contacto");
	}

}
