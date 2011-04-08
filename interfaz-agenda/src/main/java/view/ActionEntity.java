package view;

import org.uqbar.commons.model.Entity;
import org.uqbar.lacar.ui.model.Action;

public abstract class ActionEntity<T extends Entity> implements Action {
	
	T entity;
	
	public T getEntity() {
		return entity;
	}
	
	public void setEntity(T entity) {
		this.entity = entity;
	}

	public ActionEntity(T entity){
		this.entity = entity;
	}

}
