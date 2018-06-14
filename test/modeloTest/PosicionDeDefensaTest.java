package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import modelo.ModoDeDefensa;

public class PosicionDeDefensaTest {

	
	@Test
	public void test01UnaPosicionDeDefensaEsDeDefensa() {
		
		ModoDeDefensa posicion = new ModoDeDefensa(0);
		
		assertTrue(posicion.esModoDeDefensa());
	}
	
	
	@Test
	public void test02UnaPosicionDeDefensaNoEsDeAtaque() {
		
		ModoDeDefensa posicion = new ModoDeDefensa(0);
		
		assertFalse(posicion.esModoDeAtaque());
	}
	
	
	@Test
	public void test03LaFuerzaDePeleaEsLaDefensa() {
		
		ModoDeDefensa posicion = new ModoDeDefensa(1200);
		
		assertEquals(1200, posicion.fuerzaDePelea());
	}
	
	
	@Test
	public void test04LaFuerzaDeRetornoEs0() {
		
		ModoDeDefensa posicion = new ModoDeDefensa(1200);
		
		assertEquals(0, posicion.fuerzaDeRetorno());
	}
	
	
	@Test
	public void test05ElDanioDeUnAtaqueEs0() {
		
		ModoDeDefensa posicion = new ModoDeDefensa(1200);
		
		assertEquals(0, posicion.obtenerDanioDeAtaque(3500));
	}
}
