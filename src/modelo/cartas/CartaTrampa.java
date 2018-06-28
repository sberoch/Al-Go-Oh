package modelo.cartas;

import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.exceptions.ModoDeInvocacionInvalidoParaEstaCartaException;

public abstract class CartaTrampa extends CartaMagiaOTrampa {


	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) throws ModoDeInvocacionInvalidoParaEstaCartaException {
		
		throw (new ModoDeInvocacionInvalidoParaEstaCartaException());
		
	}

	
	public boolean esMagica() {
		
		return (false);
	}
	
	
	public boolean esMonstruo() {
		
		return (false);
	}
	
}
