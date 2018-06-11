package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import modelo.PosicionDeAtaque;

public class PosicionDeAtaqueTest {

	
	@Test
	public void test01UnaPosicionDeAtaqueEsDeAtaque() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque(0);
		
		assertTrue(posicion.esPosicionDeAtaque());
	}
	
	
	@Test
	public void test02UnaPosicionDeDefensaNoEsDeAtaque() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque(0);
		
		assertFalse(posicion.esPosicionDeDefensa());
	}
	
	
	@Test
	public void test03LaFuerzaDePeleaEsElAtaque() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque(1200);
		
		assertEquals(1200, posicion.fuerzaDePelea());
	}
	
	@Test
	public void test04LaFuerzaDeRetornoEsElAtaque() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque(1200);
		
		assertEquals(1200, posicion.fuerzaDeRetorno());
	}
	
	
	@Test
	public void test05ElDanioDeUnAtaqueEsElAtaqueEntranteMenosLaFuerzaDePelea() {
		
		PosicionDeAtaque posicion = new PosicionDeAtaque(1200);
		
		assertEquals(2000 - posicion.fuerzaDePelea(), posicion.obtenerDanioDeAtaque(2000));
	}
	
}
