package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import modelo.PosicionDeDefensa;

public class PosicionDeDefensaTest {

	
	@Test
	public void test01UnaPosicionDeDefensaEsDeDefensa() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa(0);
		
		assertTrue(posicion.esPosicionDeDefensa());
	}
	
	
	@Test
	public void test02UnaPosicionDeDefensaNoEsDeAtaque() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa(0);
		
		assertFalse(posicion.esPosicionDeAtaque());
	}
	
	
	@Test
	public void test03LaFuerzaDePeleaEsLaDefensa() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa(1200);
		
		assertEquals(1200, posicion.fuerzaDePelea());
	}
	
	
	@Test
	public void test04LaFuerzaDeRetornoEs0() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa(1200);
		
		assertEquals(0, posicion.fuerzaDeRetorno());
	}
	
	
	@Test
	public void test05ElDanioDeUnAtaqueEs0() {
		
		PosicionDeDefensa posicion = new PosicionDeDefensa(1200);
		
		assertEquals(0, posicion.obtenerDanioDeAtaque(3500));
	}
}
