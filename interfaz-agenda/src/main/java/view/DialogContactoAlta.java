package view;

import model.Contacto;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public class DialogContactoAlta extends DialogContacto {

	public DialogContactoAlta(WindowOwner owner, Home<Contacto> home) {
		super(owner, new Contacto(), home);
	}

	@Override
	protected void executeTask() {
		this.getHome().create(this.getModel());		
	}

}
