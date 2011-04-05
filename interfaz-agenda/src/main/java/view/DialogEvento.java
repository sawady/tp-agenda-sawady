package view;

import homes.Agenda;
import model.Contacto;
import model.Evento;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Home;

public abstract class DialogEvento extends DialogAbstractAgendaElement<Evento> {

	public DialogEvento(WindowOwner owner, Evento model, Home<Evento> home) {
		super(owner, model, home);
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("ABM de Eventos");
		super.createMainTemplate(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel panel) {
		
		Panel form = new Panel(panel);
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Fecha Inicial");		
		new TextBox(form).bindValueToProperty(Evento.FECHA_INI);
		
		new Label(form).setText("Fecha Final");		
		new TextBox(form).bindValueToProperty(Evento.FECHA_FIN);
		
		new Label(form).setText("Fecha Descripcion");		
		new TextBox(form).bindValueToProperty(Evento.DESCRIPCION);

		new Label(form).setText("Importancia");		
		new TextBox(form).bindValueToProperty(Evento.IMPORTANCIA);
		
	}

}
