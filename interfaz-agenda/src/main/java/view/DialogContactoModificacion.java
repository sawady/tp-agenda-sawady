package view;

import model.Ciudad;
import model.Contacto;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public class DialogContactoModificacion extends DialogContacto {

	public DialogContactoModificacion(WindowOwner owner, Contacto model, Home<Contacto> home) {
		super(owner, model, home);
	}

	@Override
	protected void executeTask() {
		this.getHome().update(this.getModel());		
	}

}
