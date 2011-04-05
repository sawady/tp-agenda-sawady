package view;

import homes.Agenda;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;

public abstract class DialogAbstractAgendaElement<T extends Entity> extends Dialog<T> {

	Home<T> home;
	
	public Home<T> getHome() {
		return home;
	}

	public void setHome(Home<T> home) {
		this.home = home;
	}

	public DialogAbstractAgendaElement(WindowOwner owner, T model, Home<T> home) {
		super(owner, model);
		this.home = home;
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, ACCEPT))
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, CANCEL));
	}
	

}
