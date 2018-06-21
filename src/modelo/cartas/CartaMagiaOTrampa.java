package modelo.cartas;

import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.estados.EstadoBocaAbajo;

public abstract class CartaMagiaOTrampa extends Carta {
	
	public void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) {
		
		duenio = unJugador;
		
		estado = new EstadoBocaAbajo();
		
		unCampo.jugarBocaAbajo(this);
	}

	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		return (false);
	}
	
	
	public boolean activarEnAtaqueDirecto(CartaMonstruo atacante) {
		
		return (false);
	}

}
