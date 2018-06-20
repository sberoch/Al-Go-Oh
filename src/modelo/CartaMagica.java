package modelo;

public class CartaMagica extends CartaMagiaOTrampa {
	
	private EstadoCarta estado;
	

	
	
	
	private CartaMagica(Efecto unEfecto) {
		
		efecto = unEfecto;
	}
	
	
	public boolean estaBocaAbajo() {
		return estado.estaBocaAbajo();
	}
	
	public void invocarBocaArriba() {
		estado = new EstadoBocaArriba();
		this.activar();
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
