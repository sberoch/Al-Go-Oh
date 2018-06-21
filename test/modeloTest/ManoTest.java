package modeloTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.Mano;
import modelo.cartas.CartaMonstruo;

public class ManoTest {

	
	@Test
	public void test01LaManoRecibeUnaCartaCorrectamente() {
		
		Mano mano = new Mano();
		
		mano.agregarCarta(CartaMonstruo.crearBrazoIzquierdoExodia());
		
		assertEquals(1, mano.obtenerCantidadDeCartas());
	}
	
	
	@Test
	public void test02DevuelveTrueCuandoTieneExodiaCompleto() {
		
		Mano mano = new Mano();
		
		mano.agregarCarta(CartaMonstruo.crearBrazoIzquierdoExodia());
		mano.agregarCarta(CartaMonstruo.crearBrazoDerechoExodia());
		mano.agregarCarta(CartaMonstruo.crearCabezaDeExodia());
		mano.agregarCarta(CartaMonstruo.crearPiernaDerechaExodia());
		mano.agregarCarta(CartaMonstruo.crearPiernaIzquierdaExodia());
		
		assertTrue(mano.estaExodiaCompleto());
	}
	
}
