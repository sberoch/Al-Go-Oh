package modeloTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import modelo.Duelo;

public class DueloTest {
	
	
	@Test
	public void test01SeTerminaElDueloSiUnJugadorCompletaExodia() {
		
		Duelo duelo = new Duelo();
		
		duelo.iniciarDuelo();
		
		assertTrue(duelo.dueloTerminado());
	}

}
