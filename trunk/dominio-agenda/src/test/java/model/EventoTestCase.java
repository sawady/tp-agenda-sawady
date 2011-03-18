package model;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.joda.time.Hours;
import org.junit.Before;
import org.junit.Test;

public class EventoTestCase {
	
	private Evento eventoNuevoTodosLosDatos;
	private Evento eventoNuevoSinDarFechaFin;
	private Evento eventoNuevoSinDarImportancia;
	private Evento eventoNuevoSinDarFechaFinNiImportancia;
	private DateTime fechaIni = new DateTime("2010-10-10");;
	private DateTime fechaFin = fechaIni.plusHours(10);;
	private String descripcion = "descripcion";
	private Integer importancia = 5;
	
	private Evento eventoConImportancia(Integer n){
		return new Evento(this.fechaIni, this.fechaFin, this.descripcion, n);
	}
	
	@Before
	public void setUp(){
		this.eventoNuevoTodosLosDatos = new Evento(this.fechaIni, this.fechaFin, this.descripcion, this.importancia);
		this.eventoNuevoSinDarImportancia = new Evento(this.fechaIni, this.fechaFin, this.descripcion);
		this.eventoNuevoSinDarFechaFin = new Evento(this.fechaIni, this.descripcion, this.importancia);
		this.eventoNuevoSinDarFechaFinNiImportancia = new Evento(this.fechaIni, this.descripcion);
	}
	
	/**
	 * Se comprueba que el constructor asigna los atributos correctamente
	 */
	@Test
	public void nuevoConTodosLosDatosEstaBienArmado(){
		assertEquals(this.eventoNuevoTodosLosDatos.getFecha_ini(), this.fechaIni);
		assertEquals(this.eventoNuevoTodosLosDatos.getFecha_fin(), this.fechaFin);
		assertEquals(this.eventoNuevoTodosLosDatos.getDescripcion(), this.descripcion);
		assertEquals(this.eventoNuevoTodosLosDatos.getImportancia(), this.importancia);
	}
	
	/**
	 * Un evento nuevo sin dar informacion de fecha_fin debe asumir
	 * que la fecha_fin es una hora despues de la fecha_ini
	 */
	@Test
	public void nuevoSinDarInformacionDeFechaFin(){
		assertEquals(this.eventoNuevoSinDarFechaFin.getFecha_fin(), this.eventoNuevoSinDarFechaFin.getFecha_ini().plusHours(1));
	}
	
	/**
	 * Un evento nuevo sin dar informacion de importancia debe asumir
	 * que la importancia es normal
	 */
	@Test
	public void nuevoSinDarInformacionDeImportancia(){
		assertEquals(this.eventoNuevoSinDarImportancia.getImportancia(), Evento.importanciaNormal());
	}
	
	/**
	 * Un evento nuevo sin dar informacion de importancia ni fecha_fin debe asumir
	 * que la importancia es normal y que la fecha_fin es una hora posterior a fecha_ini
	 */
	@Test
	public void nuevoSinDarInformacionDeImportanciaNiFechaFin(){
		assertEquals(this.eventoNuevoSinDarFechaFinNiImportancia.getFecha_fin(), this.eventoNuevoSinDarFechaFin.getFecha_ini().plusHours(1));
		assertEquals(this.eventoNuevoSinDarFechaFinNiImportancia.getImportancia(), Evento.importanciaNormal());
	}
	
	/**
	 * Un evento es mas importante que otro si su importancia es mayor a la del otro
	 */
	@Test
	public void esMasImportanteQueElOtro_cuandoLaImportanciaEsMayor(){		
		for(int x=-10, y=10; x < 10; x++, y--)
		{
			if(x>y)
				assertTrue(eventoConImportancia(x).masImportanteQue(eventoConImportancia(y)));
			else
				assertFalse(eventoConImportancia(x).masImportanteQue(eventoConImportancia(y)));
		}
	}
	
	/**
	 * Evento con fecha_fin un minuto posterior a ahora no esta terminado
	 */
	@Test
	public void eventoNoTerminado(){
		assertFalse(new Evento(this.fechaIni, new DateTime().plusMinutes(1), this.descripcion, this.importancia).haTerminado());
	}
	
	/**
	 * Evento con fecha_fin un minuto anterior a ahora esta terminado
	 */
	@Test
	public void eventoTerminado(){
		assertTrue(new Evento(this.fechaIni, new DateTime().minusMinutes(1), this.descripcion, this.importancia).haTerminado());
	}
	
	/**
	 * Evento con fecha_fin igual a ahora no esta terminado
	 */
	@Test
	public void eventoAPuntoDeTerminar(){
		assertFalse(new Evento(this.fechaIni, new DateTime(), this.descripcion, this.importancia).haTerminado());
	}
	
	@Test
	public void diferenciaDeHorasEsLaDiferenciaEntreFechaIniYFechaFin(){
		Evento evento = new Evento(this.fechaIni, this.fechaFin, this.descripcion);
		assertEquals(Hours.hoursBetween(fechaIni, fechaFin), evento.horasInsumidas());
	}

}
