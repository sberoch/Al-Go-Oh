package modeloTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import modelo.Mano;
import modelo.cartas.CreadorDeCartas;

public class ManoTest {

	
	@Test
	public void test01LaManoRecibeUnaCartaCorrectamente() {
		
		Mano mano = new Mano();
		
		mano.agregarCarta(CreadorDeCartas.crearBrazoIzquierdoExodia());
		
		assertEquals(1, mano.obtenerCantidadDeCartas());
	}
	
	
	@Test
	public void test02DevuelveTrueCuandoTieneExodiaCompleto() {
		
		Mano mano = new Mano();
		
		mano.agregarCarta(CreadorDeCartas.crearBrazoIzquierdoExodia());
		mano.agregarCarta(CreadorDeCartas.crearBrazoDerechoExodia());
		mano.agregarCarta(CreadorDeCartas.crearCabezaDeExodia());
		mano.agregarCarta(CreadorDeCartas.crearPiernaDerechaExodia());
		mano.agregarCarta(CreadorDeCartas.crearPiernaIzquierdaExodia());
		
		assertTrue(mano.estaExodiaCompleto());
	}
}
