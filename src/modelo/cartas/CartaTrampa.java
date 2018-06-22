package modelo.cartas;

import modelo.CampoDeJuego;
import modelo.Jugador;
import modelo.exceptions.ModoDeInvocacionInvalidoParaEstaCartaException;

public class CartaTrampa extends CartaMagiaOTrampa {


	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) throws ModoDeInvocacionInvalidoParaEstaCartaException {
		
		throw (new ModoDeInvocacionInvalidoParaEstaCartaException());
		
	}
	
}
