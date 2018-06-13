package modeloTest;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;
import modelo.NoHaySuficientesMonstruosException;
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
	public void test03MonstruoDeOponenteAtacaYJugadorPierdeLaDiferenciaEnPuntosDeVida() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000, 0, 1);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1200, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		int esperado = 8000 - 200;
		assertEquals(esperado, jugador.getPuntosDeVida());
		
		
	}
	
	
	@Test
	public void test04MonstruoDeOponenteAtacaYOponentePierdeLaDiferenciaEnPuntosDeVida() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1200, 0, 1);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		int esperado = 8000 - 200;
		assertEquals(esperado, oponente.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test05MonstruoDeOponenteAtacaYNoHayPerdidaDeVida() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000, 0, 1);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertTrue(monstruoDelJugador.fueDestruido());
		assertTrue(monstruoDelOponente.fueDestruido());
		
		assertEquals(8000, oponente.getPuntosDeVida());
		assertEquals(8000, jugador.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test06MonstruoDeOponenteAtacaAUnMonstruoConMenosDefensaYNoHayPardidaDeVida() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(0, 1000, 1);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1200, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertEquals(8000, jugador.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test07MonstruoDeOponenteAtacaAUnMonstruoConMasDefensaYNoHayPardidaDeVida() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(0, 1200, 1);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertEquals(8000, oponente.getPuntosDeVida());
		
	}
	
	@Test
	public void test08invocarAgujeroNegroDestruyeTodosLosMonstruos() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000, 0, 1);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000, 0, 1);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		CartaMagica agujeroNegro = CartaMagica.crearAgujeroNegro(campo);
		jugador.invocarCartaMagicaBocaArriba(agujeroNegro);
		
		assertTrue(monstruoDelJugador.fueDestruido());
		assertTrue(monstruoDelOponente.fueDestruido());
		
	}
	
	@Test
	public void test09MonstruoRequiereUnSacrificio() throws Exception {
		
		Jugador jugador1 = new Jugador();
		CampoDeJuego campo = new CampoDeJuego();
		jugador1.asignarCampo(campo);
		
		CartaMonstruo monstruo1 = new CartaMonstruo(1000,400,2);
		CartaMonstruo monstruoQueRequiereUnSacrificio = new CartaMonstruo(1000,400,5);
		
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruoQueRequiereUnSacrificio);
		
		assertTrue(monstruo1.fueDestruido());
		
		
	}
	
	@Test
	public void test10MonstruoRequiereDosSacrificios() throws Exception {
		
		Jugador jugador1 = new Jugador();
		CampoDeJuego campo = new CampoDeJuego();
		jugador1.asignarCampo(campo);
		
		CartaMonstruo monstruo1 = new CartaMonstruo(1000,400,2);
		CartaMonstruo monstruo2 = new CartaMonstruo(1000,400,3);
		CartaMonstruo monstruoQueRequiereDosSacrificios = new CartaMonstruo(1000,400,7);
		
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruo2);
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruoQueRequiereDosSacrificios);
		
		assertTrue(monstruo1.fueDestruido());
		assertTrue(monstruo2.fueDestruido());
	}
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void test11SiNoHayMonstruosParaElSacrificioSeLanzaExcepcion() throws Exception {
		
		Jugador jugador1 = new Jugador();
		CampoDeJuego campo = new CampoDeJuego();
		jugador1.asignarCampo(campo);
		
		CartaMonstruo monstruoQueRequiereDosSacrificios = new CartaMonstruo(1000,400,7);
		
		thrown.expect(NoHaySuficientesMonstruosException.class);
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruoQueRequiereDosSacrificios);		
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
