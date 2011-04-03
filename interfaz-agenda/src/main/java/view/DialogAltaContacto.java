package view;

import model.Agenda;
import model.Contacto;

import org.uqbar.arena.windows.WindowOwner;

public class DialogAltaContacto extends DialogAbstractContacto {

	public DialogAltaContacto(WindowOwner owner, Agenda agenda) {
		super(owner, new Contacto(), agenda);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().agregar(this.getModel());
	}

}
