package view;

import model.Agenda;
import model.Contacto;
import model.Evento;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

public abstract class DialogAbstractEvento extends DialogAbstractAgendaElement<Evento> {

	public DialogAbstractEvento(WindowOwner owner, Evento model,
			Agenda aplicationObject) {
		super(owner, model, aplicationObject);
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle("ABM de Contactos");
		super.createMainTemplate(mainPanel);
	}

	@Override
	protected void createFormPanel(Panel panel) {
		panel.setLayout(new VerticalLayout());
		
		TextBox fechaini_tx = new TextBox(panel);
		fechaini_tx.bindValueToProperty(Evento.FECHA_INI);
		
		TextBox fechafin_tx = new TextBox(panel);
		fechafin_tx.bindValueToProperty(Evento.FECHA_FIN);
		
		TextBox descrip_tx = new TextBox(panel);
		descrip_tx.bindValueToProperty(Evento.DESCRIPCION);

		TextBox importancia_tx = new TextBox(panel);
		importancia_tx.bindValueToProperty(Evento.IMPORTANCIA);
		
	}

}
