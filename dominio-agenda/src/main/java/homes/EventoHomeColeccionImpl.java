package homes;

import model.Evento;

import org.apache.commons.collections.Predicate;
import org.joda.time.DateTime;
import org.uqbar.commons.model.CollectionBasedHome;
/**
 * 
 * @author npasserini
 */
public class EventoHomeColeccionImpl extends CollectionBasedHome<Evento> {

	public EventoHomeColeccionImpl() {
		this.create(new Evento(new DateTime(), new DateTime().plusDays(5), "Nada", 5));
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
