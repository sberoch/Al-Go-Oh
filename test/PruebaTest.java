import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;
import modelo.Prueba;

class PruebaTest {

	@Test
	public void testDevuelve1( ) {
		Prueba p = new Prueba();
		int res = p.test();
		Assert.assertEquals(1, res);
	}

}
