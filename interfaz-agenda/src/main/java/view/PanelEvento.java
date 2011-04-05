package view;

import model.Agenda;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.lacar.ui.model.Action;

public class PanelEvento extends PanelConBotoneraYLista{

	public PanelEvento(Agenda agenda, Panel parentPanel,
			WindowAgenda agendaWindow) {
		super(agenda, parentPanel, agendaWindow);
		this.initialize();
	}

	@Override
	protected void createContents() {		
		this.getBotonera().agregarBoton("Crear", new AltaEventoAction());
		this.getBotonera().agregarBoton("Modificar", new ModificarEventoAction());
		this.getBotonera().agregarBoton("Borrar", new BajaEventoAction());
	}
	
	private class AltaEventoAction implements Action {
		public void execute() {
			new DialogAltaEvento(getOwner(), getAgenda());
		}
	}
	
	private class ModificarEventoAction implements Action {
		
		public void execute() {
			//new DialogModificarEvento(getOwner(), ALGO, getAgenda());
		}
	}

	private class BajaEventoAction implements Action {
		
		public void execute() {
			//getAgenda().eliminarEvento(ALGO);
		}
		
	}

}
