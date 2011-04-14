package view;

import org.uqbar.commons.model.Entity;
import org.uqbar.lacar.ui.model.Action;

public abstract class ActionWithEntity<T extends Entity> implements Action {
	
	T entity;
	
	public T getEntity() {
		return entity;
	}
	
	public void setEntity(T entity) {
		this.entity = entity;
	}

	public ActionWithEntity(T entity){
		this.entity = entity;
	}

}
