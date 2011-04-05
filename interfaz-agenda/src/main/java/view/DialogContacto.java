package view;
import homes.Agenda;
import model.Contacto;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
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
		
		panel.setLayout(new VerticalLayout());
	
		TextBox nombre_tx = new TextBox(panel);
		nombre_tx.bindValueToProperty(Contacto.NOMBRE);
		
		TextBox telefono_tx = new TextBox(panel);
		telefono_tx.bindValueToProperty(Contacto.TELEFONO);
		
		TextBox mail_tx = new TextBox(panel);
		mail_tx.bindValueToProperty(Contacto.MAIL);

		TextBox observaciones_tx = new TextBox(panel);
		observaciones_tx.bindValueToProperty(Contacto.OBSERVACIONES);
		
		TextBox ciudad_tx = new TextBox(panel);
		ciudad_tx.bindValueToProperty(Contacto.CIUDAD);
		
		TextBox fechanac_tx = new TextBox(panel);
		fechanac_tx.bindValueToProperty(Contacto.FECHA_NACIMIENTO);
		
	}

}
