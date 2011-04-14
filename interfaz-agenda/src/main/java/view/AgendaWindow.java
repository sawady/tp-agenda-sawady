package view;
import homes.Agenda;
import model.Ciudad;
import model.Contacto;
import model.Evento;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.SearchByExample;
import org.uqbar.lacar.ui.model.Action;

public class AgendaWindow extends SimpleWindow<Agenda> {

	public AgendaWindow(WindowOwner parent) {
		super(parent, Agenda.getInstance());
	}
	
	@Override
	protected void createMainTemplate(Panel formBuilder) {
		this.setTitle("Agenda");
		this.setTaskDescription("Elija un elemento a administrar:");
		super.createMainTemplate(formBuilder);
	}

	@Override
	public void createContents(Panel mainPanel) {
		mainPanel.setHorizontalLayout();
		super.createContents(mainPanel);
	}

	@Override
	protected void addActions(Panel actionsPanel) {
		PanelBotoneraHorizontal botonera = new PanelBotoneraHorizontal(actionsPanel);
		
		botonera.agregarBoton("Contactos", new Action() {			
			public void execute() {
				new AgendaEntitySearchWindow<Contacto, SearchByExample<Contacto>>(getOwner(), new GUIContentContacto(getModel().getHome(Contacto.class))).open();
			}
		});
		
		botonera.agregarBoton("Eventos", new Action() {
			public void execute() {
				new AgendaEntitySearchWindow<Evento, SearchByExample<Evento>>(getOwner(), new GUIContentEvento(getModel().getHome(Evento.class))).open();		
			}
		});
		
		botonera.agregarBoton("Ciudades", new Action() {
			public void execute() {
				new AgendaEntitySearchWindow<Ciudad, SearchByExample<Ciudad>>(getOwner(), new GUIContentCiudad(getModel().getHome(Ciudad.class))).open();		
			}
		});

	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
	}
}
