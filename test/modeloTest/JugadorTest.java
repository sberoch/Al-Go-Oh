package modeloTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.CampoDeJuego;

public class JugadorTest {

	
	@Test
	public void test01UnJugadorComienzaCon8000DeVida() {
		
		Jugador jugador = new Jugador();
		
		assertEquals(8000, jugador.getPuntosDeVida());
	}
	
	
	@Test
	public void test02UnJugadorRecibe1300PuntosDeDanio() {
		
		Jugador jugador = new Jugador();
		
		jugador.recibirDanio(1300);
		
		assertEquals(8000 - 1300, jugador.getPuntosDeVida());
	}
	
	@Test
	public void test03MonstruoDeOponenteAtacaYJugadorPierdeLaDiferenciaEnPuntosDeVida() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000, 0);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1200, 0);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		int esperado = 8000 - 200;
		assertEquals(esperado, jugador.getPuntosDeVida());
		
		
	}
	
	
	@Test
	public void test04MonstruoDeOponenteAtacaYOponentePierdeLaDiferenciaEnPuntosDeVida() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1200, 0);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		int esperado = 8000 - 200;
		assertEquals(esperado, oponente.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test05MonstruoDeOponenteAtacaYSeDestruyenAmbosMonstruosSinPerdidaDeVida() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000, 0);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertTrue(monstruoDelJugador.fueDestruido());
		assertTrue(monstruoDelOponente.fueDestruido());
		
		assertEquals(8000, oponente.getPuntosDeVida());
		assertEquals(8000, jugador.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test06MonstruoDeOponenteAtacaAUnMonstruoConMenosDefensaYNoHayPardidaDeVida() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(0, 1000);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1200, 0);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertEquals(8000, jugador.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test07MonstruoDeOponenteAtacaAUnMonstruoConMasDefensaYNoHayPardidaDeVida() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(0, 1200);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertEquals(8000, oponente.getPuntosDeVida());
		
	}
	
	@Test
	public void test08invocarAgujeroNegroDestruyeTodosLosMonstruos() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000, 0);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		CartaMagica agujeroNegro = CartaMagica.crearAgujeroNegro(campo);
		jugador.invocarCartaMagicaBocaArriba(agujeroNegro);
		
		assertTrue(monstruoDelJugador.fueDestruido());
		assertTrue(monstruoDelOponente.fueDestruido());
		
	}
	
	
	private void darlesCamposAJugadores(Jugador jugador, Jugador oponente) {
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
	}
}
