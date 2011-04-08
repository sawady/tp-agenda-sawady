package view;

import model.Contacto;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.commons.model.Home;

public class FormContacto extends EntityStuffForUI<Contacto> {
	
	public FormContacto(Home<Contacto> home) {
		super(home);
	}

	public String getTitle() {
		return "Contactos";
	}

	public Panel createFormPanel(Panel form) {
		
		form.setLayout(new ColumnLayout(2));
	
		new Label(form).setText("Nombre");
		new TextBox(form).bindValueToProperty(Contacto.NOMBRE);
		
		new Label(form).setText("Telefono");
		new TextBox(form).bindValueToProperty(Contacto.TELEFONO);
		
		new Label(form).setText("Mail");
		new TextBox(form).bindValueToProperty(Contacto.MAIL);

		new Label(form).setText("Observaciones");		
		new TextBox(form).bindValueToProperty(Contacto.OBSERVACIONES);
		
		new Label(form).setText("Ciudad");
		new TextBox(form).bindValueToProperty(Contacto.CIUDAD);
		
		new Label(form).setText("Fecha de Nacimiento");
		new TextBox(form).bindValueToProperty(Contacto.FECHA_NACIMIENTO);
		
		return form;
	}
	
	public void describeResultsGrid(Table<Contacto> table) {
		table.agregarColumna("Nombre", Contacto.NOMBRE, 100);
		table.agregarColumna("Mail", Contacto.MAIL, 100);
		table.agregarColumna("Tel", Contacto.TELEFONO, 100);
		table.agregarColumna("Observaciones", Contacto.OBSERVACIONES, 100);
		table.agregarColumna("Fecha de Nacimiento", Contacto.FECHA_NACIMIENTO, 100);
	}

	public Contacto newInstance() {
		return new Contacto();
	}

}
