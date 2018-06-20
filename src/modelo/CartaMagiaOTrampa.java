package modelo;

public abstract class CartaMagiaOTrampa extends Carta {

	protected Efecto efecto;
	
	public void invocarBocaAbajo(CampoDeJuego unCampo) {
		
		estado = new EstadoBocaAbajo();
		unCampo.jugarBocaAbajo(this);
	}
	
	public abstract void activar();

}
