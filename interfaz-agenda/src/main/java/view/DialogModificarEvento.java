package view;

import model.Agenda;
import model.Evento;

import org.uqbar.arena.windows.WindowOwner;

public class DialogModificarEvento extends DialogAbstractEvento {

	public DialogModificarEvento(WindowOwner owner, Evento model, Agenda agenda) {
		super(owner, model, agenda);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().update(this.getModel());
	}

}
