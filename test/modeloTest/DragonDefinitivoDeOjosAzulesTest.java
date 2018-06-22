package modeloTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.cartas.CartaDragonDefinitivoDeOjosAzules;
import modelo.cartas.CartaMonstruo;
import modelo.cartas.CreadorDeCartas;

public class DragonDefinitivoDeOjosAzulesTest {

	@Test
	public void test01InvocarDragonDefinitivoDeOjosAzulesSacrifica3DragonesBlancosDeOjosAzules() throws Exception {
		
		Jugador jugador = new Jugador();
		
		this.darleCampoA(jugador);
		
		CartaMonstruo primerDragon = CreadorDeCartas.crearDragonBlancoDeOjosAzules();
		CartaMonstruo segundoDragon = CreadorDeCartas.crearDragonBlancoDeOjosAzules();
		CartaMonstruo tercerDragon = CreadorDeCartas.crearDragonBlancoDeOjosAzules();
		
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
}
