package modelo.cartas;

public class CartaRefuerzos extends CartaTrampa {

	
	public boolean activarEnAtaqueAMonstruo(CartaMonstruo atacante, CartaMonstruo atacado) {
		
		atacado.aumentarAtaque(500);
		
		atacante.atacarA(atacado);
		
		return (true);
	}
	
}
