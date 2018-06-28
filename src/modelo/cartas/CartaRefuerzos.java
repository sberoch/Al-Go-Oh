package modelo.cartas;

public class CartaRefuerzos extends CartaTrampa {

	
	public CartaRefuerzos() {
		
		nombre = "Refuerzos";
		
		direccionImagen = "images/Refuerzos.jpeg";
	}
	
	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacado.aumentarAtaque(500);
		
		atacante.atacarA(atacado);
		
		this.destruir();
		
		atacado.aumentarAtaque(-500);
		
		return (true);
	}
	
}
