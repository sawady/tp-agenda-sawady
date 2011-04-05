package view;

import org.uqbar.arena.layout.VerticalLayout;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;
import org.uqbar.lacar.ui.model.Action;


public abstract class PanelAgendaElement<T extends Entity> extends Panel{
	
	private Home<T> home;
	private WindowOwner windowOwner;
	private SearchByExample<T> search;
	
	public WindowOwner getWindowOwner() {
		return windowOwner;
	}	
	
	public Home<T> getHome() {
		return home;
	}

	public void setHome(Home<T> home) {
		this.home = home;
	}

	public PanelAgendaElement(Home<T> home, Panel parentPanel,
		WindowOwner windowOwner) {
		super(parentPanel);
		this.home = home;
		this.windowOwner = windowOwner;
		this.search = new SearchByExample<T>(home);
		
		this.setLayout(new VerticalLayout());
	}
	
	// ***********************************************************
	// ** Grid
	// ***********************************************************

	protected void createResultsGrid(Class<T> T) {
		Table<T> table = new Table<T>(this, T);

		table.bindContentsToProperty(Search.RESULTS);
		table.bindSelection(Search.SELECTED);

		this.describeResultsGrid(table);
	}

	protected abstract void describeResultsGrid(Table<T> builder);	
	
}
