package modelo;

public class CartaDeCampo {
	
	private EstadoCarta estado;
	
	private Efecto efecto;
	
	
	
	private CartaDeCampo(Efecto unEfecto) {
		
		efecto = unEfecto;
	}
	
	public void invocarBocaAbajo() {
		estado = new EstadoBocaAbajo();
	}
	
	public boolean estaBocaAbajo() {
		return estado.estaBocaAbajo();
	}
	
	public void invocarBocaArriba() {
		estado = new EstadoBocaArriba();
		this.activarEfecto();
	}
	
	public void activarEfecto() {
		
		efecto.activarse();
	}
	
	
	public static CartaDeCampo crearWasteland(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoWasteland(campo);
		
		return (new CartaDeCampo(efecto));
	}
	
	public static CartaDeCampo crearSogen(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoSogen(campo);
		
		return (new CartaDeCampo(efecto));
	}



}
