package modelo;

public class CartaTrampa extends CartaMagiaOTrampa {


	
	public void activar() {
		
		efecto.activarse();
	}

	@Override
	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) throws ModoDeInvocacionInvalidoParaEstaCartaException {
		
		throw new ModoDeInvocacionInvalidoParaEstaCartaException();
		
	}
	
}
