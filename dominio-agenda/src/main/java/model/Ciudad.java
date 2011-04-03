package model;

import org.uqbar.commons.model.ObservableObject;

/**
 * Las ciudades tienen un nombre.
 * @author sawady
 *
 */
public class Ciudad extends ObservableObject implements Nombrable {
	
	public static final String NOMBRE = "nombre";
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.setProperty(NOMBRE, nombre);
	}

	@Override
	public String toString() {
		return this.getNombre();
	}

}
