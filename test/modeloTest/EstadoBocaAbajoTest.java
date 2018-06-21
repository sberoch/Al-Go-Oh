package modeloTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

import modelo.estados.EstadoBocaAbajo;

public class EstadoBocaAbajoTest {

	
	@Test
	public void test01ElSeEncuentraBocaAbajo() {
		
		EstadoBocaAbajo estado = new EstadoBocaAbajo();
		
		assertTrue(estado.estaBocaAbajo());
	}
	
}
