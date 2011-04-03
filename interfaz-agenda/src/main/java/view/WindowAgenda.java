package view;
import model.Agenda;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.windows.MainWindow;
import org.uqbar.commons.model.ObservableObject;
import org.uqbar.lacar.ui.model.Action;

public class WindowAgenda extends MainWindow<Agenda> {

	public WindowAgenda(Agenda model) {
		super(model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		mainPanel.setLayoutInColumns(3);
		
		new PanelContacto(this.getModel(), mainPanel, this);
		new PanelEvento(this.getModel(), mainPanel, this);
		new PanelCiudad(this.getModel(), mainPanel, this);
	}
	
	public static void main(String[] args) {
        new WindowAgenda(new Agenda()).startApplication();
    }
}
