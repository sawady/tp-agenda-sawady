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
		this.create(new Ciudad("Quilmes"));
		this.create(new Ciudad("Bera"));
		this.create(new Ciudad("Lanus"));
	}

	@Override
	public Class<Ciudad> getEntityType() {
		return Ciudad.class;
	}
	
	@Override
	public Ciudad createExample() {
		return new Ciudad();
	}

	@Override
	protected Predicate getCriterio(Ciudad example) {
		return this.getCriterioTodas();
	}

}
