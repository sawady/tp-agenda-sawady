package view;
import org.uqbar.arena.widgets.Panel;
import org.uqbar.arena.widgets.tables.Table;
import org.uqbar.arena.windows.WindowOwner;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.Home;
import org.uqbar.commons.model.Search;
import org.uqbar.commons.model.SearchByExample;

/**
 * 
 * Clase abstracta que desacopla el contenido de un form para buscar elementos, 
 * el contenido de una tabla para mostrar el resultado 
 * de una busqueda y el form de una ventana de dialogo
 * para updatear y crear una entitdad del modelo.
 * 
 * Esto me permite diseñar ventanas de dialogo, tablas
 * y search windows de forma generica, que tengan como modelo
 * cualquier elemento entity del modelo.
 * 
 * @author sawady
 *
 * @param <T>
 */
public abstract class GUIContentAgendaEntity<T extends Entity> {
	
	private Home<T> home;
	
	public Home<T> getHome() {
		return home;
	}

	public void setHome(Home<T> home) {
		this.home = home;
	}
	
	public GUIContentAgendaEntity(Home<T> home) {
		super();
		this.home = home;
	}

	public abstract String getTitle();
	
	public abstract Panel createFormPanel(Panel panel);
	
	public abstract Panel createSearchFromPanel(Panel panel);
	
	public abstract void describeResultsGrid(Table<T> table);
	
	public abstract T newInstance();
	
	public Search<T> getSearch(){
		return new SearchByExample<T>(this.getHome()); 
	}
	
	public AgendaEntityDialog<T> creationEditor(WindowOwner winown) {
		return new AgendaEntityDialog<T>(winown, this, new CreateElement(this.newInstance()));
	}	
	
	public AgendaEntityDialog<T> modifyEditor(T selected, WindowOwner winown) {
		return new AgendaEntityDialog<T>(winown, this, new UpdateElement(selected));
	}
	
	/**
	 * Action que le dice a la home que cree una nueva entidad
	 * @author sawady
	 *
	 */
	public class CreateElement extends ActionWithEntity<T>{
		
		public CreateElement(T entity) {
			super(entity);
		}

		public void execute() {
			getHome().create(this.getEntity());
		}
	}
	
	/**
	 * Action que le dice a la home que updatee una entidad
	 * @author sawady
	 *
	 */
	public class UpdateElement extends ActionWithEntity<T>{
		
		public UpdateElement(T entity) {
			super(entity);
		}

		public void execute() {
			getHome().update(this.getEntity());
		}
	}
}
