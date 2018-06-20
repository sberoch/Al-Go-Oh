package modeloTest;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import modelo.CampoDeJuego;
import modelo.CartaMonstruo;
import modelo.CartaMonstruoDragonDefinitivoDeOjosAzules;
import modelo.Jugador;

public class DragonDefinitivoDeOjosAzulesTest {

	@Test
	public void test01InvocarDragonDefinitivoDeOjosAzulesSacrifica3DragonesBlancosDeOjosAzules() throws Exception {
		
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
		
		jugador.invocarMonstruoEnPosicionDeAtaque(new CartaMonstruoDragonDefinitivoDeOjosAzules());
		
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
