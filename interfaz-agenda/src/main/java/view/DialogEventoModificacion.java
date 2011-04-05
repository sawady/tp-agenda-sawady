package view;

import model.Evento;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public class DialogEventoModificacion extends DialogEvento {

	public DialogEventoModificacion(WindowOwner owner, Evento model, Home<Evento> home) {
		super(owner, model, home);
	}

	@Override
	protected void executeTask() {
		this.getHome().update(this.getModel());		
	}

}
