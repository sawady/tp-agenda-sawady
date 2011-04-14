package view;

import model.Contacto;
import model.Evento;

import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.commons.model.Home;

import com.uqbar.commons.collections.Transformer;

public class GUIContentEvento extends GUIContentAgendaEntity<Evento> {

	public GUIContentEvento(Home<Evento> home) {
		super(home);
	}

	public String getTitle() {
		return "Eventos";
	}

	public Panel createFormPanel(Panel form) {

		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Fecha Inicial");		
		new TextBox(form).bindValueToProperty(Evento.FECHA_INI).setAdapter(new AdapterJodaTime());
		
		new Label(form).setText("Fecha Final");		
		new TextBox(form).bindValueToProperty(Evento.FECHA_FIN).setAdapter(new AdapterJodaTime());
		
		new Label(form).setText("Fecha Descripcion");		
		new TextBox(form).bindValueToProperty(Evento.DESCRIPCION);

		new Label(form).setText("Importancia");		
		new TextBox(form).bindValueToProperty(Evento.IMPORTANCIA);
		
		return form;
	}

	@Override
	public void describeResultsGrid(Table<Evento> table) {
		table.agregarColumna("Inicio", Evento.FECHA_INI, 100).bindContentsToTransformer(new Transformer<Evento, String>() {
			public String transform(Evento evento) {
				return new AdapterJodaTime().modelToView(evento.getFecha_fin());
			}
		});
;
		table.agregarColumna("Fin", Evento.FECHA_FIN, 100).bindContentsToTransformer(new Transformer<Evento, String>() {
			public String transform(Evento evento) {
				return new AdapterJodaTime().modelToView(evento.getFecha_fin());
			}
		});
		
		table.agregarColumna("Descripcion", Evento.DESCRIPCION, 100);
		table.agregarColumna("Importancia", Evento.IMPORTANCIA, 100);
	}

	@Override
	public Evento newInstance() {
		return new Evento();
	}

	@Override
	public Panel createSearchFromPanel(Panel panel) {
		return this.createFormPanel(panel);
	}

}
