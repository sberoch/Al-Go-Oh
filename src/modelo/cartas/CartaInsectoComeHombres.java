package modelo.cartas;

import modelo.estados.EstadoBocaArriba;

public class CartaInsectoComeHombres extends CartaMonstruo {

	
	public CartaInsectoComeHombres() {
		
		super(450, 600, 2, "Insecto Come Hombres", "images/InsectoComeHombres.jpeg");
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
