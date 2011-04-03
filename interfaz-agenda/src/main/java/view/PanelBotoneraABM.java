package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.lacar.ui.model.Action;

public class PanelBotoneraABM extends Panel{

	public PanelBotoneraABM(Panel container) {
		super(container);
		this.setHorizontalLayout();
	}

	public Button agregarBoton(String title, Action action){
		return new Button(this).setCaption(title)
		.onClick(action);
	}

}
