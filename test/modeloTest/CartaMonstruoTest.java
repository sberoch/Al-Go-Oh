package modeloTest;
	
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import modelo.CartaMonstruo;
import modelo.Jugador;
	
public class CartaMonstruoTest {
	
	
	@Test
	public void test01UnaCartaMonstruoQueSeInvocaEnAtaqueEstaEnPosicionDeAtaque() {
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0);
		
		monstruo.invocarEnPosicionDeAtaque(null);
		
		assertTrue(monstruo.estaEnPosicionDeAtaque());
	}
	
	
	@Test
	public void test02UnaCartaMonstruoQueSeInvocaEnAtaqueNoEstaEnPosicionDeDefensa() {
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0);
		
		monstruo.invocarEnPosicionDeAtaque(null);
		
		assertFalse(monstruo.estaEnPosicionDeDefensa());
	}
	
	
	@Test
	public void test03UnaCartaMonstruoQueSeInvocaEnDefensaEstaEnPosicionDeDefensa() {
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0);
		
		monstruo.invocarEnPosicionDeDefensa(null);
		
		assertTrue(monstruo.estaEnPosicionDeDefensa());
	}
	
	
	@Test
	public void test04UnaCartaMonstruoQueSeInvocaEnDefensaNoEstaEnPosicionDeAtaque() {
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0);
		
		monstruo.invocarEnPosicionDeDefensa(null);
		
		assertFalse(monstruo.estaEnPosicionDeAtaque());
	}
	
	
	@Test
	public void test05UnaCartaMonstruoAtacaAOtraCartaConMenosAtaqueYLaDestruye() {
		
		Jugador jugador = new Jugador();
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1200, 0);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1000, 0);
		
		unMonstruo.invocarEnPosicionDeAtaque(jugador);
		otroMonstruo.invocarEnPosicionDeAtaque(jugador);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(otroMonstruo.fueDestruido());
	}
	
	
	@Test
	public void test06UnaCartaMonstruoAtacaAOtraCartaConMasAtaqueYSeDestruye() {
		
		Jugador jugador = new Jugador();
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000, 0);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1200, 0);
		
		unMonstruo.invocarEnPosicionDeAtaque(jugador);
		otroMonstruo.invocarEnPosicionDeAtaque(jugador);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(unMonstruo.fueDestruido());
	}
	
	
	@Test
	public void test07UnaCartaMonstruoAtacaAOtraCartaConIgualAtaqueYSeDestruyenAmbas() {
		
		Jugador jugador = new Jugador();
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000, 0);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1000, 0);
		
		unMonstruo.invocarEnPosicionDeAtaque(jugador);
		otroMonstruo.invocarEnPosicionDeAtaque(jugador);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(unMonstruo.fueDestruido());
		assertTrue(otroMonstruo.fueDestruido());
	}
	
	
	@Test
	public void test08UnaCartaMonstruoAtacaAOtraCartaConMenosDefensaYLaDestruye() {
		
		Jugador jugador = new Jugador();
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1200, 0);
		CartaMonstruo otroMonstruo = new CartaMonstruo(0, 1000);
		
		unMonstruo.invocarEnPosicionDeAtaque(jugador);
		otroMonstruo.invocarEnPosicionDeDefensa(jugador);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(otroMonstruo.fueDestruido());
	}
	
	
	@Test
	public void test09UnaCartaMonstruoAtacaAOtraCartaConMasDefensaYNoSeDestruye() {
		
		Jugador jugador = new Jugador();
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000, 0);
		CartaMonstruo otroMonstruo = new CartaMonstruo(0, 1200);
		
		unMonstruo.invocarEnPosicionDeAtaque(jugador);
		otroMonstruo.invocarEnPosicionDeDefensa(jugador);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertFalse(unMonstruo.fueDestruido());
	}
	
}	
	