package view;

import model.Agenda;
import model.Evento;

import org.uqbar.arena.windows.WindowOwner;

public class DialogAltaEvento extends DialogAbstractEvento {

	public DialogAltaEvento(WindowOwner owner, Agenda agenda) {
		super(owner, new Evento(), agenda);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().agregar(this.getModel());
	}

}
