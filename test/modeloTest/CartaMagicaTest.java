package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CampoDeJuego;
import modelo.CartaMagica;

public class CartaMagicaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CampoDeJuego unCampo = new CampoDeJuego();
		
		CartaMagica magica = CartaMagica.crearAgujeroNegro(unCampo);
		magica.invocarBocaAbajo(unCampo);
		
		assertTrue(magica.estaBocaAbajo());
		
	}

}
