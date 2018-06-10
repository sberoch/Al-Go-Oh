package modeloTest;

import modelo.*;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class CementerioTest {
	

	@Test
	public void test01NoEstaLaCartaEnElCementerio() {
		CartaMonstruo unaCarta = new CartaMonstruo();
		CartaMonstruo otraCarta = new CartaMonstruo();
		
		Cementerio cementerio = new Cementerio();
		
		cementerio.destruirCarta(unaCarta);
		
		assertFalse(cementerio.verificarCarta(otraCarta));
	}
	
	
	@Test
	public void test02LaCartaSeEnviaAlCementerio() {
		CartaMonstruo carta = new CartaMonstruo();
	
		Cementerio cementerio = new Cementerio();
		
		cementerio.destruirCarta(carta);
		
		assertTrue(cementerio.verificarCarta(carta));
	}
}
