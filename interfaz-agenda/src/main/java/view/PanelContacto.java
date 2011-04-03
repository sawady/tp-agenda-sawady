package view;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.lacar.ui.model.Action;

import model.Agenda;

public class PanelContacto extends PanelConBotoneraYLista {
	
	public PanelContacto(Agenda agenda, Panel parentPanel,
			WindowAgenda agendaWindow) {
		super(agenda, parentPanel, agendaWindow);
		this.initialize();
	}

	@Override
	protected void createContents() {		
		this.getBotonera().agregarBoton("Crear", new AltaContactoAction());
		this.getBotonera().agregarBoton("Modificar", new ModificarContactoAction());
		this.getBotonera().agregarBoton("Borrar", new BajaContactoAction());
	}
	
	private class AltaContactoAction implements Action {

		public void execute() {
			new DialogAltaContacto(getOwner(), getAgenda()).open();
		}		
		
	}
	
	private class ModificarContactoAction implements Action {
		
		public void execute() {
			//new DialogModificarEvento(getOwner(), ALGO, getAgenda());
		}
	}

	private class BajaContactoAction implements Action {
		
		public void execute() {
			//getAgenda().eliminarEvento(ALGO);
		}
		
	}

}
