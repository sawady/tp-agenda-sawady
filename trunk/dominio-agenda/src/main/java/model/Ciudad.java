package model;

/**
 * Las ciudades tienen un nombre.
 * @author sawady
 *
 */
public class Ciudad implements Nombrable {
	
	private String nombre;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
