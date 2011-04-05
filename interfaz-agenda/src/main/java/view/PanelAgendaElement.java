package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;
import org.uqbar.lacar.ui.model.Action;


public class PanelAgendaElement<T extends Entity> extends Panel{
	
	private Home<T> home;
	private WindowOwner windowOwner;
	
	public WindowOwner getWindowOwner() {
		return windowOwner;
	}	
	
	public Home<T> getHome() {
		return home;
	}

	public void setHome(Home<T> home) {
		this.home = home;
	}

	public PanelAgendaElement(Home<T> home, Panel parentPanel,
		WindowOwner windowOwner) {
		super(parentPanel);
		this.home = home;
		this.windowOwner = windowOwner;
		this.initialize();
	}
	
	protected void initialize(){
		this.setLayout(new VerticalLayout());
		
		PanelBotonera botonera = new PanelBotonera(this);
		
		botonera.agregarBoton("Crear", new Action() {
			public void execute() {
				// TODO new DialogCiudad(getOwner(), getHome(), );
			}
		});
		
		botonera.agregarBoton("Modificar", new Action() {
			public void execute() {
				// TODO DialogCiudad(getOwner(), ALGO, getHome());
			}
		});
		
		botonera.agregarBoton("Borrar", new Action() {
			public void execute() {
				// TODO getHome().delete();
			}
		});
	}
	
}
