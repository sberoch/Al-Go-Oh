package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import modelo.PosicionDeAtaque;

public class PosicionDeAtaqueTest {

	
	@Test
	public void test01UnaPosicionDeAtaqueEsDeAtaque() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque();
		
		assertTrue(posicion.esPosicionDeAtaque());
	}
	
	
	@Test
	public void test02UnaPosicionDeDefensaNoEsDeAtaque() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque();
		
		assertFalse(posicion.esPosicionDeDefensa());
	}
	
	
}
