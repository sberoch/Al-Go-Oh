package modelo;

public class CartaMagica {
	
	private EstadoCarta estado;
	
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
	}
	
	
}
