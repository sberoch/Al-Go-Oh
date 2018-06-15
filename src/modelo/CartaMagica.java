package modelo;

public class CartaMagica {
	
	private EstadoCarta estado;
	
	private Efecto efecto;
	
	
	
	private CartaMagica(Efecto unEfecto) {
		
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
	
	
	public static CartaMagica crearAgujeroNegro(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoAgujeroNegro(campo);
		
		return (new CartaMagica(efecto));
	}
	
	
	public static CartaMagica crearWasteland(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoWasteland(campo);
		
		return (new CartaMagica(efecto));
	}
	
public static CartaMagica crearSogen(CampoDeJuego campo) {
		
		Efecto efecto = new EfectoSogen(campo);
		
		return (new CartaMagica(efecto));
	}
}
