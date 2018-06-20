package modelo;

public abstract class Carta {
	
	protected EstadoCarta estado;
	
	protected Jugador duenio;
	
	public abstract void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) throws Exception;
	
	
	public boolean estaBocaAbajo() {
		
		return estado.estaBocaAbajo();
	}
	
	public void destruir()  {
		
		duenio.enviarAlCementerio(this);
		
	}
	
	public boolean fueDestruida() {
		
		return (duenio.verificarSiEstaEnElCementerio(this));
	}
}
