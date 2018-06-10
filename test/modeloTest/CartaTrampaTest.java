package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CartaTrampa;

public class CartaTrampaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CartaTrampa trampa = new CartaTrampa();
		trampa.invocarBocaAbajo();
		
		assertTrue(trampa.estaBocaAbajo());
		
	}

}
