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
		
		new PanelAgendaElement<Contacto>(this.getModel().getHome(Contacto.class), mainPanel, this.getOwner());
		new PanelAgendaElement<Evento>(this.getModel().getHome(Evento.class), mainPanel, this.getOwner());
		new PanelAgendaElement<Ciudad>(this.getModel().getHome(Ciudad.class), mainPanel, this.getOwner());
	}
	
	public static void main(String[] args) {
        new WindowAgenda(new Agenda()).startApplication();
    }
}
