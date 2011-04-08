package view;

import org.uqbar.arena.actions.MessageSend;
import org.uqbar.arena.bindings.NotNullObservable;
import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Button;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.SimpleWindow;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;
import org.uqbar.lacar.ui.model.Action;

public class SearchWindow<E extends Entity, T extends Search<E>> extends SimpleWindow<T> {
	
	private EntityStuffForUI<E> espForm;

	public EntityStuffForUI<E> getEspForm() {
		return espForm;
	}

	public void setEspForm(EntityStuffForUI<E> espForm) {
		this.espForm = espForm;
	}

	public SearchWindow(WindowOwner owner, EntityStuffForUI<E> espForm) {
		super(owner, (T) espForm.getSearch());
		this.espForm = espForm;
	}

	@Override
	protected void createMainTemplate(Panel mainPanel) {
		super.createMainTemplate(mainPanel);
		this.createResultsGrid(mainPanel);
		this.createGridActions(mainPanel);
		this.setTitle("Buscardor: " + this.getEspForm().getTitle());
		this.setTaskDescription("Ingrese los parámetros de búsqueda");
	}
	
	@Override
	protected void createFormPanel(Panel mainPanel) {
		
		Panel formPanel = new Panel(mainPanel);
		
		formPanel.bindContents(SearchByExample.EXAMPLE);
		
		this.getEspForm().createFormPanel(formPanel);
	}


	@Override
	protected void createActionsPanel(Panel formBuilder) {
		super.createActionsPanel(formBuilder);
	}

	// ***********************************************************
	// ** Grid
	// ***********************************************************

	protected void createResultsGrid(Panel mainPanel) {
		Table<E> table = new Table<E>(mainPanel, this.getModel().getEntityType());

		table.bindContentsToProperty(Search.RESULTS);
		table.bindSelection(Search.SELECTED);

		this.getEspForm().describeResultsGrid(table);
	}

	// ***********************************************************
	// ** Actions
	// ***********************************************************

	@Override
	protected void addActions(Panel actionsPanel) {
		Button buscar = new Button(actionsPanel);
		buscar.setCaption("Buscar");
		buscar.onClick(new Action() {
			public void execute() {
				getModel().search();
			}
		});
		buscar.setAsDefault();
	}

	protected void createGridActions(Panel mainPanel) {
		Panel botonera = new Panel(mainPanel);
		botonera.setHorizontalLayout();

		NotNullObservable elementSelected = new NotNullObservable(Search.SELECTED);
		
		Button create = new Button(botonera);
		create.setCaption("Crear");
		create.onClick(new MessageSend(this, "startCreation"));
		
		Button edit = new Button(botonera);
		edit.setCaption("Editar");
		edit.bindEnabled(elementSelected);
		edit.onClick(new MessageSend(this, "startEdition"));

		Button remove = new Button(botonera);
		remove.setCaption("Borrar");
		remove.bindEnabled(new NotNullObservable(Search.SELECTED));
		remove.onClick(new MessageSend(this.getModel(), "removeSelected"));
	}
	
	// ********************************************************
	// ** Actions
	// ********************************************************

	
	public void startCreation() {
		DialogAgendaElement<E> editor = this.getEspForm().creationEditor(this.getOwner());
		editor.onAccept(new MessageSend(this.getModel(), Search.SEARCH));
		editor.open();
		this.getModel().search();
	}
	
	public void startEdition() {
		DialogAgendaElement<E> editor = this.getEspForm().modifyEditor(this.getModel().getSelected(), this.getOwner());
		editor.onAccept(new MessageSend(this.getModel(), Search.SEARCH));
		editor.open();
		this.getModel().search();
	}

}
