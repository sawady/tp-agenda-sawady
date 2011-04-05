package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;
import org.uqbar.lacar.ui.model.Action;

import model.Contacto;

public class PanelContacto extends PanelAgendaElement<Contacto> {

	public PanelContacto(Home<Contacto> home, Panel parentPanel,
			WindowOwner windowOwner) {
		super(home, parentPanel, windowOwner);
	}
	
	protected void initialize(){
		this.setLayout(new VerticalLayout());
		
		PanelBotonera botonera = new PanelBotonera(this);
		
		botonera.agregarBoton("Crear", new Action() {
			public void execute() {
				new DialogContactoAlta(getWindowOwner(), getHome());
			}
		});
		
		botonera.agregarBoton("Modificar", new Action() {
			public void execute() {
				//TODO new DialogContactoModificion(getOwner(), ALGO, getHome());
			}
		});
		
		botonera.agregarBoton("Borrar", new Action() {
			public void execute() {
				// TODO getHome().delete();
			}
		});
	}	

}
