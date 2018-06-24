package modelo.cartas;

import modelo.Jugador;

public class CartaJinzo7 extends CartaMonstruo {
	
	
	public CartaJinzo7() {
		
		super(500, 400, 2, "Jinzo#7", "images/Jinzo7.jpeg");
	}
	
	
	protected boolean puedoAtacarDirectoA(Jugador enemigo) {
		
		return (true);
	}

}
