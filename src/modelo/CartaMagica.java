package modelo;

public class CartaMagica extends CartaMagiaOTrampa {
	
	private Efecto efecto;
	
	public CartaMagica(Efecto unEfecto) {
		
		efecto = unEfecto;
	}
	
	

	public void invocarBocaArriba(Jugador unJugador, CampoDeJuego unCampo) {
		
		duenio = unJugador;
		
		estado = new EstadoBocaArriba();
		
		unCampo.jugarBocaArriba(this);
	}
	
	public void activar() {
		
		efecto.activarse();
	}
	
	
	public static CartaMagica crearAgujeroNegro(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoAgujeroNegro(campo);
		
		return (new CartaMagica(efecto));
	}
	
	public static CartaMagica crearOllaDeLaCodicia(Jugador jugador) {
	
		Efecto efecto = new EfectoOllaDeLaCodicia(jugador);
	
		return (new CartaMagica(efecto));
	}
	
	public static CartaMagica crearFisura(CampoDeJuego campoEnemigo) {
		
		Efecto efecto = new EfectoFisura(campoEnemigo);
	
		return (new CartaMagica(efecto));
	}
}
