package model;

import org.joda.time.DateTime;

/**
 * Un Contacto tiene un nombre, un teléfono, un mail, una fecha de nacimiento, 
 * un campo de observaciones, y una ciudad.
 * @author sawady
 */
public class Contacto implements Nombrable {
	
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
		this.ciudad = ciudad;
	}
	public DateTime getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(DateTime fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
