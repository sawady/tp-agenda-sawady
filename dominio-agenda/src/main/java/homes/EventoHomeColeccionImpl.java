package homes;

import java.util.ArrayList;
import java.util.List;

import model.Evento;

import org.apache.commons.collections.Predicate;
import org.joda.time.DateTime;
import org.uqbar.commons.model.CollectionBasedHome;

public class EventoHomeColeccionImpl extends CollectionBasedHome<Evento> {

	public EventoHomeColeccionImpl() {
		this.create(new Evento(new DateTime(), new DateTime().plusDays(5), "Nada", 5));
	}

	@Override
	public Class<Evento> getEntityType() {
		return Evento.class;
	}
	
	@Override
	public Evento createExample() {
		return new Evento();
	}

	@Override
	protected Predicate getCriterio(final Evento example) {
		
		if(  example.getFecha_ini()   != null 
		  && example.getFecha_fin()   != null
		  && example.getImportancia() != null
		  && example.getDescripcion() != null){
			return this.todoIgual(example);
		}
		
		if(  example.getFecha_ini()   != null 
		  && example.getFecha_fin()   != null){
			return this.iniyfinIgual(example);
		}
		
		if(  example.getFecha_ini()   != null 
		  && example.getImportancia() != null){
			return this.iniyimportanciaIgual(example);
		}
		
		if(  example.getFecha_fin()   != null 
		  && example.getImportancia() != null){
			return this.finyimportanciaIgual(example);
		}
		
		if( example.getFecha_ini() != null){
			return this.inisIguales(example);
		}
		
		if( example.getFecha_fin() != null){
			return this.finIguales(example);
		}
		
		if( example.getImportancia() != null){
			return this.importanciaIguales(example);
		}
		
		if( example.getDescripcion() != null){
			return this.descripcionIguales(example);
		}
		
		return this.getCriterioTodas();
	}
	
	private boolean aceptable(String s){
		return s != null && !s.isEmpty();
	}
	
	private Predicate inisIguales(final Evento example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				Evento otro = (Evento) arg0;
				return otro.getFecha_ini().isEqual(example.getFecha_ini());
			}
		};
	}
	
	private Predicate finIguales(final Evento example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				Evento otro = (Evento) arg0;
				return otro.getFecha_fin().isEqual(example.getFecha_fin());
			}
		};
	}
	
	private Predicate importanciaIguales(final Evento example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				Evento otro = (Evento) arg0;
				return otro.getImportancia().equals((example.getImportancia()));
			}
		};
	}
	
	private Predicate descripcionIguales(final Evento example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				Evento otro = (Evento) arg0;
				return otro.getDescripcion().equals((example.getDescripcion()));
			}
		};
	}
	
	private Predicate todoIgual(final Evento example){
		return new Predicate(){
			@Override
			public boolean evaluate(Object arg0) {
				return  inisIguales(example).evaluate(arg0)
				     && finIguales(example).evaluate(arg0)
				     && importanciaIguales(example).evaluate(arg0)
					 && descripcionIguales(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate iniyfinIgual(final Evento example){
		return new Predicate(){
			@Override
			public boolean evaluate(Object arg0) {
				return  inisIguales(example).evaluate(arg0)
				     && finIguales(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate iniyimportanciaIgual(final Evento example){
		return new Predicate(){
			@Override
			public boolean evaluate(Object arg0) {
				return  inisIguales(example).evaluate(arg0)
				     && finIguales(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate finyimportanciaIgual(final Evento example){
		return new Predicate(){
			@Override
			public boolean evaluate(Object arg0) {
				return  inisIguales(example).evaluate(arg0)
				     && finIguales(example).evaluate(arg0);
			}
		};
	}

}
