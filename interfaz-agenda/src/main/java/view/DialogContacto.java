package view;
import homes.Agenda;
import model.Contacto;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;


public abstract class DialogContacto extends DialogAbstractAgendaElement<Contacto> {

	public DialogContacto(WindowOwner owner, Contacto model,
			Home<Contacto> home) {
		super(owner, model, home);
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("ABM de Contactos");
		super.createMainTemplate(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel panel) {
		
		Panel form = new Panel(panel);
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
	}

}
