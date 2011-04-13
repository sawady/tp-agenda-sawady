package view;

import homes.Agenda;

import model.Contacto;

import org.uqbar.arena.Application;
import org.uqbar.arena.windows.Window;
import org.uqbar.commons.model.SearchByExample;

public class AgendaApplication extends Application {

	public static void main(String[] args) {
		new AgendaApplication().start();
	}

	@Override
	protected Window<?> createMainWindow() {
		return new WindowAgenda(this);
	}

}
