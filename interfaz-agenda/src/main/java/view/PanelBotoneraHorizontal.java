package view;

import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.lacar.ui.model.Action;

/**
 * Panel con horizontal layout
 * que permite agregar botones.
 * @author sawady
 *
 */
public class PanelBotoneraHorizontal extends Panel {

	public PanelBotoneraHorizontal(Panel container) {
		super(container);
		this.setHorizontalLayout();
	}

	public Button agregarBoton(String title, Action action){
		return new Button(this).setCaption(title)
		.onClick(action);
	}

}
