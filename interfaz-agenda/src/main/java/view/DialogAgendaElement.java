package view;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.windows.Dialog;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;

public class DialogAgendaElement<T extends Entity> extends Dialog<T> {

	private EntityStuffForUI<T> espform;
	private ActionEntity<T> action;
	
	public ActionEntity<T> getAction() {
		return action;
	}

	public void setAction(ActionEntity<T> action) {
		this.action = action;
	}

	public EntityStuffForUI<T> getEspform() {
		return espform;
	}

	public void setEspform(EntityStuffForUI<T> espform) {
		this.espform = espform;
	}

	public DialogAgendaElement(WindowOwner owner, EntityStuffForUI<T> espform, ActionEntity<T> action) {
		super(owner, action.getEntity());
		this.espform = espform;
		this.action = action;
	}
	
	@Override
	protected void createMainTemplate(Panel mainPanel) {
		this.setTitle(this.getEspform().getTitle());
		super.createMainTemplate(mainPanel);
	}
	
	@Override
	protected void addActions(Panel actions) {
		new Button(actions)
			.setCaption("Aceptar")
			.onClick(new MessageSend(this, ACCEPT))
			.setAsDefault()
			.disableOnError();

		new Button(actions) //
			.setCaption("Cancelar")
			.onClick(new MessageSend(this, CANCEL));
	}
	
	protected void createFormPanel(Panel panel) {
		this.getEspform().createFormPanel(new Panel(panel));
	}

	@Override
	protected void executeTask() {
		this.getAction().execute();
	}

}
