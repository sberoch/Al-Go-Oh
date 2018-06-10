package modeloTest;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import modelo.CartaMonstruo;

public class CartaMonstruoTest {

	
	@Test
	public void test01UnaCartaMonstruoQueSeInvocaEnAtaqueEstaEnPosicionDeAtaque() {
		
		CartaMonstruo monstruo = new CartaMonstruo();
		
		monstruo.invocarEnPosicionDeAtaque();
		
		assertTrue(monstruo.estaEnPosicionDeAtaque());
	}
	
	
	@Test
	public void test02UnaCartaMonstruoQueSeInvocaEnAtaqueNoEstaEnPosicionDeDefensa() {
		
		CartaMonstruo monstruo = new CartaMonstruo();
		
		monstruo.invocarEnPosicionDeAtaque();
		
		assertFalse(monstruo.estaEnPosicionDeDefensa());
	}
	
	
	@Test
	public void test03UnaCartaMonstruoQueSeInvocaEnDefensaEstaEnPosicionDeDefensa() {
		
		CartaMonstruo monstruo = new CartaMonstruo();
		
		monstruo.invocarEnPosicionDeDefensa();
		
		assertTrue(monstruo.estaEnPosicionDeDefensa());
	}
	
	
	@Test
	public void test04UnaCartaMonstruoQueSeInvocaEnDefensaNoEstaEnPosicionDeAtaque() {
		
		CartaMonstruo monstruo = new CartaMonstruo();
		
		monstruo.invocarEnPosicionDeDefensa();
		
		assertFalse(monstruo.estaEnPosicionDeAtaque());
	}
	
}
