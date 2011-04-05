package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;
import org.uqbar.lacar.ui.model.Action;

import model.Ciudad;

public class PanelCiudad extends PanelAgendaElement<Ciudad> {

	public PanelCiudad(Home<Ciudad> home, Panel parentPanel,
			WindowOwner windowOwner) {
		super(home, parentPanel, windowOwner);
	}
	
	protected void initialize(){
		this.setLayout(new VerticalLayout());
		
		PanelBotonera botonera = new PanelBotonera(this);
		
		botonera.agregarBoton("Crear", new Action() {
			public void execute() {
				new DialogCiudadAlta(getWindowOwner(), getHome());
			}
		});
		
		botonera.agregarBoton("Modificar", new Action() {
			public void execute() {
				//TODO new DialogCiudadModificion(getOwner(), ALGO, getHome());
			}
		});
		
		botonera.agregarBoton("Borrar", new Action() {
			public void execute() {
				// TODO getHome().delete();
			}
		});
	}	

}
