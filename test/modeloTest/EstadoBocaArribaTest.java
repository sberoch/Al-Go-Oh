package modeloTest;

import modelo.EstadoBocaArriba;
import static org.junit.Assert.assertFalse;
import org.junit.Test;

public class EstadoBocaArribaTest {

	
	@Test
	public void test01ElSeEncuentraBocaArriba() {
		
		EstadoBocaArriba estado = new EstadoBocaArriba();
		
		assertFalse(estado.estaBocaAbajo());
	}
	
}
