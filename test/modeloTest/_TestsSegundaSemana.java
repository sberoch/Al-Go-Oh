package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import modelo.CampoDeJuego;
import modelo.CartaMagica;
import modelo.CartaMonstruo;
import modelo.Jugador;

public class _TestsSegundaSemana {
	
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
		
		CartaMagica wasteland = CartaMagica.crearWasteland(campo);
		jugador.invocarCartaMagicaBocaArriba(wasteland);
		
		//WASTELAND: +200 ATK monstruos del jugador
		//			 +300 DEF monstruos del oponente
		assertTrue(monstruo1.ataque() == 400);
		assertTrue(monstruo2.defensa() == 600);
		
	}
	
	
	@Test
	public void test02SogenTieneElEfectoEsperado() throws Exception {
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
		
		CartaMagica sogen = CartaMagica.crearSogen(campo);
		jugador.invocarCartaMagicaBocaArriba(sogen);
		
		//SOGEN: +500 DEF monstruos del jugador
		//	     +200 ATK monstruos del oponente
		assertTrue(monstruo1.defensa() == 700);
		assertTrue(monstruo2.ataque() == 500);
		
	}
	
	@Test
	public void test03OllaDeLaCodiciaTieneElEfectoEsperado() throws Exception {
		Jugador jugador = new Jugador();
		
		CartaMagica ollaDeLaCodicia = CartaMagica.crearOllaDeLaCodicia(jugador);
		jugador.invocarCartaMagicaBocaArriba(ollaDeLaCodicia);
		
		//OLLA DE LA CODICIA: +2 cartas a la mano del jugador
		assertTrue(jugador.cartasEnMano() == 2);
		
	}
	
	
	
	@Test
	public void test04FisuraTieneElEfectoEsperado() throws Exception {
		
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
		
		CartaMagica fisura = CartaMagica.crearFisura(campoEnemigo);
		jugador.invocarCartaMagicaBocaArriba(fisura);
		
		
		//FISURA: se destruye el monstruo de menor ataque del enemigo.
		assertTrue(monstruo1.fueDestruido());
		
		
		
		
	}
	
}