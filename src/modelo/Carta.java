package modelo;

public abstract class Carta {
	
	protected EstadoCarta estado;
	
	public abstract void invocarBocaAbajo(CampoDeJuego unCampo);
	
	
	public boolean estaBocaAbajo() {
		return estado.estaBocaAbajo();
	}
}
