package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.WindowOwner;

import model.Agenda;
import model.Ciudad;
import model.Contacto;

public abstract class DialogAbstractCiudad extends
		DialogAbstractAgendaElement<Ciudad> {

	public DialogAbstractCiudad(WindowOwner owner, Ciudad model,
			Agenda aplicationObject) {
		super(owner, model, aplicationObject);
	}
	
	@Override
	protected void createFormPanel(Panel panel) {
		panel.setLayout(new VerticalLayout());
	
		TextBox nombre_tx = new TextBox(panel);
		nombre_tx.bindValueToProperty(Ciudad.NOMBRE);
	}

}
