package modeloTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import modelo.CampoDeJuego;
import modelo.CartaMonstruo;
import modelo.CartaInsectoComeHombres;
import modelo.Jugador;

public class CartaMonstruoInsectoComeHombresTest {

	@Test
	public void test01ElEfectoDelInsectoSeActiva() throws Exception {
		
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
	
	
	private void darlesCamposAJugadores(Jugador jugador, Jugador oponente) {
		
		CampoDeJuego campo = new CampoDeJuego();
		CampoDeJuego campoEnemigo = new CampoDeJuego();
		
		campo.asignarCampoEnemigo(campoEnemigo);
		campoEnemigo.asignarCampoEnemigo(campo);
		
		jugador.asignarCampo(campo);
		oponente.asignarCampo(campoEnemigo);
	}
}
