package model;

import org.joda.time.DateTime;
import org.uqbar.commons.model.Entity;
import org.uqbar.commons.model.UserException;

/**
 * Un Contacto tiene un nombre, un teléfono, un mail, una fecha de nacimiento, 
 * un campo de observaciones, y una ciudad.
 * @author sawady
 */
public class Contacto extends Entity implements Nombrable {
	
	public static final String OBSERVACIONES = "observaciones";
	public static final String MAIL = "mail";
	public static final String TELEFONO = "telefono";
	public static final String NOMBRE = "nombre";
	public static final String FECHANAC = "fechanac";
	public static final String CIUDAD = "ciudad";
	private String nombre;
	private String telefono;
	private String mail;
	private String observaciones;
	private DateTime fechanac;
	private Ciudad ciudad;
	
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		 this.setProperty(CIUDAD, ciudad);
	}
	public DateTime getFechanac() {		
		return fechanac;
	}
	public void setFechanac(DateTime fecha_nacimiento) {

		if(fecha_nacimiento == null){
			throw new UserException("Fecha no válida: dd-mm-aa");
		}	
		
		//validacion fecha de nacimiento no es futura
		if(fecha_nacimiento.isAfterNow())
			throw new UserException("Fecha de nacimiento es una fecha futura");
		
		this.setProperty(FECHANAC, fecha_nacimiento);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		
		//validacion nombre
//		if(nombre == null || nombre.isEmpty())
//			throw new UserException("El nombre no puede estar vacío");
		
		this.setProperty(NOMBRE,nombre);
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {

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
		this.nombre = nombre;
		this.telefono = telefono;
		this.mail = mail;
		this.observaciones = observaciones;
		this.fechanac = fecha_nacimiento;
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
