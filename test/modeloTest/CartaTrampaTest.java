package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import modelo.CartaTrampa;

public class CartaTrampaTest {

	@Test
	public void test01invocarBocaAbajoLaDejaConEstadoBocaAbajo() {
		
		CartaTrampa trampa = new CartaTrampa();
		trampa.invocarBocaAbajo();
		
		boolean esperado = true;
		
		Assert.assertEquals(esperado, trampa.estaBocaAbajo());
		
	}

}
