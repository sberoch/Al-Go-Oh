package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CartaMagica;

public class CartaMagicaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CartaMagica magica = new CartaMagica();
		magica.invocarBocaAbajo();
		
		assertTrue(magica.estaBocaAbajo());
		
	}

}
