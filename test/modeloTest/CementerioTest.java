package modeloTest;

import modelo.Cementerio;
import modelo.cartas.CartaMonstruo;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CementerioTest {
	

	@Test
	public void test01UnaCartaNoEnviadaAlCementerioNoEstaEnElCementerio() {
		
		CartaMonstruo unaCarta = new CartaMonstruo(0, 0, 1);
		CartaMonstruo otraCarta = new CartaMonstruo(0, 0, 1);
		
		Cementerio cementerio = new Cementerio();
		
		cementerio.destruirCarta(unaCarta);
		
		assertFalse(cementerio.seEncuentra(otraCarta));
	}
	
	
	@Test
	public void test02UnaCartaEnviadaAlCementerioEstaEnElCementerio() {
		
		CartaMonstruo carta = new CartaMonstruo(0, 0, 1);
	
		Cementerio cementerio = new Cementerio();
		
		cementerio.destruirCarta(carta);
		
		assertTrue(cementerio.seEncuentra(carta));
	}
}
