package modelo;

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
