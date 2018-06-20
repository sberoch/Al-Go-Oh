package modelo;

public abstract class Carta {
	
	protected EstadoCarta estado;
	
	protected Jugador duenio;
	
	protected String nombre;
	
	public abstract void invocarBocaAbajo(Jugador unJugador, CampoDeJuego unCampo) throws Exception;
	
	public abstract void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) throws Exception;
	
	public boolean tieneDeNombre(String unNombre) {
		
		return (nombre == unNombre);
	}
	
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
