package model;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Hours;

/**
 * Un evento posee una fecha y hora de inicio, una fecha y hora de fin, 
 * una descripción y una indicación de si es importante o no
 * 
 * Si no se indica fecha fin, se asume que es una hora posterior a la fecha de inicio. 
 * 
 * Si no se indica que es importante, entonces se asume como normal.
 * 
 * Un evento validar que la fecha de inicio sea anterior a la fecha de fin.
 * 
 * Un evento puede calcular la cantidad de horas que le insume.
 * @author sawady
 *
 */
public class Evento {
	
	private DateTime fecha_ini;
	private DateTime fecha_fin;
	private String descripcion;
	private Integer importancia;
	
	public DateTime getFecha_ini() {
		return fecha_ini;
	}
	public void setFecha_ini(DateTime fecha_ini) {
		this.fecha_ini = fecha_ini;
	}
	public DateTime getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(DateTime fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getImportancia() {
		return importancia;
	}
	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	
	public Evento(DateTime fecha_ini, DateTime fecha_fin, String descripcion,
			Integer importancia) {
		super();
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.descripcion = descripcion;
		this.importancia = importancia;
	}
	
	/**
	 * Se asume que la fecha_fin es una hora despúes que la fecha_ini
	 * @param fecha_ini
	 * @param descripcion
	 * @param importancia
	 */
	public Evento(DateTime fecha_ini, String descripcion,
			Integer importancia) {
		this(fecha_ini, fecha_ini.plusHours(1), descripcion, importancia);
	}
	
	
	/**
	 * Se asume que la importancia normal es 0
	 * @param fecha_ini
	 * @param descripcion
	 */
	public Evento(DateTime fecha_ini, DateTime fecha_fin, String descripcion) {
		this(fecha_ini, fecha_fin, descripcion, importanciaNormal());
	}
	
	/**
	 * Se asume que la importancia normal es 0
	 * y la fecha_fin es una hora despues que la fecha_ini
	 * @param fecha_ini
	 * @param descripcion
	 */
	public Evento(DateTime fecha_ini, String descripcion) {
		this(fecha_ini, descripcion, importanciaNormal());
	}
	
	/**
	 * Cantidad de horas que insume el evento
	 * @return
	 */
	public Hours horasInsumidas(){
		return Hours.hoursBetween(this.getFecha_ini(), this.getFecha_fin());		
	}
	
	/**
	 * Indica si un evento ha terminado o no
	 * @return
	 */
	public Boolean haTerminado(){
		return this.fecha_fin.isBeforeNow();
	}
	
	/**
	 * Indica si el evento es mas importante que otro evento
	 * @param otroEvento
	 * @return
	 */
	public Boolean masImportanteQue(Evento otroEvento){		
		return this.getImportancia() > otroEvento.getImportancia();		
	}
	
	/**
	 * Importancia normal de un objeto Evento
	 */
	public static Integer importanciaNormal(){
		return 0;
	}

}
