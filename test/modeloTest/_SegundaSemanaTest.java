package modeloTest;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import modelo.CampoDeJuego;
import modelo.CartaCilindroMagico;
import modelo.CartaDeCampo;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.CartaRefuerzos;
import modelo.CartaDragonDefinitivoDeOjosAzules;
import modelo.CartaInsectoComeHombres;
import modelo.Jugador;
import modelo.Mano;
import modelo.CartaJinzo7;
import modelo.CartaTrampa;

public class _SegundaSemanaTest {
	
	@Test
	public void test01WastelandTieneElEfectoEsperado() throws Exception {
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
	public void test02WastelandEsCartaDeCampoYPersisteSuEfecto() throws Exception {
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
	public void test03SogenTieneElEfectoEsperado() throws Exception {
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
	public void test04SogenEsCartaDeCampoYPersisteSuEfecto() throws Exception {
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
	public void test05OllaDeLaCodiciaTieneElEfectoEsperado() throws Exception {
		Jugador jugador = new Jugador();
		CampoDeJuego campo = new CampoDeJuego();
		
		jugador.asignarCampo(campo);
		
		jugador.llenarMazo();
		
		CartaMagica ollaDeLaCodicia = CartaMagica.crearOllaDeLaCodicia(jugador);
		jugador.invocarCartaMagicaBocaArriba(ollaDeLaCodicia);
		
		//OLLA DE LA CODICIA: +2 cartas a la mano del jugador
		assertTrue(jugador.cartasEnMano() == 2);
		
	}
	
	
	
	@Test
	public void test06FisuraTieneElEfectoEsperado() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaMonstruo monstruo1 = new CartaMonstruo(200,0,3);
		CartaMonstruo monstruo2 = new CartaMonstruo(500,0,3);
		
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruo2);
		
		CartaMagica fisura = CartaMagica.crearFisura(campo);
		jugador.invocarCartaMagicaBocaArriba(fisura);
		
		
		//FISURA: se destruye el monstruo de menor ataque del enemigo.
		assertTrue(monstruo1.fueDestruida());
	}
	
	
	@Test
	public void test07Jinzo7MePermiteAtacarLosPuntosDeVida() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
		
		CartaJinzo7 jinzo7 = new CartaJinzo7();
		CartaMonstruo unMonstruo = new CartaMonstruo(500,0,3);
		
		oponente.invocarMonstruoEnPosicionDeDefensa(unMonstruo);
		jugador.invocarMonstruoEnPosicionDeAtaque(jinzo7);
		
		//Hay un monstruo en defensa, un monstruo usual no podria atacar directamente al oponente.

		jinzo7.atacarA(oponente);
		
		//JINZO#7: Me permite atacar los puntos de vida del oponente directamente.
		
		assertEquals(7500, oponente.getPuntosDeVida());
	}
	
	
	@Test
	public void test08InvocarDragonDefinitivoDeOjosAzulesSacrifica3DragonesBlancosDeOjosAzules() throws Exception {
		
		Jugador jugador = new Jugador();
		
		this.darleCampoA(jugador);
		
		CartaMonstruo primerDragon = CartaMonstruo.crearDragonBlancoDeOjosAzules();
		CartaMonstruo segundoDragon = CartaMonstruo.crearDragonBlancoDeOjosAzules();
		CartaMonstruo tercerDragon = CartaMonstruo.crearDragonBlancoDeOjosAzules();
		
		this.invocarDosMonstruos(jugador);
		jugador.invocarMonstruoEnPosicionDeAtaque(primerDragon);
		
		this.invocarDosMonstruos(jugador);
		jugador.invocarMonstruoEnPosicionDeAtaque(segundoDragon);
		
		this.invocarDosMonstruos(jugador);
		jugador.invocarMonstruoEnPosicionDeAtaque(tercerDragon);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(new CartaDragonDefinitivoDeOjosAzules());
		
		assertTrue(primerDragon.fueDestruida());
		assertTrue(segundoDragon.fueDestruida());
		assertTrue(tercerDragon.fueDestruida());
	}
	
	
	@Test
	public void test09ElEfectoDelInsectoComeHombresSeActiva() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoOponente = new CartaMonstruo(2000, 1300, 4);
		
		jugador.invocarMonstruoEnPosicionDeDefensa(new CartaInsectoComeHombres());
		
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoOponente);
		
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertTrue(monstruoOponente.fueDestruida());
		
		assertEquals(8000, oponente.getPuntosDeVida());
	}
	
	@Test
	public void test10CilindroMagicoNiegaElAtaqueYLoDevuelveAlJugador() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoOponente = new CartaMonstruo(2000, 1300, 4);
		
		CartaTrampa cilindroMagico = new CartaCilindroMagico();
		jugador.invocarCartaTrampa(cilindroMagico);
		
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoOponente);
		oponente.atacarDirectoALaVidaCon(1);
		
		assertEquals(6000, oponente.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test11RefuerzosModificaElAtaqueDelMonstruoAtacado() throws Exception {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		this.darlesCamposAJugadores(jugador, oponente);
		
		CartaMonstruo monstruoOponente = new CartaMonstruo(2000, 1300, 4);
		CartaMonstruo monstruo = new CartaMonstruo(1600, 1300, 4);
		
		CartaTrampa refuerzos = new CartaRefuerzos();
		jugador.invocarCartaTrampa(refuerzos);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruo);
		
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoOponente);
		oponente.atacarConMonstruoAMonstruoEnemigoConPosiciones(1, 1);
		
		assertEquals(7900, oponente.getPuntosDeVida());
		assertTrue(monstruoOponente.fueDestruida());
		
	}
	
	
	@Test
	public void test12JugadorPierdeCuandoSeAcabaSuMazo() {
		
		Jugador jugador = new Jugador();
		
		while (!jugador.acaboSuMazo()) {
			
			jugador.robarCartaDelMazo();
		}
		
		assertTrue(jugador.perdio());
	}
	
	
	@Test
	public void test13SeCompletoExodiaYGanaElJugador() {
		
		Jugador jugador = new Jugador();
		
		Mano mano = jugador.getMano();
		
		mano.agregarCarta(CartaMonstruo.crearBrazoIzquierdoExodia());
		mano.agregarCarta(CartaMonstruo.crearBrazoDerechoExodia());
		mano.agregarCarta(CartaMonstruo.crearCabezaDeExodia());
		mano.agregarCarta(CartaMonstruo.crearPiernaDerechaExodia());
		mano.agregarCarta(CartaMonstruo.crearPiernaIzquierdaExodia());
		
		assertTrue(jugador.gano());
	}
	
	
	
	
	
	private void darleCampoA(Jugador jugador) {

		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		
		jugador.asignarCampo(campo);
		
	}
	
	
	private void invocarDosMonstruos(Jugador jugador) throws Exception {
		
		jugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(0, 0, 3));
		
		jugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruo(0, 0, 3));
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