package modeloTest;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import modelo.CartaMonstruo;
import modelo.Jugador;

public class JugadorTest {

	@Test
	public void test01MonstruoDeOponenteAtacaYJugadorPierdeLaDiferenciaEnPuntosDeVida() {
		
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		CartaMonstruo monstruo1 = new CartaMonstruo();
		monstruo1.setAtaque(1000);
		
		CartaMonstruo monstruo2 = new CartaMonstruo();
		monstruo2.setAtaque(1200);
		
		jugador1.invocarMonstruoEnPosicionDeAtaque(monstruo1);
		jugador2.invocarMonstruoEnPosicionDeAtaque(monstruo2);
		
		jugador2.atacar(monstruo2, monstruo1);
		
		int esperado = 8000 - 200;
		Assert.assertEquals(esperado, jugador1.getPuntosDeVida());
		
	}
}
