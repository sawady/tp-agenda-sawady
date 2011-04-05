package view;

import model.Agenda;
import model.Contacto;

import org.uqbar.arena.windows.WindowOwner;

public class DialogModificarContacto extends DialogAbstractContacto {


	public DialogModificarContacto(WindowOwner owner, Contacto model, Agenda agenda) {
		super(owner, model, agenda);
	}

	@Override
	protected void executeTask() {
		this.getAgenda().update(this.getModel());
	}

}
