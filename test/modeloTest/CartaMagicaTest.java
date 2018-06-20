package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CampoDeJuego;
import modelo.CartaMagica;

public class CartaMagicaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CampoDeJuego unCampo = new CampoDeJuego();
		CartaMagica trampa = new CartaMagica(null);
		trampa.invocarBocaAbajo(null, unCampo);
		
		assertTrue(trampa.estaBocaAbajo());
		
	}

}
