package homes;

import model.Contacto;

import org.apache.commons.collections.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;

public class ContactoHomeColeccionImpl extends CollectionBasedHome<Contacto> {

	public ContactoHomeColeccionImpl() {
	}

	@Override
	public Class<Contacto> getEntityType() {
		return Contacto.class;
	}
	
	@Override
	public Contacto createExample() {
		return new Contacto();
	}

	@Override
	protected Predicate getCriterio(Contacto example) {
		return this.getCriterioTodas();
	}

}
