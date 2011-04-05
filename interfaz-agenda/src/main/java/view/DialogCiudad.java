package view;

import homes.Agenda;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

import model.Ciudad;
import model.Contacto;

public abstract class DialogCiudad extends DialogAbstractAgendaElement<Ciudad> {

	public DialogCiudad(WindowOwner owner, Ciudad model, Home<Ciudad> home) {
		super(owner, model, home);
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("ABM de Ciudades");
		super.createMainTemplate(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel panel) {
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre");
		new TextBox(panel).bindValueToProperty(Ciudad.NOMBRE);
	}

}
