package view;

import model.Evento;

import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public class DialogEventoAlta extends DialogEvento {

	public DialogEventoAlta(WindowOwner owner, Home<Evento> home) {
		super(owner, new Evento(), home);
	}

	@Override
	protected void executeTask() {
		this.getHome().create(this.getModel());		
	}

}
