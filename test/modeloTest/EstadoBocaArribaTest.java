package modeloTest;

import static org.junit.Assert.assertFalse;
import org.junit.Test;

import modelo.estados.EstadoBocaArriba;

public class EstadoBocaArribaTest {

	
	@Test
	public void test01ElSeEncuentraBocaArriba() {
		
		EstadoBocaArriba estado = new EstadoBocaArriba();
		
		assertFalse(estado.estaBocaAbajo());
	}
	
}
