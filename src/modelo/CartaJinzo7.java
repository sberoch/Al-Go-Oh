package modelo;

public class CartaJinzo7 extends CartaMonstruo {
	
	
	public CartaJinzo7() {
		
		super(500, 400, 2);
	}
	
	
	protected boolean puedoAtacarDirectoA(Jugador enemigo) {
		
		return (true);
	}

}
