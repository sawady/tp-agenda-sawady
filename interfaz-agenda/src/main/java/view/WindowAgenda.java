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

public class WindowAgenda extends SimpleWindow<Agenda> {

	public WindowAgenda(WindowOwner parent, Agenda model) {
		super(parent, model);
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
		PanelBotonera botonera = new PanelBotonera(actionsPanel);
		
		botonera.agregarBoton("Contactos", new Action() {			
			public void execute() {
				new SearchWindow<Contacto, SearchByExample<Contacto>>(getOwner(), new FormContacto(getModel().getHome(Contacto.class))).open();
			}
		});
		
		botonera.agregarBoton("Eventos", new Action() {
			public void execute() {
				new SearchWindow<Evento, SearchByExample<Evento>>(getOwner(), new FormEvento(getModel().getHome(Evento.class))).open();		
			}
		});
		
		botonera.agregarBoton("Ciudades", new Action() {
			public void execute() {
				new SearchWindow<Ciudad, SearchByExample<Ciudad>>(getOwner(), new FormCiudad(getModel().getHome(Ciudad.class))).open();		
			}
		});

	}

	@Override
	protected void createFormPanel(Panel mainPanel) {
	}
}
