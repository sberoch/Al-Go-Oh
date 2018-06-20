package modelo;

public class CartaCilindroMagico extends CartaTrampa {

	
	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacante.atacarATuDuenio();
		
		return (true);
	}
	
	
	public boolean activarEnAtaqueDirecto(CartaMonstruo atacante) {
		
		atacante.atacarATuDuenio();
		
		return (true);
	}
	
}
