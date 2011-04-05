package view;
import homes.Agenda;

import model.Ciudad;
import model.Contacto;
import model.Evento;

import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.MainWindow;

public class WindowAgenda extends MainWindow<Agenda> {
	
	public WindowAgenda(Agenda model) {
		super(model);
	}

	@Override
	public void createContents(Panel mainPanel) {
		mainPanel.setLayoutInColumns(3);
		
		new PanelContacto(this.getModel().getHome(Contacto.class), mainPanel, this.getOwner());
		new PanelEvento(this.getModel().getHome(Evento.class), mainPanel, this.getOwner());
		new PanelCiudad(this.getModel().getHome(Ciudad.class), mainPanel, this.getOwner());
	}
	
	public static void main(String[] args) {
        new WindowAgenda(new Agenda()).startApplication();
    }
}
