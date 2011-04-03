package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.lacar.ui.model.Action;

import model.Agenda;

public abstract class PanelAbstractAgendaElement extends Panel{
	
	private Agenda agenda;
	private WindowAgenda agendaWindow;
	private Panel parentPanel;
	
	public WindowAgenda getAgendaWindow() {
		return agendaWindow;
	}

	public void setAgendaWindow(WindowAgenda agendaWindow) {
		this.agendaWindow = agendaWindow;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public Panel getParentPanel() {
		return parentPanel;
	}

	public void setParentPanel(Panel parentPanel) {
		this.parentPanel = parentPanel;
	}
	
	public PanelAbstractAgendaElement(Agenda agenda, Panel parentPanel,
		WindowAgenda agendaWindow) {
		super(parentPanel);
		this.agenda = agenda;
		this.parentPanel = parentPanel;
		this.agendaWindow = agendaWindow;
	}

	protected void initialize(){
		this.setLayout(new VerticalLayout());
		this.createContents();
	}
	
	abstract protected void createContents();
	
	final protected WindowOwner getOwner(){
		return this.getAgendaWindow().getOwner();
	}
	
}
