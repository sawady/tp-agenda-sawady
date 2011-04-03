package model;

import org.joda.time.DateTime;
import org.uqbar.commons.model.ObservableObject;
import org.uqbar.commons.model.UserException;

/**
 * Un Contacto tiene un nombre, un teléfono, un mail, una fecha de nacimiento, 
 * un campo de observaciones, y una ciudad.
 * @author sawady
 */
public class Contacto extends ObservableObject implements Nombrable {
	
	public static final String OBSERVACIONES = "observaciones";
	public static final String MAIL = "mail";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String FECHA_NACIMIENTO = "fecha_nacimiento";
	public static final String CIUDAD = "ciudad";
	private String nombre;
	private String telefono;
	private String mail;
	private String observaciones;
	private DateTime fecha_nacimiento;
	private Ciudad ciudad;
	
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		 this.setProperty(CIUDAD, ciudad);
	}
	public DateTime getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(DateTime fecha_nacimiento) {
		this.setProperty(FECHA_NACIMIENTO, fecha_nacimiento);
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		
		//validacion nombre no vacío
		if(nombre.isEmpty())
			throw new UserException("El nombre no puede estar vacío");
		
		this.setProperty(NOMBRE,nombre);
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {

		//validacion telefono no vacío
		if(telefono.isEmpty())
			throw new UserException("El telefono no puede estar vacío");

		this.setProperty(TELEFONO,telefono);
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {		
		this.setProperty(MAIL,mail);
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.setProperty(OBSERVACIONES,observaciones);
	}
	
	/**
	 * Constructor que deja al objeto inconsistente
	 */
	public Contacto(){
		
	}
	
	/**
	 * Constructor detallando todos los campos
	 * @param nombre
	 * @param telefono
	 * @param mail
	 * @param observaciones
	 * @param fecha_nacimiento
	 */
	public Contacto(String nombre, String telefono, String mail,
			String observaciones, DateTime fecha_nacimiento, Ciudad cuidad) {
		super();
					
		//validacion fecha de nacimiento no es futura
		if(fecha_nacimiento.isBeforeNow())
			throw new UserException("Fecha de nacimiento es una fecha futura");
		
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.observaciones = observaciones;
		this.fecha_nacimiento = fecha_nacimiento;
		this.ciudad = cuidad;
	}

	/**
	 * Constructor detallando todos los campos excepto el de observaciones
	 * que sera vacío por defecto
	 * @param nombre
	 * @param telefono
	 * @param mail
	 * @param fecha_nacimiento
	 */
	public Contacto(String nombre, String telefono, String mail,
			DateTime fecha_nacimiento, Ciudad ciudad) {
		this(nombre, telefono, mail,"", fecha_nacimiento, ciudad);
	}
	
	
}
