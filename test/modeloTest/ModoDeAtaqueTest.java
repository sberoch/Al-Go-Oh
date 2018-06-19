package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import modelo.ModoDeAtaque;

public class ModoDeAtaqueTest {

	
	@Test
	public void test01UnaPosicionDeAtaqueEsDeAtaque() {
		
		ModoDeAtaque posicion = new ModoDeAtaque(0);
		
		assertTrue(posicion.esModoDeAtaque());
	}
	
	
	@Test
	public void test02UnaPosicionDeDefensaNoEsDeAtaque() {
		
		ModoDeAtaque posicion = new ModoDeAtaque(0);
		
		assertFalse(posicion.esModoDeDefensa());
	}
	
	
	@Test
	public void test03LaFuerzaDePeleaEsElAtaque() {
		
		ModoDeAtaque posicion = new ModoDeAtaque(1200);
		
		assertEquals(1200, posicion.fuerzaDePelea());
	}
	
	@Test
	public void test04LaFuerzaDeRetornoEsElAtaque() {
		
		ModoDeAtaque posicion = new ModoDeAtaque(1200);
		
		assertEquals(1200, posicion.fuerzaDeRetorno());
	}
	
	
	@Test
	public void test05ElDanioDeUnAtaqueEsElAtaqueEntranteMenosLaFuerzaDePelea() {
		
		ModoDeAtaque posicion = new ModoDeAtaque(1200);
		
		assertEquals(2000 - posicion.fuerzaDePelea(), posicion.obtenerDanioDeAtaque(2000));
	}
	
}
