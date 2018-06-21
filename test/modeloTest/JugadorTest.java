package modeloTest;

import static org.junit.Assert.assertTrue;

import org.junit.Rule;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import modelo.Jugador;
import modelo.cartas.CartaDeCampo;
import modelo.cartas.CartaMagica;
import modelo.cartas.CartaMonstruo;
import modelo.exceptions.NoHaySuficientesMonstruosException;
import modelo.exceptions.NoSePuedeRealizarAtaqueException;
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
		
		assertTrue(monstruoDelJugador.fueDestruida());
		assertTrue(monstruoDelOponente.fueDestruida());
		
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
		
		assertTrue(monstruoDelJugador.fueDestruida());
		assertTrue(monstruoDelOponente.fueDestruida());
		
	}
	
	@Test
	public void test09MonstruoRequiereUnSacrificio() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000,400,2);
		CartaMonstruo monstruoQueRequiereUnSacrificio = new CartaMonstruo(1000,400,5);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoQueRequiereUnSacrificio);
		
		assertTrue(unMonstruo.fueDestruida());
		
		
	}
	
	@Test
	public void test10MonstruoRequiereDosSacrificios() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000,400,2);
		CartaMonstruo otroMonstruo = new CartaMonstruo(1000,400,4);
		CartaMonstruo monstruoQueRequiereDosSacrificios = new CartaMonstruo(1000,400,7);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(otroMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoQueRequiereDosSacrificios);
		
		assertTrue(unMonstruo.fueDestruida());
		assertTrue(otroMonstruo.fueDestruida());
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
	
	@Test
	public void test12WastelandTieneElEfectoEsperado() throws Exception {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaMonstruo monstruo1 = new CartaMonstruo(200,200,3);
		CartaMonstruo monstruo2 = new CartaMonstruo(300,300,3);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruo2);
		
		CartaDeCampo wasteland = CartaDeCampo.crearWasteland();
		jugador.invocarCartaDeCampo(wasteland);
		
		//WASTELAND: +200 ATK monstruos del jugador
		//			 +300 DEF monstruos del oponente
		assertTrue(monstruo1.ataque() == 400);
		assertTrue(monstruo2.defensa() == 600);
		
	}
	
	@Test
	public void test13WastelandEsCartaDeCampoYPersisteSuEfecto() throws Exception {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaDeCampo wasteland = CartaDeCampo.crearWasteland();
		jugador.invocarCartaDeCampo(wasteland);
		
		//Invocacion despues de jugar la carta campo.
		CartaMonstruo monstruo1 = new CartaMonstruo(200,200,3);
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		assertTrue(monstruo1.ataque() == 400);
	}
	
	@Test
	public void test14SogenTieneElEfectoEsperado() throws Exception {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaMonstruo monstruo1 = new CartaMonstruo(200,200,3);
		CartaMonstruo monstruo2 = new CartaMonstruo(300,300,3);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruo2);
		
		CartaDeCampo sogen = CartaDeCampo.crearSogen();
		jugador.invocarCartaDeCampo(sogen);
		
		//SOGEN: +500 DEF monstruos del jugador
		//	     +200 ATK monstruos del oponente
		assertTrue(monstruo1.defensa() == 700);
		assertTrue(monstruo2.ataque() == 500);
		
	}
	
	@Test
	public void test15SogenEsCartaDeCampoYPersisteSuEfecto() throws Exception {
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaDeCampo sogen = CartaDeCampo.crearSogen();
		jugador.invocarCartaDeCampo(sogen);
		
		//Invocacion despues de jugar la carta campo.
		CartaMonstruo monstruo1 = new CartaMonstruo(200,200,3);
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		assertTrue(monstruo1.defensa() == 700);
	}
	
	
	@Test
	public void test16UnJugadorRecibeUnAtaqueDirecto() throws NoSePuedeRealizarAtaqueException {
		
		Jugador jugador = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		jugador.asignarCampo(campo);
		
		CartaMonstruo unMonstruo = new CartaMonstruo(1000,400,2);	
		unMonstruo.atacarA(jugador);
			
		assertEquals(7000, jugador.getPuntosDeVida());
	}
	
	
	@Test
	public void test17JugadorRobaCartaDelMazoCorrectamente() {
		
		Jugador jugador = new Jugador();
		
		jugador.llenarMazo();
		jugador.robarCartaDelMazo();
		
		assertEquals(jugador.cartasEnMano(), 1);
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
