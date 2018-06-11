package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CartaMonstruo;
import modelo.Jugador;

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
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1000);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1200);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacar(monstruoDelOponente, monstruoDelJugador);
		
		int esperado = 8000 - 200;
		assertEquals(esperado, jugador.getPuntosDeVida());
		
	}
	
	
	@Test
	public void test04MonstruoDeOponenteAtacaYOponentePierdeLaDiferenciaEnPuntosDeVida() {
		
		Jugador jugador = new Jugador();
		Jugador oponente = new Jugador();
		
		CartaMonstruo monstruoDelJugador = new CartaMonstruo(1200);
		CartaMonstruo monstruoDelOponente = new CartaMonstruo(1000);
		
		jugador.invocarMonstruoEnPosicionDeAtaque(monstruoDelJugador);
		oponente.invocarMonstruoEnPosicionDeAtaque(monstruoDelOponente);
		
		oponente.atacar(monstruoDelOponente, monstruoDelJugador);
		
		int esperado = 8000 - 200;
		assertEquals(esperado, oponente.getPuntosDeVida());
		
	}
}
