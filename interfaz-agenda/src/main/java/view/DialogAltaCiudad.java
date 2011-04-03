package view;

import model.Agenda;
import model.Ciudad;

import org.uqbar.arena.windows.WindowOwner;

public class DialogAltaCiudad extends DialogAbstractCiudad {

	public DialogAltaCiudad(WindowOwner owner, Agenda aplicationObject) {
		super(owner, new Ciudad(), aplicationObject);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().agregar(this.getModel());
	}

}
