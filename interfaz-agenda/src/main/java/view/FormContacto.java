package view;

import java.awt.Checkbox;

import homes.Agenda;
import model.Ciudad;
import model.Contacto;

import org.joda.time.DateTime;
import org.uqbar.arena.layout.ColumnLayout;
import org.uqbar.arena.widgets.Label;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.Selector;
import org.uqbar.arena.widgets.TextBox;
import org.uqbar.arena.widgets.tables.Column;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.commons.model.Home;

import com.uqbar.commons.collections.Transformer;

public class FormContacto extends EntityStuffForUI<Contacto> {
	
	public FormContacto(Home<Contacto> home) {
		super(home);
	}

	public String getTitle() {
		return "Contactos";
	}

	public Panel createFormPanel(Panel form) {
		
		this.formPanelInvariable(form);
		
		new Label(form).setText("Ciudad");		
		new Selector(form).setContents(Agenda.getInstance().getCiudades(), Ciudad.NOMBRE)
		.bindValueToProperty(Contacto.CIUDAD);
		
		new Label(form).setText("Fecha de Nacimiento");
		new TextBox(form).bindValueToProperty(Contacto.FECHANAC).setAdapter(new AdapterJodaTime());
		
		new Label(form).setText("Observaciones");
		new TextBox(form).bindValueToProperty(Contacto.OBSERVACIONES);
				
		return form;
	}
	
	public void describeResultsGrid(Table<Contacto> table) {
		table.agregarColumna("Nombre", Contacto.NOMBRE, 50);
		table.agregarColumna("Mail", Contacto.MAIL, 50);
		table.agregarColumna("Tel", Contacto.TELEFONO, 50);
		table.agregarColumna("Ciudad", Contacto.CIUDAD, 50);
		table.agregarColumna("Observaciones", Contacto.OBSERVACIONES, 50);
		table.agregarColumna("Fecha de Nacimiento", Contacto.FECHANAC, 50).bindContentsToTransformer(new Transformer<Contacto, String>() {
			public String transform(Contacto contacto) {
				return new AdapterJodaTime().modelToView(contacto.getFechanac());
			}
		});
	}

	public Contacto newInstance() {
		return new Contacto();
	}

	@Override
	public Panel createSearchFromPanel(Panel form) {
		
		this.formPanelInvariable(form);
		
		new Label(form).setText("Ciudad");
		new TextBox(form).bindValueToProperty(Contacto.CIUDAD).setAdapter(new AdapterCiudad());

		return form;
	}
	
	private Panel formPanelInvariable(Panel form){
		form.setLayout(new ColumnLayout(2));
		
		new Label(form).setText("Nombre");
		new TextBox(form).bindValueToProperty(Contacto.NOMBRE);
		
		new Label(form).setText("Telefono");
		new TextBox(form).bindValueToProperty(Contacto.TELEFONO);
		
		new Label(form).setText("Mail");
		new TextBox(form).bindValueToProperty(Contacto.MAIL);
		
		return form;
	}

}
