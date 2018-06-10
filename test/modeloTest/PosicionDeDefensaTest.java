package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import modelo.PosicionDeDefensa;

public class PosicionDeDefensaTest {

	
	@Test
	public void test01UnaPosicionDeDefensaEsDeDefensa() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa();
		
		assertTrue(posicion.esPosicionDeDefensa());
	}
	
	
	@Test
	public void test02UnaPosicionDeDefensaNoEsDeAtaque() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa();
		
		assertFalse(posicion.esPosicionDeAtaque());
	}
	
}
