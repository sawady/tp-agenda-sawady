package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.SearchByExample;
import org.uqbar.lacar.ui.model.Action;

import model.Ciudad;

public class PanelCiudad extends PanelAgendaElement<Ciudad> {

	public PanelCiudad(Home<Ciudad> home, Panel parentPanel,
			WindowOwner windowOwner) {
		super(home, parentPanel, windowOwner);
		this.initialize();
	}
	
	protected void initialize(){
		this.createResultsGrid(Ciudad.class);
		
		PanelBotonera botonera = new PanelBotonera(this);
		
		botonera.agregarBoton("Crear", new Action() {
			public void execute() {
				new DialogCiudadAlta(getWindowOwner(), getHome()).open();
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

	@Override
	protected void describeResultsGrid(Table<Ciudad> table) {
		Column<Ciudad> nombreColumn = new Column<Ciudad>(table);
		nombreColumn.setTitle("Nombre");
		nombreColumn.setPreferredSize(100);
		nombreColumn.bindContentsToProperty(Ciudad.NOMBRE);
		// table.add(column);		
	}	

}
