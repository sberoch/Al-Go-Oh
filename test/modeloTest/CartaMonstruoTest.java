package modeloTest;
	
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import modelo.CampoDeJuego;
import modelo.CartaMonstruo;
import modelo.Jugador;
	
public class CartaMonstruoTest {
	
	
	@Test
	public void test01UnaCartaMonstruoQueSeInvocaEnAtaqueEstaEnPosicionDeAtaque() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo);
		
		assertTrue(monstruo.estaEnPosicionDeAtaque());
	}
	


	@Test
	public void test02UnaCartaMonstruoQueSeInvocaEnAtaqueNoEstaEnPosicionDeDefensa() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo);
		
		assertFalse(monstruo.estaEnPosicionDeDefensa());
	}
	
	
	@Test
	public void test03UnaCartaMonstruoQueSeInvocaEnDefensaEstaEnPosicionDeDefensa() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(monstruo);
		
		assertTrue(monstruo.estaEnPosicionDeDefensa());
	}
	
	
	@Test
	public void test04UnaCartaMonstruoQueSeInvocaEnDefensaNoEstaEnPosicionDeAtaque() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo monstruo = new CartaMonstruo(0, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(monstruo);
		
		assertFalse(monstruo.estaEnPosicionDeAtaque());
	}
	
	
	@Test
	public void test05UnaCartaMonstruoAtacaAOtraCartaConMenosAtaqueYLaDestruye() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1200, 0, 1);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1000, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(otroMonstruo);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(otroMonstruo.fueDestruida());
	}
	
	
	@Test
	public void test06UnaCartaMonstruoAtacaAOtraCartaConMasAtaqueYSeDestruye() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000, 0, 1);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1200, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(otroMonstruo);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(unMonstruo.fueDestruida());
	}
	
	
	@Test
	public void test07UnaCartaMonstruoAtacaAOtraCartaConIgualAtaqueYSeDestruyenAmbas() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000, 0, 1);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1000, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(otroMonstruo);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(unMonstruo.fueDestruida());
		assertTrue(otroMonstruo.fueDestruida());
	}
	
	
	@Test
	public void test08UnaCartaMonstruoAtacaAOtraCartaConMenosDefensaYLaDestruye() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1200, 0, 1);
		CartaMonstruo otroMonstruo = new CartaMonstruo(0, 1000, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeDefensa(otroMonstruo);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertTrue(otroMonstruo.fueDestruida());
	}
	
	
	@Test
	public void test09UnaCartaMonstruoAtacaAOtraCartaConMasDefensaYNoSeDestruye() throws Exception {
		
		Jugador jugador = new Jugador();

		this.darleCampoA(jugador);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000, 0, 1);
		CartaMonstruo otroMonstruo = new CartaMonstruo(0, 1200, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeDefensa(otroMonstruo);
		
		unMonstruo.atacarA(otroMonstruo);
		
		assertFalse(unMonstruo.fueDestruida());
	}
	
	
	private void darleCampoA(Jugador jugador) {

		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		
		jugador.asignarCampo(campo);
		
	}
	
}	
	