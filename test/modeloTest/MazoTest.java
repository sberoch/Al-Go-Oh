package modeloTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.MazoDeCartas;
import modelo.cartas.Carta;


public class MazoTest {
	
	
	@Test
	public void test01SeRobaUnaCartaCorrectamente() {
		
		MazoDeCartas mazo = new MazoDeCartas();
		
		mazo.llenar(null, null);
		
		Carta carta = mazo.robar();
		
		assertFalse(carta == null);
	}
	
	
	@Test
	public void test02SeRobaCartaDeUnMazoVacio() {
		
		MazoDeCartas mazo = new MazoDeCartas();
		
		Carta carta = mazo.robar();
		
		assertTrue(carta == null);
	}
	

}
