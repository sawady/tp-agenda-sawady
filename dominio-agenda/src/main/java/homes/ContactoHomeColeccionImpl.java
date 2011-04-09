package homes;

import model.Ciudad;
import model.Contacto;

import org.apache.commons.collections.Predicate;
import org.joda.time.DateTime;
import org.uqbar.commons.model.CollectionBasedHome;

public class ContactoHomeColeccionImpl extends CollectionBasedHome<Contacto> {

	public ContactoHomeColeccionImpl() {
		this.create(new Contacto("Elias", "42245630", "elias@gmail.com",
				"Loco loco", new DateTime().minusYears(40), new Ciudad("Quilmes")));
		this.create(new Contacto("Vale", "42245630", "vale@gmail.com",
				"Loco loco", new DateTime().minusYears(40), new Ciudad("Bernal")));
		this.create(new Contacto("Martin", "42245630", "martin@gmail.com",
				"Loco loco", new DateTime().minusYears(40), new Ciudad("Quilmes")));
		this.create(new Contacto("Zaba", "42245630", "zaba@gmail.com",
				"Loco loco", new DateTime().minusYears(40), new Ciudad("Bera")));
	}
	
	private Predicate mismoNombre(final Contacto example){
		return new Predicate() {
			
			@Override
			public boolean evaluate(Object arg0) {
				
				Contacto otro = (Contacto) arg0;
				return otro.getNombre().toLowerCase().contains(example.getNombre().toLowerCase());
			}
		};
	}
	
	private Predicate porMailparecido(final Contacto example){
		return new Predicate() {
			
			@Override
			public boolean evaluate(Object arg0) {
				
				Contacto otro = (Contacto) arg0;
				return otro.getNombre().toLowerCase().contains(example.getNombre().toLowerCase());
			}
		};
	}
	
	private Predicate mismaCiudad(final Contacto example){
		return new Predicate() {
			
			@Override
			public boolean evaluate(Object arg0) {
				
				Contacto otro = (Contacto) arg0;
				return otro.getCiudad().getNombre().toLowerCase().contains(example.getCiudad().getNombre().toLowerCase());
			}
		};
	}
	
	private Predicate telefonoEmpiezaIgual(final Contacto example){
		return new Predicate() {
			
			@Override
			public boolean evaluate(Object arg0) {
				
				Contacto otro = (Contacto) arg0;
				return otro.getTelefono().toLowerCase().contains(example.getTelefono().toLowerCase());
			}
		};
	}
	
	private Predicate criterioTodos(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return mismoNombre(example).evaluate(arg0)
				&&     mismaCiudad(example).evaluate(arg0)
				&&     telefonoEmpiezaIgual(example).evaluate(arg0)
				&&     porMailparecido(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate criterioNombre_Mail(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return mismoNombre(example).evaluate(arg0)
				&&     porMailparecido(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate criterioNombre_Tel(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return mismoNombre(example).evaluate(arg0)
				&&     telefonoEmpiezaIgual(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate criterioNombre_Ciudad(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return mismoNombre(example).evaluate(arg0)
				&&     mismaCiudad(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate criterioMail_Tel(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return telefonoEmpiezaIgual(example).evaluate(arg0)
				&&     porMailparecido(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate criterioMail_Ciudad(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return mismaCiudad(example).evaluate(arg0)
				&&     porMailparecido(example).evaluate(arg0);
			}
		};
	}
	
	private Predicate criterioCiudad_Tel(final Contacto example){
		return new Predicate() {
			@Override
			public boolean evaluate(Object arg0) {
				return mismaCiudad(example).evaluate(arg0)
				&&     telefonoEmpiezaIgual(example).evaluate(arg0);
			}
		};
	}
	
	@Override
	public Class<Contacto> getEntityType() {
		return Contacto.class;
	}
	
	@Override
	public Contacto createExample() {
		return new Contacto();
	}

	@Override
	protected Predicate getCriterio(Contacto example) {
		
	String nombreCiudad = "";
	
	if(example.getCiudad() != null){
		nombreCiudad = example.getCiudad().getNombre();
	}
		
	if( aceptable(example.getNombre())
	&&  aceptable(example.getMail())
	&&  aceptable(nombreCiudad)
	&&  aceptable(example.getTelefono())){
		return this.criterioTodos(example);
	}
		
	if( aceptable(example.getNombre())
	&&  aceptable(example.getMail())){
		return this.criterioNombre_Mail(example);
	}
	
	if( aceptable(example.getNombre())
	&&  aceptable(nombreCiudad)){
		return this.criterioNombre_Ciudad(example);
	}
	
	if( aceptable(example.getNombre())
	&&  aceptable(example.getTelefono())){
		return this.criterioNombre_Tel(example);	
	}

	if( aceptable(example.getMail())
	&&  aceptable(nombreCiudad)){
		return this.criterioMail_Ciudad(example);
	}
	
	if( aceptable(example.getMail())
	&&  aceptable(example.getTelefono())){
		return this.criterioMail_Tel(example);
	}
	
	if( aceptable(nombreCiudad)
	&&  aceptable(example.getTelefono())){
		return this.criterioCiudad_Tel(example);			
	}
	
	if( aceptable(example.getNombre())){
		return this.mismoNombre(example);
	}
	
	if( aceptable(example.getMail())){
		return this.porMailparecido(example);
	}

	if( aceptable(example.getTelefono())){
		return this.telefonoEmpiezaIgual(example);
	}

	if( aceptable(nombreCiudad)){
		return this.mismaCiudad(example);
	}
	
		return this.getCriterioTodas();
	}
	
	private boolean aceptable(String s){
		return s != null && !s.isEmpty(); 
	}

}
