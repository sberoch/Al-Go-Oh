package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CampoDeJuego;
import modelo.cartas.CartaCilindroMagico;
import modelo.cartas.CartaTrampa;

public class CartaTrampaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CampoDeJuego unCampo = new CampoDeJuego();
		CartaTrampa trampa = new CartaCilindroMagico();
		trampa.invocarBocaAbajo(null, unCampo);
		
		assertTrue(trampa.estaBocaAbajo());
		
	}

}
