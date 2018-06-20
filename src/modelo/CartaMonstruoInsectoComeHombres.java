package modelo;

public class CartaMonstruoInsectoComeHombres extends CartaMonstruo {

	
	public CartaMonstruoInsectoComeHombres() {
		
		super(450, 600, 2, "Insecto Come Hombres");
	}
	
	
	protected int recibirDanio(int unAtaque) {
		
		if (estado.estaBocaAbajo()) {
			
			estado = new EstadoBocaArriba();
			
			return (unAtaque);
		}
		
		if (modo.fuerzaDePelea() <= unAtaque) {
			
			this.destruir();
			
			duenio.recibirDanio(modo.obtenerDanioDeAtaque(unAtaque));
		}
		
		return (modo.fuerzaDeRetorno());
	}
}
