package view;

import model.Agenda;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.lacar.ui.model.Action;

public class PanelCiudad extends PanelConBotoneraYLista {

	public PanelCiudad(Agenda agenda, Panel parentPanel,
			WindowAgenda agendaWindow) {
		super(agenda, parentPanel, agendaWindow);
		this.initialize();
	}

	@Override
	protected void createContents() {		
		this.getBotonera().agregarBoton("Crear",new AltaCiudadAction());
		this.getBotonera().agregarBoton("Modificar", new ModificarCiudadAction());
		this.getBotonera().agregarBoton("Borrar", new BajaCiudadAction());
	}
	
	private class AltaCiudadAction implements Action {
		public void execute() {
			new DialogAltaEvento(getOwner(), getAgenda());
		}
	}
	
	private class ModificarCiudadAction implements Action {
		
		public void execute() {
			//new DialogModificarEvento(getOwner(), ALGO, getAgenda());
		}
	}

	private class BajaCiudadAction implements Action {
		
		public void execute() {
			//getAgenda().eliminarEvento(ALGO);
		}
		
	}

}
