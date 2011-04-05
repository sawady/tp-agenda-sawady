package view;

import model.Ciudad;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public class DialogCiudadAlta extends DialogCiudad {

	public DialogCiudadAlta(WindowOwner owner, Home<Ciudad> home) {
		super(owner, new Ciudad(), home);
	}

	@Override
	protected void executeTask() {
		this.getHome().create(this.getModel());		
	}

}
