package view;

import model.Agenda;
import model.Ciudad;

import org.uqbar.arena.windows.WindowOwner;

public class DialogModificarCiudad extends DialogAbstractCiudad {

	public DialogModificarCiudad(WindowOwner owner, Ciudad model,
			Agenda aplicationObject) {
		super(owner, model, aplicationObject);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().update(this.getModel());
	}

}
