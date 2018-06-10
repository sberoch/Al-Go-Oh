package modelo;

public class CartaTrampa {

private EstadoCarta estado;
	
	public void invocarBocaAbajo() {
		estado = new EstadoBocaAbajo();
	}
	
	public boolean estaBocaAbajo() {
		return estado.estaBocaAbajo();
	}
	
}
