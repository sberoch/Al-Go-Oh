package modelo;

public class CartaMonstruoJinzo7 extends CartaMonstruo {
	
	
	public CartaMonstruoJinzo7() {
		
		super(500, 400, 2);
	}
	
	
	protected boolean puedoAtacarDirectoA(Jugador enemigo) {
		
		return (true);
	}

}
