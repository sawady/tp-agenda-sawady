package view;

import model.Agenda;
import model.Evento;

import org.uqbar.arena.windows.WindowOwner;

public class DialogAltaEvento extends DialogAbstractEvento {

	public DialogAltaEvento(WindowOwner owner,
			Agenda aplicationObject) {
		super(owner, new Evento(), aplicationObject);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().agregar(this.getModel());
	}

}
