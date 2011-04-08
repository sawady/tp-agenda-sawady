package view;

import model.Ciudad;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.commons.model.Home;

public class FormCiudad extends EntityStuffForUI<Ciudad> {

	public FormCiudad(Home<Ciudad> home) {
		super(home);
	}

	public String getTitle() {
		return "ciudades";
	}

	public Panel createFormPanel(Panel form) {
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre");
		new TextBox(form).bindValueToProperty(Ciudad.NOMBRE);
		return form;
	}

	@Override
	public void describeResultsGrid(Table<Ciudad> table) {
		table.agregarColumna("Nombre", Ciudad.NOMBRE, 100);
	}

	@Override
	public Ciudad newInstance() {
		return new Ciudad();
	}

}
