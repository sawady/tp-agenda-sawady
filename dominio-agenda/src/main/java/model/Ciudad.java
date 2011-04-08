package model;

import org.uqbar.commons.model.Entity;

/**
 * Las ciudades tienen un nombre.
 * @author sawady
 *
 */
public class Ciudad extends Entity implements Nombrable {
	
	public static final String NOMBRE = "nombre";
	private String nombre;

	public Ciudad() {
		
	}
	
	public Ciudad(String string) {
		this.nombre = string;
	}

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
