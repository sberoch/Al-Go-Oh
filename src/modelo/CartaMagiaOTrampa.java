package modelo;

public abstract class CartaMagiaOTrampa extends Carta {

	protected Efecto efecto;
	
	public void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) {
		
		duenio = unJugador;
		
		estado = new EstadoBocaAbajo();
		unCampo.jugarBocaAbajo(this);
	}
	
	public abstract void activar();

}
