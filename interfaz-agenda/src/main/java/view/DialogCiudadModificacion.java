package view;

import model.Ciudad;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public class DialogCiudadModificacion extends DialogCiudad {

	public DialogCiudadModificacion(WindowOwner owner, Ciudad model, Home<Ciudad> home) {
		super(owner, model, home);
	}

	@Override
	protected void executeTask() {
		this.getHome().update(this.getModel());		
	}

}
