package homes;

import model.Ciudad;
import model.Contacto;

import org.apache.commons.collections.Predicate;
import org.joda.time.DateTime;
import org.uqbar.commons.model.CollectionBasedHome;

public class ContactoHomeColeccionImpl extends CollectionBasedHome<Contacto> {

	public ContactoHomeColeccionImpl() {
		this.create(new Contacto("Elias", "42245630", "elias@gmail.com",
				"Loco loco", new DateTime().minusYears(40), new Ciudad("Quilmes")));
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
