package homes;

import model.Contacto;

import org.apache.commons.collections.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;
/**
 * 
 * @author npasserini
 */
public class ContactoHomeColeccionImpl extends CollectionBasedHome<Contacto> {

	public ContactoHomeColeccionImpl() {
	}

	@Override
	public Class<Contacto> getEntityType() {
		return Contacto.class;
	}
	
	@Override
	public Contacto createExample() {
		throw new UnsupportedOperationException("No se puede crear un ejemplo de contacto");
	}

	@Override
	protected Predicate getCriterio(Contacto example) {
		throw new UnsupportedOperationException("No se puede crear un criterio para buscar contacto");
	}

}
