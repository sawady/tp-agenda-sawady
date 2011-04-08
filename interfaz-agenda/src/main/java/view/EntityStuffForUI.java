package view;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;

public abstract class EntityStuffForUI<T extends Entity> {
	
	private Home<T> home;
	
	public Home<T> getHome() {
		return home;
	}

	public void setHome(Home<T> home) {
		this.home = home;
	}
	
	public EntityStuffForUI(Home<T> home) {
		super();
		this.home = home;
	}

	public abstract String getTitle();
	
	public abstract Panel createFormPanel(Panel panel);
	
	public abstract void describeResultsGrid(Table<T> table);
	
	public abstract T newInstance();
	
	public Search<T> getSearch(){
		return new SearchByExample<T>(this.getHome()); 
	}
	
	public DialogAgendaElement<T> creationEditor(WindowOwner winown) {
		return new DialogAgendaElement<T>(winown, this, new CreateElement(this.newInstance()));
	}	
	
	public DialogAgendaElement<T> modifyEditor(T selected, WindowOwner winown) {
		return new DialogAgendaElement<T>(winown, this, new UpdateElement(selected));
	}
	
	public class CreateElement extends ActionEntity<T>{
		
		public CreateElement(T entity) {
			super(entity);
		}

		public void execute() {
			getHome().create(this.getEntity());
		}
	}
	
	public class UpdateElement extends ActionEntity<T>{
		
		public UpdateElement(T entity) {
			super(entity);
		}

		public void execute() {
			getHome().update(this.getEntity());
		}
	}
}
