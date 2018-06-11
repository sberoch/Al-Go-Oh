package modeloTest;

import modelo.EstadoBocaAbajo;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EstadoBocaAbajoTest {

	
	@Test
	public void test01ElSeEncuentraBocaAbajo() {
		
		EstadoBocaAbajo estado = new EstadoBocaAbajo();
		
		assertTrue(estado.estaBocaAbajo());
	}
	
}
