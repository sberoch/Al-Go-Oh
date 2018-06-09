import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Prueba;

class PruebaTest {

	@Test
	public void testDevuelve1() {
		Prueba p = new Prueba();
		int res = p.test();
		assertEquals(1, res);
	}
	
	@Test
	public void testDevuelveString() {
		Prueba p = new Prueba();
		String res = p.stringTest();
		assertEquals("anda todo bien", res);
	}
}
