package modelo.cartas;

public class CartaCilindroMagico extends CartaTrampa {

	
	public CartaCilindroMagico() {
		
		
		nombre = "Cilindro Magico";
		
		direccionImagen = "images/CilindroMagico.jpeg";
		
	}
	
	
	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacante.atacarATuDuenio();
		
		this.destruir();
		
		return (true);
	}
	
	
	public boolean activarEnAtaqueDirecto(CartaMonstruo atacante) {
		
		atacante.atacarATuDuenio();
		
		this.destruir();
		
		return (true);
	}
	
}
