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
		return new Evento();
	}

	@Override
	protected Predicate getCriterio(Evento example) {
		return this.getCriterioTodas();
	}

}
