package homes;

import model.Ciudad;

import org.apache.commons.collections.Predicate;
import org.uqbar.commons.model.CollectionBasedHome;
/**
 * 
 * @author npasserini
 */
public class CiudadHomeColeccionImpl extends CollectionBasedHome<Ciudad> {

	public CiudadHomeColeccionImpl() {
	}

	@Override
	public Class<Ciudad> getEntityType() {
		return Ciudad.class;
	}
	
	@Override
	public Ciudad createExample() {
		throw new UnsupportedOperationException("No se puede crear un ejemplo de contacto");
	}

	@Override
	protected Predicate getCriterio(Ciudad example) {
		throw new UnsupportedOperationException("No se puede crear un criterio para buscar contacto");
	}

}
