package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import modelo.CartaMagica;

public class CartaMagicaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CartaMagica magica = new CartaMagica();
		magica.invocarBocaAbajo();
		
		boolean esperado = true;
		
		Assert.assertEquals(esperado, magica.estaBocaAbajo());
		
	}

}
