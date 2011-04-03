package view;

import model.Agenda;

import org.uqbar.arena.widgets.Panel;

public abstract class PanelConBotoneraYLista extends PanelAbstractAgendaElement {

	PanelBotoneraABM botonera;

	public PanelBotoneraABM getBotonera() {
		return botonera;
	}

	public void setBotonera(PanelBotoneraABM botonera) {
		this.botonera = botonera;
	}
	
	public PanelConBotoneraYLista(Agenda agenda, Panel parentPanel,
			WindowAgenda agendaWindow) {
		super(agenda, parentPanel, agendaWindow);
		this.botonera = new PanelBotoneraABM(this);
	}

}
